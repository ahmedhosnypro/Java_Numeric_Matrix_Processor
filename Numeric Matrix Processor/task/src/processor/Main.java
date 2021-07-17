package processor;

import java.util.Scanner;

public class Main {
    static Scanner  scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Matrix A = new Matrix();
        int scalar = scanner.nextInt();
        System.out.println();
        System.out.println(A.multiByNum(scalar));
    }
}
