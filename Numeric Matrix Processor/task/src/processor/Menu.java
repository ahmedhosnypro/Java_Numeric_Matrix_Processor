package processor;

import java.util.Scanner;

import static processor.MatrixOperation.*;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static boolean menu() {
        boolean isContinue = true;
        System.out.println();
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit");
        System.out.print("Your choice: ");
        switch (choose()) {
            case 1:
                addMatrices();
                break;
            case 2:
                multiByNum();
                break;
            case 3:
                multiplyMatrices();
                break;
            case 0:
            default:
                isContinue = false;
                break;
        }
        return isContinue;
    }

    private static int choose() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (IllegalArgumentException ignore) {
        }
        if (choice >= 0 && choice <= 3) {
            return choice;
        } else {
            System.out.println("check input");
            return choose();
        }
    }
}
