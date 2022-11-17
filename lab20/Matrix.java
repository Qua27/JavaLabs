package ru.mirea.lab20;

public class Matrix<T extends Number> {
    private final T[][] array;
    private final int n, m;

    public Matrix(T[][] array, int n, int m) {
        this.array = array;
        this.n = n;
        this.m = m;
    }

    public static <T extends Number> Matrix<Double> addMatrices(Matrix<T> matrix1, Matrix<T> matrix2) {
        if (matrix1.n != matrix2.n || matrix1.m != matrix2.m) {
            System.out.println("Unable to add");
            System.exit(1);
        }
        Matrix<Double> result = new Matrix<>(new Double[matrix1.n][matrix1.m], matrix1.n, matrix1.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                result.array[i][j] = matrix1.array[i][j].doubleValue() + matrix2.array[i][j].doubleValue();
            }
        }
        return result;
    }

    public static <T extends Number> Matrix<Double> multiplyByScalar(Matrix<T> matrix, T scalar) {
        Matrix<Double> result = new Matrix<>(new Double[matrix.n][matrix.m], matrix.n, matrix.m);
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                result.array[i][j] = matrix.array[i][j].doubleValue() * scalar.doubleValue();
            }
        }
        return result;
    }

    public static <T extends Number> Matrix<Double> multiplyMatrices(Matrix<T> matrix1, Matrix<T> matrix2) {
        if (matrix1.m != matrix2.n) {
            System.out.println("Unable to multiply");
            System.exit(1);
        }
        Matrix<Double> result = new Matrix<>(new Double[matrix1.n][matrix1.m], matrix1.n, matrix1.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                result.array[i][j] = 0.0;
                for (int k = 0; k < matrix1.m; k++) {
                    result.array[i][j] += matrix1.array[i][k].doubleValue() * matrix2.array[k][j].doubleValue();
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
