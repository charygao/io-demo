package com.fengwenyi.demo.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Wenyi Feng
 */
public class DisTest {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\Workspace\\IdeaStudio\\io-demo\\i-o\\demo\\data.dat";

        DataInputStream dis = new DataInputStream(new FileInputStream(new File(filePath)));

        System.out.println(dis.read());
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readByte());
        System.out.println(dis.readChar());

        // chars
        System.out.println(dis.readChar());
        System.out.println(dis.readChar());

        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        System.out.println(dis.readFloat());
        System.out.println(dis.readLong());

        dis.close();

    }
}
