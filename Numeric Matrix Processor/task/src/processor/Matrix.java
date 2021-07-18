package processor;


public class Matrix {
    private final int row;
    private final int column;
    private double[][] matrix;
    private int iDF = 0;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Matrix(int row, int column, double[][] matrix) {
        this.row = row;
        this.column = column;
        this.matrix = matrix;
    }

    //getters
    public double getDeterminant() {
        return calcDeterminant(matrix);
    }

    //operations
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

    private double calcDeterminant(double[][] matrix) {
        double det = 1;

        matrix = UpperTriangle(matrix);

        for (int i = 0; i < matrix.length; i++) {
            det = det * matrix[i][i];
        } // multiply down diagonal

        det = det * iDF; // adjust w/ determinant factor

        return det;
    }

    public double[][] UpperTriangle(double[][] m) {

        double f1;
        double temp;
        int tms = m.length;
        int v;

        iDF = 1;

        for (int col = 0; col < tms - 1; col++) {
            for (int row = col + 1; row < tms; row++) {
                v = 1;

                while (m[col][col] == 0) // check if 0 in diagonal
                { // if so switch until not
                    if (col + v >= tms) // check if switched all rows
                    {
                        iDF = 0;
                        break;
                    } else {
                        for (int c = 0; c < tms; c++) {
                            temp = m[col][c];
                            m[col][c] = m[col + v][c]; // switch rows
                            m[col + v][c] = temp;
                        }
                        v++; // count row switches
                        iDF = iDF * -1; // each switch changes determinant
                        // factor
                    }
                }

                if (m[col][col] != 0) {

                    try {
                        f1 = (-1) * m[row][col] / m[col][col];
                        for (int i = col; i < tms; i++) {
                            m[row][i] = f1 * m[col][i] + m[row][i];
                        }
                    } catch (Exception e) {
                        System.out.println("Still Here!!!");
                    }

                }

            }
        }

        return m;
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

}
