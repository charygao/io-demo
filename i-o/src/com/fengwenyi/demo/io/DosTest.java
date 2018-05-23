package com.fengwenyi.demo.io;

import java.io.*;

/**
 * @author Wenyi Feng
 */
public class DosTest {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo\\data.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(filePath)));

        dos.write('A');
        dos.writeInt(10);
        dos.writeBoolean(true);
        dos.writeByte(-1);
        dos.writeChar('B');
        // 采用UTF-16BE
        dos.writeChars("中国");
        dos.writeUTF("中国");
        dos.writeDouble(20.10);
        dos.writeFloat(10.20f);
        dos.writeLong(100000000L);

        dos.close();

        IOUtil.printHex(filePath);
    }
}
