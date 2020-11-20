package Behavioral_model;

import java.util.*;

//public class Store {
//
//    Customer customer;
//    Admin admin;
//
//    private Map<String, Product> products = new HashMap<>();
//
//    public void addNewProduct(String name, double price) {
//        Product p = new Product(name, price);
//
//        products.put(p.getName(),p);
//        //通知用户
//        customer.onPublished(p);
//        //通知管理员
//        admin.onPublish(p);
//    }
//    public void setProductprice(String name,double price){
//        Product p=products.get(name);
//        p.setPrice(price);
//        // 通知用户:
//        customer.onPriceChanged(p);
//        // 通知管理员:
//        admin.onPriceChanged(p);
//
//    }
//}


public class Store implements ProductObservable{
    private final List<ProductObserver> observers = new ArrayList<>();
    private final Map<String, Product> products = new HashMap<>();

    // 注册观察者:
    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    // 取消注册:
    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);

        observers.forEach(o -> o.onPublished(p));
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);

        observers.forEach(o -> o.onPriceChanged(p));
    }

}

interface ProductObserver {
    void onPublished(Product product);

    void onPriceChanged(Product product);

}

interface ProductObservable {
    void addObserver(ProductObserver observer);

    void removeObserver(ProductObserver observer);
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    @Override
    public String toString() {
        return String.format("{Product:name=%s,price=%s}", name, price);
    }
}


//class Main {
//
//    public static void main(String[] args) {
//        // observer:
//        Admin a = new Admin();
//        Customer c = new Customer();
//        // store:
//        Store store = new Store();
//        // register:
//        store.addObserver(a);
//        store.addObserver(c);
//        // 注册匿名观察者:
//        store.addObserver(new ProductObserver() {
//            @Override
//            public void onPublished(Product product) {
//                System.out.println("[Log] on product published: " + product);
//            }
//
//            @Override
//            public void onPriceChanged(Product product) {
//                System.out.println("[Log] on product price changed: " + product);
//            }
//        });
//        // operation:
//        store.addNewProduct("Design Patterns", 35.6);
//        store.addNewProduct("Effective Java", 50.8);
//        store.setProductPrice("Design Patterns", 31.9);
//    }
//}

class Customer implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        System.out.println("[Customer] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        System.out.println("[Customer] on product price changed: " + product);
    }
}

class Admin implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        System.out.println("[Admin] on product published: " + product);
    }

    @Override
    public void onPriceChanged(Product product) {
        System.out.println("[Admin] on product price changed: " + product);
    }
}

