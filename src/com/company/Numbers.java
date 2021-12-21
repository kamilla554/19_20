package com.company;

import java.util.*;

public class Numbers {
    ArrayList<String> numbers = new ArrayList<>();

    Numbers(int n){
        char letters[] = { 'A', 'B', 'E', 'K', 'M', 'H',
                'O', 'P', 'C', 'T', 'Y', 'X'};
        char numb[] = {'0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9'};
        int region;
        int lett;
        Random rand = new Random();
        String number;
        for (int i=0; i<n; i++) {
            String nextNumb = Character.toString(numb[rand.nextInt(numb.length)]);
            region = rand.nextInt(200);
            if (region<10) {
                number = (letters[rand.nextInt(letters.length)] + nextNumb + nextNumb +
                        nextNumb + letters[rand.nextInt(letters.length)] + letters[rand.nextInt(letters.length)]
                        + "0" + Integer.toString(region));
                numbers.add(number); //добавляем сгенерированный номер в лист номеров
            }
            else {
                number = (letters[rand.nextInt(letters.length)] + nextNumb + nextNumb + nextNumb +
                        letters[rand.nextInt(letters.length)] +
                        letters[rand.nextInt(letters.length)] + Integer.toString(region));
                numbers.add(number); //добавляем сгенерированный номер в лист номеров
            }
        }
    }

    public void print() {
        System.out.println("Сгенерированные номера:"+"\n");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + "\n");
        }
    }

    void find1(String input) {
        System.out.println("\n"+"<Поиск прямым перебором по ArrayList>");
        long m = System.currentTimeMillis();
        if (numbers.contains(input)) {
            System.out.print("Номер найден, ");
        }
        else System.out.print("Номер не найден, ");
        System.out.print("поиск занял " + (double) (System.currentTimeMillis() - m) + " мс");
    }

    void find2(String input) {
        System.out.println("\n"+"<Бинарный поиск>");
        Collections.sort(numbers);
        int index = -1;
        long m = System.currentTimeMillis();
        index = Collections.binarySearch(numbers, input);
        if (index!=-1) {
            System.out.print("Номер найден, ");
        }
        else System.out.print("Номер не найден, ");
        System.out.print("поиск занял " + (double) (System.currentTimeMillis() - m) + " мс");
    }

    void find3(String input) {
        System.out.println("\n"+"<Поиск в HashSet>");
        long m = System.currentTimeMillis();
        Set<String> set = new HashSet<>(numbers);
        if (set.contains(input)) {
            System.out.print("Номер найден, ");
        }
        else System.out.print("Номер не найден, ");
        System.out.print("поиск занял " + (double) (System.currentTimeMillis() - m) + " мс");
    }

    void find4(String input) {
        System.out.println("\n"+"<Поиск в TreeSet>");
        long m = System.currentTimeMillis();
        TreeSet set = new TreeSet<>(numbers);
        if (set.contains(input)) {
            System.out.print("Номер найден, ");
        }
        else System.out.print("Номер не найден, ");
        System.out.print("поиск занял " + (double) (System.currentTimeMillis() - m) + " мс");
    }
}