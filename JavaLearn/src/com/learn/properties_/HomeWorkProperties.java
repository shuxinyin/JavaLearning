package com.learn.properties_;

import java.io.*;
import java.util.Properties;

public class HomeWorkProperties {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String propPath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/dog.properties";

        Properties properties = new Properties();
        properties.load(new FileReader(propPath));


        Dog dog = new Dog(properties.getProperty("name"),
                Integer.parseInt(properties.getProperty("age")),
                properties.getProperty("color"));

        System.out.println(dog);

        String serializePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializePath));
        oos.writeObject(dog);

        oos.close();

        m1();

    }


    // 反序列化
    public static void m1() throws IOException, ClassNotFoundException {
        String serializePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializePath));

        Dog dog = (Dog) ois.readObject();

        System.out.println("反序列化： " + dog);
        ois.close();

    }
}


class Dog implements Serializable {
    public String name;
    public int age;
    public String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}