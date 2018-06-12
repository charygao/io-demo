package com.fengwenyi.demo.io.serialize;

import java.io.*;

/**
 * @author Wenyi Feng
 */
public class ExtendsDemo {

    public static void main(String[] args) {
        //testA();
        //testB1();
        testB2();
    }

    /**
     * A：父类实现序列化
     */
    public static void testA() {
        try {
            String fileA = "E:\\Workspace\\IdeaStudio\\io-demo\\serialize-demo\\demo\\fileA.dat";
            ObjectOutputStream oosA = new ObjectOutputStream(new FileOutputStream(fileA));
            A2 a2 = new A2();
            oosA.writeObject(a2);
            System.out.println("------------------------------");
            ObjectInputStream oisA = new ObjectInputStream(new FileInputStream(fileA));
            A2 aa2 = (A2) oisA.readObject();
            System.out.println(aa2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * B1:子类实现序列化
     */
    public static void testB1() {
        try {
            String fileB1 = "E:\\Workspace\\IdeaStudio\\io-demo\\serialize-demo\\demo\\fileB1.dat";
            ObjectOutputStream oosB = new ObjectOutputStream(new FileOutputStream(fileB1));
            B2 b2 = new B2();
            oosB.writeObject(b2);
            System.out.println("------------------------------");
            ObjectInputStream oisB = new ObjectInputStream(new FileInputStream(fileB1));
            B2 bb2 = (B2) oisB.readObject();
            System.out.println(bb2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * B2:子类实现序列化
     */
    public static void testB2() {
        try {
            String fileB2 = "E:\\Workspace\\IdeaStudio\\io-demo\\serialize-demo\\demo\\fileB2.dat";
            ObjectOutputStream oosB = new ObjectOutputStream(new FileOutputStream(fileB2));
            B4 b4 = new B4();
            oosB.writeObject(b4);
            System.out.println("------------------------------");
            ObjectInputStream oisB = new ObjectInputStream(new FileInputStream(fileB2));
            B4 bb4 = (B4) oisB.readObject();
            System.out.println(bb4);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class A implements Serializable {
    public A() {
        System.out.println("A....");
    }
}

class A1 extends A {
    public A1() {
        System.out.println("A1...");
    }
}

class A2 extends A1 {
    public A2() {
        System.out.println("A2...");
    }
}

class B {
    public B() {
        System.out.println("B....");
    }
}

class B1 extends B implements Serializable {
    public B1() {
        System.out.println("B1...");
    }
}
class B2 extends B1 {
    public B2() {
        System.out.println("B2...");
    }
}

class B3 extends B {
    public B3() {
        System.out.println("B3...");
    }
}
class B4 extends B3 implements Serializable {
    public B4() {
        System.out.println("B4...");
    }
}