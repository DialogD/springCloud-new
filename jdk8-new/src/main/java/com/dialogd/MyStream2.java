package com.dialogd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Author: DJA
 * @Date: 2019/12/6
 */
public class MyStream2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("zhangsan",20,8000));
        employees.add(new Employee("lisi",30,18000));
        employees.add(new Employee("wangwu",40,28000));
        employees.add(new Employee("wangwu",40,28000));

        //查询大于30岁的员工信息
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.getAge() > 30);
        employeeStream.forEach(e-> System.out.println(e));

        //去重的操作  //自动调用equals和hashcode
        System.out.println(employees.stream().distinct().count());

        //跳过第1个
        Stream<Employee> skipStream = employees.stream().skip(1);
        //skipStream.forEach(e-> System.out.println(e));
        skipStream.forEach(System.out::println);

        System.out.println(" = = = = = = = = = = = = ");

        //获取第一个
        Stream<Employee> limitStream = employees.stream().limit(1);
        limitStream.forEach(System.out::println);

        System.out.println(" = = = = = = = = = = = = ");
        //map映射
        Stream<String> mapStream = employees.stream().map(e -> e.getName());
        mapStream.forEach(System.out::println);

        System.out.println(" = = = = = = = = = = = = ");
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> toUpperStream = list.stream().map(String::toUpperCase);
        toUpperStream.forEach(System.out::println);

        System.out.println(" = = = = = = = = = = = = ");
        //按年龄自然排序
        Stream<Integer> sorted = employees.stream().map(Employee::getAge).sorted();
        sorted.forEach(System.out::println);

        System.out.println("-------------定制排序------------------------");
        Stream<Employee> sortedStream2 = employees.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return x.getAge() - y.getAge();
            }
        });
        sortedStream2.forEach(System.out::println);

        System.out.println(" = = = = = = = = = = = = ");

        //初始化數據
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long start = System.currentTimeMillis();
        //long count = values.stream().sorted().count();  //串行计算1575
        long count = values.parallelStream().sorted().count();  //并行计算688
        System.out.println(count);
        long end = System.currentTimeMillis();
        long millis = end-start;
        System.out.println(millis);

    }
}
