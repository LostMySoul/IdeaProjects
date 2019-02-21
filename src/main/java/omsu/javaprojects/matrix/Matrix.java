package omsu.javaprojects.matrix;

import java.util.Arrays;

public class Matrix implements IMatrix {
    private double[] matrix;
    private int row;
    private boolean detFlag = false;
    private double detCache = 0;

    public Matrix(int row) throws RuntimeException {
        if (row < 1) {
            throw new RuntimeException();
        }
        this.row = row;
        matrix = new double[row * row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                set(i, j, 0);
            }
        }
    }


    public int getRow() {
        return row;
    }

    @Override
    public double get(int row, int col) {
        if (row >= this.row || col >= this.row || row < 0 || col < 0) {
            throw new RuntimeException();
        }
        return matrix[this.row * row + col];
    }

    @Override
    public void set(int row, int col, double value) throws RuntimeException {
        if (row >= this.row || col >= this.row || row < 0 || col < 0) {
            throw new RuntimeException();
        }
        matrix[this.row * row + col] = value;
        detFlag = false;
    }

    @Override
    public double det() {
        if (detFlag) {
            return detCache;
        }
        double result = 0;
        if (matrix.length == 1) {
            result = matrix[0];
            return (result);
        }
        if (matrix.length == 4) {
            result = ((matrix[0] * matrix[3]) - (matrix[1] * matrix[2]));
            return (result);
        }
        Matrix temporary;
        for (int i = 0; i < row; i++) {
            temporary = new Matrix(row - 1);
            for (int j = 1; j < row; j++) {
                for (int k = 0; k < row; k++) {
                    if (k < i) {
                        temporary.set(j - 1, k, matrix[j * row + k]);
                    } else if (k > i) {
                        temporary.set(j - 1, k - 1, matrix[j * row + k]);
                    }
                }
            }
            result += matrix[i] * Math.pow(-1, (double) i) * temporary.det();
        }
        detFlag = true;
        detCache = result;
        return (result);
    }

    public Matrix getMinor(int x, int y) {
        if (x >= this.row || y >= this.row || x < 0 || y < 0) {
            throw new RuntimeException();
        }
        Matrix minor = new Matrix(row - 1);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                minor.set(i, j, get(i, j));
            }
            for (int j = y + 1; j < row; j++) {
                minor.set(i, j - 1, get(i, j));
            }
        }
        for (int i = x + 1; i < row; i++) {
            for (int j = 0; j < y; j++) {
                minor.set(i - 1, j, get(i, j));
            }
            for (int j = y + 1; j < row; j++) {
                minor.set(i - 1, j - 1, get(i, j));
            }
        }
        return minor;
    }

    public void transposition() {
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                double temp = get(i, j);
                set(i, j, get(j, i));
                set(j, i, temp);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
}
