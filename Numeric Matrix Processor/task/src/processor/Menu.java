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
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
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
            case 4:
                transpositionMenu();
                break;
            case 5:
                determinant();
                break;
            case 6:
                inversion();
                break;
            case 0:
            default:
                isContinue = false;
                break;
        }
        return isContinue;
    }

    public static void transpositionMenu() {
        System.out.println();
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = choose();
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                transposeMatrix(choice);
            default:
                break;
        }
    }

    private static int choose() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return choice;
        } catch (IllegalArgumentException e) {
            System.out.println("check input");
            System.out.print("Your choice: ");
            return choose();
        }
    }
}
