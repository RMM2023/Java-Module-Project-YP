import java.util.ArrayList;
import java.util.List;
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

class Calculate{
    private List<Product> list = new ArrayList<>();
    private int people;
    public Calculate(int people){
        this.people=people;
    }
    public void addProduct(String name, double price){
        Product newProduct = new Product(name, price);
        list.add(newProduct);
    }
    public double getTotal() {
        double total = 0;
        for(Product i: list){
            total = total + i.getPrice();
        }
        return total;
    }
    public void printCheck(){
        System.out.println("Чек:");
        for (Product i:list){
            System.out.println(i.getName());
        }
        double personPrice = getTotal()/people;
        String ruble = Formatter.formatRuble(personPrice);
        System.out.println("С каждого: " + personPrice + ruble);
    }
}
class Product{
    private String name;
    private double price;
    public Product(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
class Formatter{
    public static String formatRuble(double value) {
        String formatted = String.format("%.2f", value);
        int rubles = (int)Math.floor(value);
        String ruble = getRuble(rubles);
        return formatted + " " + ruble;
    }
    public static String getRuble(int rubles){
        if (rubles % 10 == 1 && rubles % 100 != 11){
            return " рубль";
        }
        else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)){
            return " рубля";
        }else {
            return " рублей";
        }
    }
}