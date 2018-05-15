package com.fengwenyi.demo.io.file.tool;

import java.io.File;
import java.util.List;

/**
 * 测试 FileUtil
 * @author Wenyi Feng
 */
public class Test3 {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        FileUtil.findAllFile(new File("c:"));
        long time2 = System.currentTimeMillis();

        List<File> fileList = FileUtil.findAllFile2(new File("c:"));
        /*for (File file : fileList) {
            System.out.println(file);
        }*/
        long time3 = System.currentTimeMillis();

        System.out.println("列出文件共：" + fileList.size());
        System.out.println("采用递归花费：" + (time2 - time1));
        System.out.println("采用非递归花费：" + (time3 - time2));
    }
}
