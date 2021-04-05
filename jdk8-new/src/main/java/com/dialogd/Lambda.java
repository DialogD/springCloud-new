package com.dialogd;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: DJA
 * @Date: 2019/12/6
 */
public class Lambda {
    public static void main(String[] args) {
        //匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1..Lambda");
            }
        };
        new Thread(runnable).start();
        //Lambda表达式
        Runnable runnable2 = ()->{
            System.out.println("runnable2...Lambda");
        };
        new Thread(runnable2).start();

        new Thread(()->{
            System.out.println("hello,Lambda..");
        }).start();


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
        TreeSet<String> set = new TreeSet<>(comparator);

        //lambda表达式
        Comparator<String> comparator2 = (o1,o2)->o1.length()-o2.length();
        TreeSet<String> set2 = new TreeSet<>(comparator2);

        TreeSet<String> set3 = new TreeSet<>((o1,o2)->o1.length()-o2.length());
    }
}
