package com.fengwenyi.demo.io.code;

import java.io.UnsupportedEncodingException;

/**
 * @author Wenyi Feng
 */
public class Test1 {

    public static void main(String[] args) {
        String s = "慕课ABC";
        System.out.println(s);
        System.out.println("------------------------------------");
        System.out.println("默认");
        byte[] bytes1 = s.getBytes();
        for (byte b : bytes1) {
            // 把字节（转换成int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("gbk");
        // gbk 中文2个字节，英文1个字节
        try {
            byte[] bytes2 = s.getBytes("gbk");
            for (byte b : bytes2) {
                // 把字节（转换成int）以16进制的方式显示
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("utf-8");
        // utf-8 中文3个字节，英文1个字节

        try {
            byte[] bytes3 = s.getBytes("utf-8");
            for (byte b : bytes3) {
                // 把字节（转换成int）以16进制的方式显示
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("utf-16be");

        // java 是双字节编码 utf-16be
        // 中/英文 都占用2个字节
        byte[] bytes4 = new byte[0];
        try {
            bytes4 = s.getBytes("utf-16be");
            for (byte b : bytes4) {
                // 把字节（转换成int）以16进制的方式显示
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println();

        /*
        当你的字节序列是某种编码时，
        这个时候想把字节序列变成字符串，
        也需要用这种编码方式，否则会出现乱码
         */
        String str1 = new String(bytes4);
        System.out.println(str1);
        String str2 = null;
        try {
            str2 = new String(bytes4, "utf-16be");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str2);

        System.out.println();

        /*
        文本文件，就是字节序列
        可以是任意字节序列
        如果我们在中文机器上直接创建文本文件，
        那么该文本文件只认识ANSI编码
        联通、联这是一种巧合，他们正好符合utf-8编码规则
        ANSI默认就是GBK编码
         */
    }

}
