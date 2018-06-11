package com.fengwenyi.demo.io.serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Wenyi Feng
 */
public class Test {

    public static void main(String[] args) {
        String file = "E:\\Workspace\\IdeaStudio\\io-demo\\serialize-demo\\demo\\obj.dat";
        test1(file);
        test2(file);
    }

    // 序列化
    public static void test1(String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(file));
            Student student = new Student("12345", "张三", 20);
            oos.writeObject(student);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 反序列化
    public static void test2(String file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(file));
            Student student = (Student) ois.readObject();
            System.out.println(student.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
