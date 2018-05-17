package com.fengwenyi.demo.io;

import java.io.*;

/**
 * @author Wenyi Feng
 */
public class IOUtil {

    /**
     * 读取指定文件内容，按照16进制输出
     * 并且每输出10byte换行
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = fin.read()) != -1) {
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        fin.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        byte[]  buf = new byte[20 * 1024];

        // 从fin中批量读取字节，放入到buf这个字节数组中，
        // 从0的位置开始放，最多放buf.length个，
        // 返回的是读取字节的个数
        /*int bytes = fin.read(buf, 0, buf.length); // 一次性读完，说明字节数组足够大
        int j = 0;
        for (int i = 0; i < bytes; i++) {
            if (buf[i] < 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i]) + " ");
            if (j++ % 10 == 0) {
                System.out.println();
            }
        }*/
        int bytes = 0;
        int j = 1;
        while ((bytes = fin.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                // byte 8位， int类型32类
                // 为了避免数据类型转换出错，
                // 可以用& 0xff 将高24位清零
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static void write (String fileName) throws IOException {
        // 如果该文件不存在，直接创建
        // 存在，删除后创建
        FileOutputStream fout = new FileOutputStream(fileName);
        fout.write('A'); // 写出了'A'的低8位
        fout.write('B'); // 写出了'B'的低8位
        // 写int
        int a = 2;
        fout.write((a >>> 24) & 0xFF);
        fout.write((a >>> 16) & 0xFF);
        fout.write((a >>>  8) & 0xFF);
        fout.write((a >>>  0) & 0xFF);

        // 写字节数组
        byte[] bytes = "中国".getBytes("UTF-8");
        fout.write(bytes);

        fout.close();

        // 打印写的
        printHex(fileName);
    }

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

}
