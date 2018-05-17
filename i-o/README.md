## API

**FileInputStream**

* 构造方法

```
FileInputStream(File file) 
通过打开与实际文件的连接创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 

FileInputStream(String name) 
通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。 
```

* 读取和关闭方法

```
int read() 
从该输入流读取一个字节的数据。  

int read(byte[] b) 
从该输入流读取最多 b.length个字节的数据为字节数组。 

int read(byte[] b, int off, int len) 
从该输入流读取最多 len字节的数据为字节数组。  

void close() 
关闭此文件输入流并释放与流相关联的任何系统资源。  
```

* 注意：

1、read 每次只读一个字节的数组

2、int read(byte[] b, int off, int len) 一次性读取出来并防区b中，最多放len，返回的是实际放入b中的字节大小

3、文件操作完，必须关闭，否则会有意想不到的异常发生

**FileOutputStream**

* 构造方法

```
FileOutputStream(File file) 
创建文件输出流以写入由指定的 File对象表示的文件。 

FileOutputStream(File file, boolean append) 
创建文件输出流以写入由指定的 File对象表示的文件。 

FileOutputStream(String name) 
创建文件输出流以指定的名称写入文件。 

FileOutputStream(String name, boolean append) 
创建文件输出流以指定的名称写入文件。 
```

注意：

1、如果不存在，将创建。

2、参数append表示写入的方式：追加还是覆盖。


* 写入和关闭方法

```
void write(int b) 
将指定的字节写入此文件输出流。  

void write(byte[] b) 
将 b.length个字节从指定的字节数组写入此文件输出流。  

void write(byte[] b, int off, int len) 
将 len字节从位于偏移量 off的指定字节数组写入此文件输出流。 

void flush() 
刷新此输出流并强制任何缓冲的输出字节被写出。  

void close() 
关闭此文件输出流并释放与此流相关联的任何系统资源。  
```

* 注意

1、写入和读取方法结合理解

2、调用flush方法

3、操作完，请关闭

## 复制工具类

```java
/**
 * 文件复制工具类
 * @param file1 复制文件
 * @param file2 粘贴文件
 * @throws IOException IO异常
 */
public static void copy (String file1, String file2) throws IOException {

    File srcFile = new File(file1);
    if (!srcFile.exists())
        throw new IllegalArgumentException("要复制的文件不存在");
    if (!srcFile.isFile())
        throw new IllegalArgumentException("复制的不是一个文件");
    File destFile = new File(file2);
    if (destFile.exists()) {
        if (destFile.isFile()) {
            System.out.println("粘贴位置文件名已存在，将被覆盖");
        }
    } else {
        System.out.println("文件不存在，将创建");
    }

    FileInputStream fin = new FileInputStream(file1);
    FileOutputStream fout = new FileOutputStream(file2);
    int b;
    byte[] bytes = new byte[20 * 1024];
    while ((b = fin.read(bytes, 0, bytes.length)) != -1) {
        fout.write(bytes, 0, b);
        fout.flush();
    }

    fin.close();
    fout.close();

    // 检查是否复制成功
    printHex(file1);
    System.out.println();
    System.out.println("---------------------------------------");
    printHex(file2);
}
```

我们来测试一下，将jdk 1.8 API复制到我们的项目中：

```java
try {
    IOUtil.copy("E:\\API\\jdkapi18chm\\jdk api 1.8.CHM",
            "E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo/jdk_1.8_api.CHM");
} catch (IOException e) {
    e.printStackTrace();
}
```

测试结果：

![要复制的文件](https://upload-images.jianshu.io/upload_images/5805596-568f16d305b151ec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![复制成功](https://upload-images.jianshu.io/upload_images/5805596-9e6f756aa34d3c0b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![复制到的位置](https://upload-images.jianshu.io/upload_images/5805596-53c303954a6a92e2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![看一下是否可以打开](https://upload-images.jianshu.io/upload_images/5805596-ff0278e2065c8a30.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

嗯！没有问题！！！

## 资料

1、本节测试代码：**[i-o](https://link.jianshu.com/?t=https%3A%2F%2Fgithub.com%2Ffengwenyi%2Fio-demo%2Ftree%2Fmaster%2Fi-o)**

2、学习视频：**[文件传输基础——Java IO流](https://link.jianshu.com/?t=https%3A%2F%2Fwww.imooc.com%2Flearn%2F123)**


