package processor;

import java.util.Objects;
import java.util.Scanner;

public class MatrixOperation {
    static Scanner scanner = new Scanner(System.in);

    public static void addMatrices() {
        System.out.print("Enter size of first matrix: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter first matrix:");
        double[][] matrixA = matrixInit(A_dimensions[0], A_dimensions[1]);
        Matrix A = new Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.print("Enter size of second matrix: ");
        int[] B_dimensions = getDimensions();
        System.out.println("Enter second matrix:");
        double[][] matrixB = matrixInit(B_dimensions[0], B_dimensions[1]);
        Matrix B = new Matrix(B_dimensions[0], B_dimensions[1], matrixB);

        if (A_dimensions[0] == B_dimensions[0] && A_dimensions[1] == B_dimensions[1]) {
            System.out.println("The result is:");
            System.out.println(A.add(B));
        }
        else{
            System.out.println("The operation cannot be performed.");
        }
    }

    public static void multiByNum() {
        System.out.print("Enter size of matrix: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter matrix:");
        double[][] matrixA = matrixInit(A_dimensions[0], A_dimensions[1]);
        Matrix A = new Matrix(A_dimensions[0], A_dimensions[1], matrixA);
        System.out.print("Enter constant: ");
        double constant = num();

        System.out.println("The result is:");
        System.out.println(A.multiByNum(constant));
    }

    public static void multiplyMatrices() {
        System.out.print("Enter size of first matrix: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter first matrix:");
        double[][] matrixA = matrixInit(A_dimensions[0], A_dimensions[1]);
        Matrix A = new Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.print("Enter size of second matrix: ");
        int[] B_dimensions = getDimensions();
        System.out.println("Enter second matrix:");
        double[][] matrixB = matrixInit(B_dimensions[0], B_dimensions[1]);
        Matrix B = new Matrix(B_dimensions[0], B_dimensions[1], matrixB);

        if (A_dimensions[1] == B_dimensions[0]) {
            System.out.println("The result is:");
            System.out.println(A.multi(B));
        }
        else{
            System.out.println("The operation cannot be performed.");
        }
    }

    private static double num() {
        double scalar;
        try {
            scalar = Double.parseDouble(scanner.nextLine().trim());
            return scalar;
        } catch (Exception e) {
            System.out.println("check input");
            return num();
        }
    }


    public static int[] getDimensions() {
        int[] dimensions = new int[2];
        try {
            String[] dimension = scanner.nextLine().trim().split(" ");
            dimensions[0] = Integer.parseInt(dimension[0]);
            dimensions[1] = Integer.parseInt(dimension[1]);
            return dimensions;
        } catch (Exception e) {
            System.out.println("check input");
            getDimensions();
            return getDimensions();
        }
    }

    public static double[][] matrixInit(int row, int column) {
        double[][] matrix = new double[row][column];
        try {
            String[][] numbs = new String[row][column];
            for (int i = 0; i < row; i++) {
                numbs[i] = scanner.nextLine().trim().split(" ");
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = Double.parseDouble(numbs[i][j]);
                }
            }
            return matrix;
        } catch (Exception e) {
            System.out.println("check input");
            return matrixInit(row, column);
        }
    }
}
