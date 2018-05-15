package com.fengwenyi.demo.io.file;

import com.fengwenyi.demo.io.file.tool.FileUtil;

import java.io.File;

/**
 * 测试 FileUtil
 * @author Wenyi Feng
 */
public class Test2 {

    public static void main(String[] args) {
        // FileUtil.listDirectory(new File("E:\\Workspace\\IdeaStudio\\io-demo\\file\\notDir"));
        // FileUtil.listDirectory(new File("E:\\Workspace\\IdeaStudio\\io-demo\\file"));
        FileUtil.listDirectory(new File("E:\\Workspace\\IdeaStudio\\io-demo"));
    }
}
