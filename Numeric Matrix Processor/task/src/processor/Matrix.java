package processor;

import java.util.Scanner;

public class Matrix {
    Scanner scanner = new Scanner(System.in);
    int row;
    int column;
    int[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Matrix() {
        try {
            String[] dimension = scanner.nextLine().trim().split(" ");
            this.row = Integer.parseInt(dimension[0]);
            this.column = Integer.parseInt(dimension[1]);
            String[][] numbs = new String[row][column];
            for (int i = 0; i < row; i++) {
                numbs[i] = scanner.nextLine().trim().split(" ");
            }

            matrix = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = Integer.parseInt(numbs[i][j]);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public Matrix add(Matrix matrixB) {
        Matrix out = new Matrix(this.row, this.column);
        if (row == matrixB.row && column == matrixB.column) {
            out.matrix = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    out.matrix[i][j] = matrix[i][j] + matrixB.matrix[i][j];
                }
            }
        }
        return out;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                out.append(matrix[i][j]).append(" ");
            }
            out.delete(out.length() - 1, out.length());
            out.append('\n');
        }
        return out.toString().trim();
    }
}
