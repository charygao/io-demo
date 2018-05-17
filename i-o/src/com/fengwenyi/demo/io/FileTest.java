package com.fengwenyi.demo.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Wenyi Feng
 */
public class FileTest {

    public static void main(String[] args) {
        // FileInputStream
        /*try {
            IOUtil.printHex("E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\src\\com\\fengwenyi\\demo\\io\\IOUtil.java");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //System.out.println(0xf);

        /*try {
            IOUtil.printHexByByteArray("E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\src\\com\\fengwenyi\\demo\\io\\IOUtil.java");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*try {
            IOUtil.write("E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo/out.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            /*IOUtil.copy("E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo/out.dat",
                    "E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo/copy.dat");*/

            IOUtil.copy("E:\\API\\jdkapi18chm\\jdk api 1.8.CHM",
                    "E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo/jdk_1.8_api.CHM");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
