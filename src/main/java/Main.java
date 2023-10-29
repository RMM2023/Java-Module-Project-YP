package src.main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people;
        while (true) {
            System.out.println("Введите количество гостей ");
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people <= 1) {
                    System.out.println("Не корректное значение");
                } else {
                    break;
                }
            } else {
                System.out.println("Вы ввели не число. Попробуйте еще раз.");
                scanner.next();
            }
        }

        Calculate calculate = new Calculate(people);
        while (true) {
            System.out.println("Введите название товара:");
            String name = scanner.next();
            System.out.println("Введите цену товара:");
            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();
                calculate.addProduct(name, price);
            } else {
                System.out.println("Вы ввели не число. Попробуйте еще раз.");
                scanner.next();
                continue;
            }

            System.out.println("Добавить еще товара?");
            System.out.println("Введите Завершить для выхода");
            String input = scanner.next();
            if (input.equalsIgnoreCase("Завершить"))
                break;
        }
        calculate.printCheck();
    }
}