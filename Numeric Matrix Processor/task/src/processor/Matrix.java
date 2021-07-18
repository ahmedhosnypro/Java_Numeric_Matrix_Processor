package processor;

import java.util.Scanner;

public class Matrix {
    private int row;
    private int column;
    private double[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Matrix(int row, int column, double[][] matrix) {
        this.row = row;
        this.column = column;
        this.matrix = matrix;
    }

    public Matrix() {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] dimension = scanner.nextLine().trim().split(" ");
            this.row = Integer.parseInt(dimension[0]);
            this.column = Integer.parseInt(dimension[1]);
            String[][] numbs = new String[row][column];
            for (int i = 0; i < row; i++) {
                numbs[i] = scanner.nextLine().trim().split(" ");
            }

            matrix = new double[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = Double.parseDouble(numbs[i][j]);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public Matrix add(Matrix matrixB) {
        Matrix out = new Matrix(row, column);
        if (row == matrixB.row && column == matrixB.column) {
            out.matrix = new double[row][column];
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

        boolean isFloat = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int integer = (int) matrix[i][j];
                double decimalSection = matrix[i][j] - integer;
                if (decimalSection > 0) {
                    isFloat = true;
                    break;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int integer = (int) matrix[i][j];
                if (isFloat) {
                    out.append(matrix[i][j]).append(" ");
                } else {
                    out.append(integer).append(" ");
                }

            }
            out.delete(out.length() - 1, out.length());
            out.append('\n');
        }
        return out.toString().trim();
    }

    public Matrix multiByNum(double scalar) {
        Matrix out = new Matrix(row, column);
        out.matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                out.matrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return out;
    }

    public Matrix multiply(Matrix matrix) {
        Matrix out = new Matrix(row, matrix.column);
        if (column == matrix.row) {
            out.matrix = new double[row][matrix.column];
            //A(rowA,colmA) * B(row2,p)
            int rowA = 0;
            while (rowA < row) {
                int colmB = 0;
                while (colmB < matrix.column) {
                    int n = 0;
                    while (n < column) {
                        double n1 = this.matrix[rowA][n];
                        double n2 = matrix.matrix[n][colmB];
                        out.matrix[rowA][colmB] += n1 * n2;
                        n++;
                    }
                    colmB++;
                }
                rowA++;
            }
        }//end if
        return out;
    }

    public Matrix mainDiagonalTranspose() {
        Matrix out = new Matrix(row, column);
        out.matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                out.matrix[i][j] = this.matrix[j][i];
            }
        }
        return out;
    }

    public Matrix sideDiagonalTranspose() {
        Matrix out = new Matrix(row, column);
        out.matrix = new double[row][column];
        int i = row - 1;
        int k = 0;
        while (i >= 0) {
            int j = column - 1;
            int l = 0;
            while (j >= 0) {
                out.matrix[l][k] = this.matrix[i][j];
                j--;
                l++;
            }
            i--;
            k++;
        }

        return out;
    }

    public Matrix verticalLineTranspose() {
        Matrix out = new Matrix(row, column);
        out.matrix = new double[row][column];
        int i = 0;


        while (i < row) {
            int j = column - 1;
            int k = 0;
            while (j >= 0) {
                out.matrix[i][k] = this.matrix[i][j];
                j--;
                k++;
            }
            i++;
        }
        return out;
    }

    public Matrix horizontalLineTranspose() {
        Matrix out = new Matrix(row, column);
        out.matrix = new double[row][column];
        int i = row - 1;
        int k = 0;
        while (i >= 0) {
            int j = 0;
            while (j < column) {
                out.matrix[k][j] = this.matrix[i][j];
                j++;
            }
            i--;
            k++;
        }
        return out;
    }

}
