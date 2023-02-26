package com.learn.extend;

public class ExtendExercise02 {
    public static void main(String[] Args) {
        C c = new C();
    }

}

class A{
    public A() {
        System.out.println("Here is classA");
    }
}


class B extends A {
    public B(){
        System.out.println("Here is without-parameter of classB ");
    }

    public B(String name){
//        super();
        System.out.println(name + " Here is with-parameter of classB ");
    }
}


class C extends B {
    public C(){
        this("hello");  // 调用自己的有参构造函数
        System.out.println("Here is without-parameter of classC ");
    }

    public C(String name){
        super("call from C");
        System.out.println(name + " Here is with-parameter of classC ");
    }
}

