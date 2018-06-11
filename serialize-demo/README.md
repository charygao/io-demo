# serialize-demo

## 前言

以前看别人博客，设计到操作，都会让实现 Serializable，知道这叫序列化与反序列化，但什么是序列化与反序列化，不得而知，最近在深入学习IO专题，也就学习下序列化与反序列化。也接触到ArrayList源码，再一次佩服写jdk的那些大神。

## 概要

序列化与反序列化，应该叫对象的序列化与反序列化。

对象的序列化，就是将Object转换成byte序列，反之叫对象的反序列化。

序列化流（ObjectOutputStream），是过滤流 ----> writeObject
反序列化流（ObjectInputStream）                  -----> readObject

## 序列化接口（Serializable）

对象必须实现序列化接口，才能实现序列化，否则将出现异常。

这个接口，里面没有任何方法，这只是一个标准。

## 对象序列化

1、序列化代码

```java
// 序列化
public static void test1(String file) {
    try {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        Student student = new Student(1, "张三", 20);
        oos.writeObject(student);
        oos.flush();
        oos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

2、前面说到必须实现序列化接口，那我们实现看看会有什么异常

```java
package com.fengwenyi.demo.io.serialize;

/**
 * @author Wenyi Feng
 */
public class Student {

    private String no;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    // getter , setter and toString

}
```

测试结果：

![序列化-未实现序列化接口.png](https://upload-images.jianshu.io/upload_images/5805596-ebd3d2aab8c97b12.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3、实现序列化接口并完善

对象实现序列化

```java
package com.fengwenyi.demo.io.serialize;

import java.io.Serializable;

/**
 * @author Wenyi Feng
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1591370122074648558L;

    private String no;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    // getter , setter and toString

}
```

反序列化

```java
// 反序列化
public static void test2(String file) {
    try {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        Student student = (Student) ois.readObject();
        System.out.println(student.toString());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
```

测试代码：

```java
public static void main(String[] args) {
    String file = "E:\\Workspace\\IdeaStudio\\io-demo\\serialize-demo\\demo\\obj.dat";
    test1(file);
    test2(file);
}
```

测试结果：

![序列化-反序列化结果.png](https://upload-images.jianshu.io/upload_images/5805596-e7007a67a15b83b4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 通过ArrayList源码学习transient关键字

transient关键字引入

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData; // non-private to simplify nested class access

序列化：

    /**
     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     *             instance is emitted (int), followed by all of its elements
     *             (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException{
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

反序列化：

    /**
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }

为什么要这么做呢？

有两点：

1、String 已实现序列化接口，Ineger并没有实现

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {


public final class Integer extends Number implements Comparable<Integer> {
````

是不是就是这个原因呢？显然不是，因为刚刚我们已经证明了。

2、数组需要提前预定数组大小，当然，我们设定的大小并没有完全填满，这就不需要都去序列化。

```java
for (int i=0; i<size; i++) {
    s.writeObject(elementData[i]);
}
```

## 后记

序列化与反序列化到底有什么用，还不清楚，还得继续学习。

1、本节测试代码：[serialize-demo](https://github.com/fengwenyi/io-demo/tree/master/serialize-demo)

2、学习视频：[文件传输基础——Java IO流](https://www.imooc.com/learn/123)






