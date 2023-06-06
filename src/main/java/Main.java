import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double getDouble (Scanner scanner) {
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            scanner.next();
            return 0;
        }
    }
    public static int getInt (Scanner scanner) {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            scanner.next();
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
            else if (rest == 0 || rest >= 5) {
                System.out.printf("%.2f Рублей", x);
            }
            else if (rest == 1) {
                System.out.printf("%.2f Рубль", x);
            }
            else if (rest >= 2) {
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

    public static int getGuests(Scanner scanner) {
        int guests;
        while (true) {
            System.out.println("На сколько человек необходимо разделить счёт?");
            guests = getInt(scanner);
            if (guests > 1) {
                break;
            } else if (guests == 1) {
                System.out.println("нет смысла ничего считать и делить");
            } else {
                System.out.println("Это некорректное значение для подсчёта");
            }
        }
        return guests;
    }

    public static void getProducts(Scanner scanner, Calculator calc) {
        while (true) {
            System.out.println("Введите наименование товара или 'Завершить'");
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            }
            else {
                while (true) {
                    System.out.println("Введите стоимость товара");
                    double productPrice = getDouble(scanner);
                    if (productPrice > 0) {
                        Product newProduct = new Product(productName, productPrice);
                        calc.addProduct(newProduct);
                        break;
                    }
                    else {
                        System.out.println("Это некорректное значение для подсчёта");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = getGuests(scanner);

        Calculator calc = new Calculator();
        getProducts(scanner, calc);

        System.out.println("Добавленные товары:");
        System.out.println(calc.productNames);
        double result = calc.divideByAll(guests);
        System.out.print("Каждый должен заплатить по: ");

        Formatter f = new Formatter();
        f.printWithRubles(result);

        scanner.close();
    }
}


