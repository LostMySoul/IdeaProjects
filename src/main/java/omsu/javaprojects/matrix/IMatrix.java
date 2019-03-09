package omsu.javaprojects.matrix;

public interface IMatrix {
    double get(int row, int col);

    int getSize();

    void set(int row, int col, double value);

    double det();

}
