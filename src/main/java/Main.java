import java.util.Scanner;

public class Main {
    public static class Product {
        String name;
        double price;

        Product(String productName, double productPrice) {
            name = productName;
            price = productPrice;
        }
    }
    public static class Calculator {
        String productNames = "";
        double productPrices = 0;

        void addProduct(Product p) {
            productPrices = productPrices + p.price;
            productNames = productNames.concat(p.name).concat("\n");
            System.out.println("Товар успешно добавлен!");
        }

        double divideByAll (int guests) {
            return productPrices / guests;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            guests = scanner.nextInt();
            if (guests > 1) {
                break;//тут работаем с калькулятором
            } else if (guests == 1) {
                System.out.println("нет смысла ничего считать и делить");
            } else {
                System.out.println("Это некорректное значение для подсчёта");
            }
        }
        // System.out.println("Вас " + guests + " человек");

        Calculator calc = new Calculator();
        while (true) {
            System.out.println("Введите наименование товара или 'Завершить'");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }
            else {
                System.out.println("Введите стоимость товара");
                double productPrice = scanner.nextDouble();
                Product newProduct = new Product(productName, productPrice);
                calc.addProduct(newProduct);
            }
        }
        System.out.println("Добавленные товары:");
        System.out.println(calc.productNames);
        double result = calc.divideByAll(guests);
        System.out.printf("Каждый должен заплатить по: %.2f", result);
    }
}


