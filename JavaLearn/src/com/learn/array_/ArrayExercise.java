package com.learn.array_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] =  new Book("a", 100);
        books[1] =  new Book("b", 90);
        books[2] =  new Book("c", 5);
        books[3] =  new Book("d", 300);
//        Arrays.sort()对数组进行排序,Collections.sort()对list集合进行排序
//        Collections.sort();
//        public static <T> void sort(List<T> list, Comparator<? super T> c) {
//            public static <T> void sort(T[] a, Comparator<? super T> c) {

        Arrays.sort(books, new Comparator() {
                @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.price - b1.price;
            }
        });

        System.out.println(Arrays.toString(books));
    }
}


class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}