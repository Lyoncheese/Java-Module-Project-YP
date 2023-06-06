import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double getDouble (Scanner scanner) {
        try {
            double num = scanner.nextDouble();
            return num;
        }
        catch (InputMismatchException e) {
            System.out.println("Это некорректное значение для подсчёта!");
            return 0;
        }
    }
    public static class Formatter {
        void printWithRubles (double x) {
            int cutPoint = (int) Math.floor(x);
            int rest = cutPoint % 10;
            int rest1 = cutPoint % 100;
            if (rest1 >= 10 && rest1 <= 19) {
                System.out.printf("%.2f Рублей", x);
            }
            else if (rest == 0 || rest >= 5 && rest <= 9) {
                System.out.printf("%.2f Рублей", x);
            }
            else if (rest == 1) {
                System.out.printf("%.2f Рубль", x);
            }
            else if (rest >= 2 && rest <= 4) {
                System.out.printf("%.2f Рубля", x);
            }
        }
    }
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
                double productPrice = getDouble(scanner);
                if (productPrice > 0) {
                    Product newProduct = new Product(productName, productPrice);
                    calc.addProduct(newProduct);
                }
            }
        }
        System.out.println("Добавленные товары:");
        System.out.println(calc.productNames);
        double result = calc.divideByAll(guests);
        System.out.print("Каждый должен заплатить по: ");

        Formatter f = new Formatter();
        f.printWithRubles(result);

        scanner.close();
    }
}


