package com.fengwenyi.demo.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Wenyi Feng
 */
public class Test1 {

    public static void main(String[] args) {
        // 了解构造函数
        File file = new File("E:\\Workspace\\IdeaStudio\\io-demo\\file\\file\\javaio.txt");
        // File.separator 分割符
        // File file = new File("E:" + File.separator + "Workspace\\IdeaStudio\\io-demo\\file\\file\\javaio.txt");
        System.out.println(file.exists());

        File file1 = new File("E:\\Workspace\\IdeaStudio\\io-demo\\file\\file\\java_io");
        System.out.println(file1.exists());

        /*if (!file1.exists()) {
            // 创建
            file1.mkdir();
            // 多级目录创建
            // file1.mkdirs();
        } else {
            // 删除
            file1.delete();
        }*/

        // 是否是一个目录(不是目录，或者目录不存在返回false)
        System.out.println(file1.isDirectory());
        // 是否是一个文件
        System.out.println(file1.isFile());

        //
        File file2 = new File("E:\\Workspace\\IdeaStudio\\io-demo\\file\\file\\javaio2.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            /*boolean rs = file2.delete();
            System.out.println(rs);*/
        }

        File file3 = new File("E:\\Workspace\\IdeaStudio\\io-demo\\file\\file", "javaio2.txt");
        System.out.println(file3.exists());

        System.out.println(file); // file.toString()
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile().getAbsolutePath());
    }

}
