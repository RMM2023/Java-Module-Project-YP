package src.main.java;

import java.util.ArrayList;
import java.util.List;

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