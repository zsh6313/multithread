package com.example.multithread.demo.day01;

import org.openjdk.jol.info.ClassLayout;

/**
 * java object layout java类内存布局
 * 1.markword 8 byte 存放对象锁信息
 * 2.classpointer 4 byte 类指针，指向类型地址
 * 3.instance data 4 byte/个 实例指针，每个实例4个字节
 * 4.padding 0 byte 补齐8的倍数，因为读取以8byte为单位
 *
 * 注意：java 默认是开启了classpointer和oop（ordinary object pointer）的压缩，
 * 如果不压缩，classpointer和instance data都为8byte
 * 可使用 java -XX:+PrintCommandLineFlags -version 查看上述两个压缩是否开启
 */
public class JolTest {
    public static void main(String[] args) {
        User u = new User("张三",3);
        int i = u.hashCode();
        User uu = new User("张三三",3);

        System.out.println(ClassLayout.parseInstance(u).toPrintable());
        System.out.println(ClassLayout.parseInstance(uu).toPrintable());

        synchronized (u) {
            System.out.println(ClassLayout.parseInstance(u).toPrintable());
        }
    }


    static class User{
        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;
    }

    static class Kid{
        public Kid() {
        }

        public Kid(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;
    }
}
