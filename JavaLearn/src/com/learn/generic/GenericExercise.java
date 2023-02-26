package com.learn.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenericExercise {
    public static void main(String[] args) {
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("jack", new Student("jack", 24));
        hashMap.put("mary", new Student("mary", 23));
        hashMap.put("john", new Student("john", 21));


        Set<String> stringSet = hashMap.keySet();
        for (String s : stringSet) {
            System.out.println(s + "-" + hashMap.get(s));
        }
        System.out.println("----------iter 遍历方法---------");
        Set<Map.Entry<String, Student>> entry = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }


        System.out.println("----------Map.Entry 遍历方法---------");
        for (Map.Entry<String, Student> stringStudentEntry : hashMap.entrySet()) {
            System.out.println(stringStudentEntry.getKey() + "-" + stringStudentEntry.getValue());
        }
    }
}


class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

