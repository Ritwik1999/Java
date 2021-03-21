package oops;

import java.util.Scanner;

public class Product {

    String id;
    String name;
    int sno;
    String company;
    String mfd;
    int price;

    void setDetails() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter serial number, price, id, name, company, manufacturing date:");

        sno = Integer.parseInt(input.nextLine());
        price = Integer.parseInt(input.nextLine());
        id = input.nextLine();
        name = input.nextLine();    
        company = input.nextLine();
        mfd = input.nextLine();
        
    }

    void displayDetails() {
        System.out.println("Product ID: " + name);
        System.out.println("Product Name: " + name);
        System.out.println("Product Serial Number: " + sno);
        System.out.println("Product Company: " + company);
        System.out.println("Product Manufacturing Date: " + mfd);
        System.out.println("Product Price: " + price);
    }

    public static void main(String[] args) {
        Product products[] = new Product[2];

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product();
            products[i].setDetails();
        }

        samsungProducts(products);
        mfdRange(products);
        priceCap(products);
        laptops(products);
    }

    static void samsungProducts(Product products[]) {
        System.out.println("\n---------Samsung products---------");
        for (int i = 0; i < products.length; i++) {
            if (products[i].company.trim().equals("Samsung")) {
                System.out.println(products[i].name);
            }
        }
    }

    static void mfdRange(Product products[]) {
        System.out.println("\n---------Manufactured between 2012 and 2019---------");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            String year = product.mfd.substring(product.mfd.length() - 4);
            if (year.compareTo("2012") >= 0 && year.compareTo("2019") <= 0) {
                System.out.println(products[i].name);
            }
        }
    }

    static void priceCap(Product products[]) {
        System.out.println("\n---------Price greater than 10000---------");
        for (int i = 0; i < products.length; i++) {
            if (products[i].price > 10000) {
                products[i].displayDetails();
            }
        }
    }

    static void laptops(Product products[]) {
        System.out.println("\n---------laptop in their name---------");
        for (int i = 0; i < products.length; i++) {
            if (products[i].name.contains("laptop")) {
                System.out.println(products[i].name);
            }
        }
    }
}