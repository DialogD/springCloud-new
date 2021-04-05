package com.dialogd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: DJA
 * @Date: 2019/12/6
 * StreamAPI 针对集合或数据进行操作
 * 关注的是做什么，而不是怎么去做
 */
public class MyStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("hello");
        list.add("stream");

        long count = 0;
        for (String s : list) {
            if (s.length()>3){
                count++;
            }
        }
        System.out.println(count);

        //Stream结合Lambda表达式
        //1.链式编程 2.函数式接口  3.Lambda表达式
        //Stream<String> stringStream = list.stream().filter(l -> l.length() > 3);
        long count2 = list.stream().filter(l->l.length()>3).count();

        System.out.println(count2);

        int[] arrays = new int[]{1,2,3};
        IntStream stream = Arrays.stream(arrays);
        System.out.println(stream.filter(a -> a > 1).count());

    }
}
