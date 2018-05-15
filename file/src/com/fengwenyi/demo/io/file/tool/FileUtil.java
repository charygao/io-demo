package com.fengwenyi.demo.io.file.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件工具类
 * 列出File的一些常用操作
 * IllegalArgumentException 非法参数异常
 * @author Wenyi Feng
 */
public class FileUtil {

    /**
     * 列出指定目录下的所有文件（包括子目录）
     * @param dir
     */
    public static void listDirectory (File dir) throws IllegalArgumentException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + " 不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录");
        }
        /*String[] fileNames = dir.list(); // 用于列出当前目录下的子目录和文件名称，不包括子目录下的目录和文件
        for (String s : fileNames) {
            System.out.println(s);
        }*/
        File[] files = dir.listFiles(); // 返回的是直接子目录（文件）对象
        /*for (File file : files) {
            System.out.println(file);
        }*/
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归查询字目录
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }


    /**
     * 查找一个目录下所有的文件
     * @param dir 目录
     * @throws IllegalArgumentException 目录不存在，或者不是目录
     */
    public static void findAllFile (File dir) throws IllegalArgumentException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + " 不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录");
        }
        File[] files = dir.listFiles(); // 返回的是直接子目录（文件）对象
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归查询字目录
                    findAllFile(file);
                } else {
                    // System.out.println(file);
                }
            }
        }
    }

    /**
     * 查找一个目录下所有的文件
     * @param dir 目录
     * @return list文件集合
     * @throws IllegalArgumentException 目录不存在，或者不是目录
     */
    public static List<File> findAllFile2 (File dir) throws IllegalArgumentException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + " 不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录");
        }
        File[] files = dir.listFiles(); // 返回的是直接子目录（文件）对象

        // 所有文件
        List<File> fileList = new ArrayList<>();

        // 目录
        LinkedList<File> dirs = new LinkedList<>();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    dirs.add(file);
                } else {
                    fileList.add(file);
                }
            }
        }

        File fileTmp;

        while (!dirs.isEmpty()) {
            fileTmp = dirs.removeFirst(); // 获取第一个目录
            files = fileTmp.listFiles(); // 该目录下所有的文件
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        dirs.add(file);
                    } else {
                        fileList.add(file);
                    }
                }
            }
        }

        return fileList;
    }

}
