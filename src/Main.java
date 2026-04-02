// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handleOption1();
                    break;
                case 2:
                    handleOption2();
                    break;
                case 3:
                    handleOption3();
                    break;
                case 4:
                    handleOption4();
                    break;
                case 5:
                    handleOption5();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        System.out.println("5. Option 5");
        System.out.println("6. Exit");
    }

    private static void handleOption1() {
        // Handle option 1
    }

    private static void handleOption2() {
        // Handle option 2
    }

    private static void handleOption3() {
        // Handle option 3
    }

    private static void handleOption4() {
        // Handle option 4
    }

    private static void handleOption5() {
        // Handle option 5
    }
}