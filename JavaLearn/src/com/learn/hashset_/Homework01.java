package com.learn.hashset_;

import java.util.HashSet;
import java.util.Objects;

public class Homework01 {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();

        hashSet.add(new Employ("jack", 23000, new MyDate(1995, 8, 31)));
        hashSet.add(new Employ("jack", 23000, new MyDate(1995, 8, 31)));
        hashSet.add(new Employ("jackson", 20000, new MyDate(1995, 8, 31)));

        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
}


class Employ{
    private String name;
    private int sal;
    private MyDate birthday;

    public Employ(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return name.equals(employ.name) &&
                birthday.equals(employ.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}


class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}