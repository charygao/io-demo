package com.fengwenyi.demo.io.randomaccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author Wenyi Feng
 */
public class File1 {

    public static void main(String[] args) throws IOException {
        File dir = new File("E:\\Workspace\\IdeaStudio\\io-demo\\random-access-file\\demo");
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!dir.isDirectory()) {
            System.out.println("新建目录出错");
        }
        File file = new File(dir, "file.dat");
        if (!file.exists()) {
            boolean rs1 = file.createNewFile();
            if (!rs1) {
                System.out.println("创建文件失败");
            }
        }
        if (!file.isFile()) {
            System.out.println("新建文件出错");
        }

        // 我们从构成方法开始
        String mode = "rw";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, mode);
        // 指针的位置
        System.out.println(randomAccessFile.getFilePointer());

        // 现在我们想往里面写点东西
        /*byte a = 'A';
        randomAccessFile.write(a);
        System.out.println(randomAccessFile.getFilePointer());
        randomAccessFile.write(a);
        System.out.println(randomAccessFile.getFilePointer());*/

        /*int b = 0x7fffffff;
        randomAccessFile.write(b >>> 24);
        randomAccessFile.write(b >>> 16);
        randomAccessFile.write(b >>> 8);
        randomAccessFile.write(b);
        System.out.println(randomAccessFile.getFilePointer());*/

        /*int b = 0x7fffffff;
        randomAccessFile.writeInt(b);

        randomAccessFile.seek(0);*/

        String s2 = "中";
        randomAccessFile.writeChars(s2);
        System.out.println(randomAccessFile.getFilePointer());

        randomAccessFile.seek(0);

        // 写进去了吗，读一下
        byte[] c = new byte[(int)randomAccessFile.length()];
        randomAccessFile.read(c);
        System.out.println(Arrays.toString(c));

        String s1 = new String(c, "utf-16be");
        System.out.println(s1);

        randomAccessFile.close();

    }

    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }
}
