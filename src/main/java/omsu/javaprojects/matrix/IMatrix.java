package omsu.javaprojects.matrix;

public interface IMatrix {
    double get(int row, int col);

    int getRow();

    void set(int row, int col, double value);

    double det();

}
