package com.learn.exception.error_;

public class CustomException {
    public static void main(String[] args) {
        int age = 0;

        if (!(age >= 18 && age <= 120)) {
            throw new ageException("年龄应在 18-120之间");
        }
    }
}


class ageException extends RuntimeException {

    public ageException(String message) {
        super(message);
    }
}