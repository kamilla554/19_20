package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество номеров: ");
        int n = in.nextInt();
        Numbers numbers = new Numbers(n);
        numbers.print();
        System.out.println("Введите номер: ");
        String input = in.next();
        numbers.find1(input);
        numbers.find2(input);
        numbers.find3(input);
        numbers.find4(input);
    }
}