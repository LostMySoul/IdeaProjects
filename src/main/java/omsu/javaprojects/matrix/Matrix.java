package omsu.javaprojects.matrix;

import java.util.Arrays;

public class Matrix implements IMatrix {
    private double[] matrix;
    private int size;
    private boolean detFlag = false;
    private double detCache = 0;

    public Matrix(int row){
        if (row < 1) {
            throw new MatrixException();
        }
        this.size = row;
        matrix = new double[row * row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                set(i, j, 0);
            }
        }
    }

    public Matrix(Matrix m) {
        this(m.matrix);
    }

    public Matrix(double... matrix) {
        this.size = (int) Math.floor(Math.sqrt(matrix.length));
        this.matrix = new double[size * size];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = matrix[i];
        }
    }


    public int getSize() {
        return size;
    }

    @Override
    public double get(int row, int col) {
        if (row >= this.size || col >= this.size || row < 0 || col < 0) {
            throw new MatrixException();
        }
        return matrix[this.size * row + col];
    }

    @Override
    public void set(int row, int col, double value) {
        if (row >= this.size || col >= this.size || row < 0 || col < 0) {
            throw new MatrixException();
        }
        matrix[this.size * row + col] = value;
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
        for (int i = 0; i < size; i++) {
            temporary = new Matrix(size - 1);
            for (int j = 1; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (k < i) {
                        temporary.set(j - 1, k, matrix[j * size + k]);
                    } else if (k > i) {
                        temporary.set(j - 1, k - 1, matrix[j * size + k]);
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
        if (x >= this.size || y >= this.size || x < 0 || y < 0) {
            throw new MatrixException();
        }
        Matrix minor = new Matrix(size - 1);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                minor.set(i, j, get(i, j));
            }
            for (int j = y + 1; j < size; j++) {
                minor.set(i, j - 1, get(i, j));
            }
        }
        for (int i = x + 1; i < size; i++) {
            for (int j = 0; j < y; j++) {
                minor.set(i - 1, j, get(i, j));
            }
            for (int j = y + 1; j < size; j++) {
                minor.set(i - 1, j - 1, get(i, j));
            }
        }
        return minor;
    }

    public void transposition() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
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
        boolean isEquals = true;
        for (int i=0; i <size*size && isEquals;i++) {
            isEquals = isEquals && Math.abs(this.matrix[i] - matrix1.matrix[i]) < 1e-10;
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
