package main;

import validator.Validator;

public class Test {
    public static void main(String[] args) {
        String string="456123Adds /* ; jhkcjnckhfsjhk";
        String string1="aaa@gmail.com";
        System.out.println(Validator.isValidCompanyName(string));
        System.out.println(Validator.isValidEmail(string1));

    }
}
