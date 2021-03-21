package oops;

public class Product {

    String id;
    String name;
    int sno;
    String company;
    String mfd;
    int price;

    Product(String id, String name, int sno, String company, String mfd, int price) {
        this.id = id;
        this.name = name;
        this.sno = sno;
        this.company = company;
        this.mfd = mfd;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Product ID: " + name);
        System.out.println("Product Name: " + name);
        System.out.println("Product Serial Number: " + sno);
        System.out.println("Product Company: " + company);
        System.out.println("Product Manufacturing Date: " + mfd);
        System.out.println("Product Price: " + price);
        System.out.println();
    }

    public static void main(String[] args) {
        Product products[] = new Product[5];

        products[0] = new Product("P1", "Galaxy A15", 1, "Samsung", "25dec2015", 20000);
        products[1] = new Product("P2", "Eleczy...", 2, "Harley", "15aug2011", 100000);
        products[2] = new Product("P3", "Yogabook 13 laptop", 3, "Lenovo", "26jan2018", 65000);
        products[3] = new Product("P4", "Wireless Headphones", 4, "MiVi", "14feb2019", 5000);
        products[4] = new Product("P5", "Galaxy Earbuds", 5, "Samsung", "25dec2021", 10000);

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