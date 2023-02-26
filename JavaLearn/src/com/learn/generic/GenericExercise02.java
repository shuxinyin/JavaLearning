package com.learn.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee("jack", 2900.0, new MyDate("1995", "06", "09")));
        arrayList.add(new Employee("jack", 2800.0, new MyDate("1996", "11", "04")));
        arrayList.add(new Employee("tom", 1900.0, new MyDate("1997", "04", "05")));


        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)) {
                    System.out.println("类型不正确");
                    return 0;
                }
                if (o1.getName().equals(o2.getName())) {
                    return o2.getBirthday().toString().compareTo(o1.getBirthday().toString());
                } else {
                    return o1.getName().compareTo(o1.getName());
                }
            }
        });

        for (Employee employee : arrayList) {
            System.out.println(employee);
        }

    }
}


class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}


class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}