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
        try {
            byte[] bytes4 = s.getBytes("utf-16be");
            for (byte b : bytes4) {
                // 把字节（转换成int）以16进制的方式显示
                System.out.print(Integer.toHexString(b & 0xff) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
