package processor;

import java.util.Scanner;
import Jama.Matrix;

public class MatrixOperation {
    static Scanner scanner = new Scanner(System.in);

    public static void addMatrices() {
        System.out.print("Enter size of first matrix: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter first matrix:");
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        processor.Matrix A = new processor.Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.print("Enter size of second matrix: ");
        int[] B_dimensions = getDimensions();
        System.out.println("Enter second matrix:");
        double[][] matrixB = matrixArray(B_dimensions[0], B_dimensions[1]);
        processor.Matrix B = new processor.Matrix(B_dimensions[0], B_dimensions[1], matrixB);

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
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        processor.Matrix A = new processor.Matrix(A_dimensions[0], A_dimensions[1], matrixA);
        System.out.print("Enter constant: ");
        double constant = num();

        System.out.println("The result is:");
        System.out.println(A.multiByNum(constant));
    }

    public static void multiplyMatrices() {
        System.out.print("Enter size of first matrix: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter first matrix:");
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        processor.Matrix A = new processor.Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.print("Enter size of second matrix: ");
        int[] B_dimensions = getDimensions();
        System.out.println("Enter second matrix:");
        double[][] matrixB = matrixArray(B_dimensions[0], B_dimensions[1]);
        processor.Matrix B = new processor.Matrix(B_dimensions[0], B_dimensions[1], matrixB);

        if (A_dimensions[1] == B_dimensions[0]) {
            System.out.println("The result is:");
            System.out.println(A.multiply(B));
        }
        else{
            System.out.println("The operation cannot be performed.");
        }
    }

    public static void transposeMatrix(int choice){
        System.out.print("Enter matrix size: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter matrix:");
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        processor.Matrix A = new processor.Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.println("The result is:");
        switch (choice) {
            case 1:
                System.out.println(A.mainDiagonalTranspose());
                break;
            case 2:
                System.out.println(A.sideDiagonalTranspose());
                break;
            case 3:
                System.out.println(A.verticalLineTranspose());
                break;
            case 4:
                System.out.println(A.horizontalLineTranspose());
                break;
            default:
                break;
        }
    }

    public static void determinant(){
        System.out.print("Enter matrix size: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter matrix:");
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        processor.Matrix A = new processor.Matrix(A_dimensions[0], A_dimensions[1], matrixA);

        System.out.println("The result is:");
        double determinant = A.getDeterminant();
        int integer = (int) determinant;
        double decimalSection = determinant - integer;
        if (decimalSection>0)
            System.out.println(determinant);
        else
            System.out.println(integer);
    }

    public static void inversion(){
        System.out.print("Enter matrix size: ");
        int[] A_dimensions = getDimensions();
        System.out.println("Enter matrix:");
        double[][] matrixA = matrixArray(A_dimensions[0], A_dimensions[1]);
        Jama.Matrix A = new Jama.Matrix(matrixA);


        System.out.println("The result is:");
        Jama.Matrix B = A.inverse();

        System.out.println(Printer.toArray(B.getArrayCopy()));
    }
    private static double num() {
        double scalar;
        try {
            scalar = Double.parseDouble(scanner.nextLine().trim());
            return scalar;
        } catch (Exception e) {
            System.out.println("check input");
            System.out.print("Enter constant: ");
            return num();
        }
    }

    private static int[] getDimensions() {
        int[] dimensions = new int[2];
        try {
            String[] dimension = scanner.nextLine().trim().split(" ");
            dimensions[0] = Integer.parseInt(dimension[0]);
            dimensions[1] = Integer.parseInt(dimension[1]);
            return dimensions;
        } catch (Exception e) {
            System.out.println("check input");
            System.out.print("Enter size of matrix: ");
            getDimensions();
            return getDimensions();
        }
    }

    private static double[][] matrixArray(int row, int column) {
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
            System.out.println("Enter matrix:");
            return matrixArray(row, column);
        }
    }
}
