package src.main.java;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int people;
        while (true){
            System.out.println("Введите количество гостей ");
            people = scanner.nextInt();
            if (people<=1){
                System.out.println("Не корректное значение");
            }else{
                break;
            }
        }
        Calculate calculate = new Calculate(people);
        while (true){
            System.out.println("Введите название товара:");
            String name = scanner.next();
            System.out.println("Введите цену товара:");
            double price = scanner.nextDouble();
            calculate.addProduct(name, price);
            System.out.println("Добавить еще товара? \nВведите Завершить для выхода");
            String input = scanner.next();
            if (input.equalsIgnoreCase("Завершить"))
                break;
        }
        calculate.printCheck();
    }
}