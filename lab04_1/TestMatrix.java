package ru.mirea.lab4_1;

public class TestMatrix {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}}, 2, 2);
        Matrix matrix2 = new Matrix(new double[][]{{2, 1}, {4, 3}}, 2, 2);
        System.out.println(Matrix.addMatrices(matrix1, matrix2));
        System.out.println(Matrix.multiplyByScalar(matrix1, 8));
        System.out.println(Matrix.multiplyMatrices(matrix1, matrix2));
    }
}

class Matrix {
    private final double[][] array;
    private final int n, m;

    public Matrix(double[][] array, int n, int m) {
        this.array = array;
        this.n = n;
        this.m = m;
    }

    public static Matrix addMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            System.out.println("Unable to add");
            System.exit(1);
        }
        Matrix result = new Matrix(new double[matrix1.n][matrix1.m], matrix1.n, matrix1.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                result.array[i][j] = matrix1.array[i][j] + matrix2.array[i][j];
            }
        }
        return result;
    }

    public static Matrix multiplyByScalar(Matrix matrix, double scalar) {
        Matrix result = new Matrix(new double[matrix.n][matrix.m], matrix.n, matrix.m);
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                result.array[i][j] = matrix.array[i][j] * scalar;
            }
        }
        return result;
    }

    public static Matrix multiplyMatrices(Matrix matrix1, Matrix matrix2) {
        if (matrix1.m != matrix2.n) {
            System.out.println("Unable to multiply");
            System.exit(1);
        }
        Matrix result = new Matrix(new double[matrix1.n][matrix1.m], matrix1.n, matrix1.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                result.array[i][j] = 0;
                for (int k = 0; k < matrix1.m; k++) {
                    result.array[i][j] += matrix1.array[i][k] * matrix2.array[k][j];
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.append(array[i][j]);
                result.append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }
}
