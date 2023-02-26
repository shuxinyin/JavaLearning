package com.learn.generic;


import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {
        Object o = new String("abc");

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<A> list3 = new ArrayList<>();
        ArrayList<B> list4 = new ArrayList<>();

        printDem01(list1);
//        printDem02(list1);  //Error
//        printDem02(list2);  //Error
        printDem02(list3);
        printDem02(list4);
        printDem03(list3);
    }

    // ？ 表示 接受任意的泛型类型
    public static void printDem01(List<?> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    // ？ extends A 表示 上限， 可以接受 AA或者AA子类
    public static void printDem02(List<? extends A> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }


    // ？ super 表示下限 支持A类及其 父类
    public static void printDem03(List<? super A> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }
}


class A {
}

class B extends A {
}

class C extends B {
}



class Apple<T, R, M>{ // 自定义泛型类

    public <E> void fly(E e){  // 泛型方法
        System.out.println("---");
    }

    public void run(T e){  // 修饰符后没有<T, R >, 不是泛型方法， 使用了泛型
        System.out.println("---");
    }
}