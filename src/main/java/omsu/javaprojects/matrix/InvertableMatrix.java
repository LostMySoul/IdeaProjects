package omsu.javaprojects.matrix;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    public InvertableMatrix(int row) {
        super(row);
    }


    @Override
    public IMatrix getInvertedMatrix() {
        if (super.det() == 0) {
            throw new IllegalArgumentException();
        }
        Matrix matrix = new Matrix(super.getRow());
        for (int i = 0; i < super.getRow(); i++) {
            for (int j = 0; j < super.getRow(); j++) {
                matrix.set(i, j, Math.pow(-1, i + j + 2) * super.getMinor(i, j).det());
            }
        }
        matrix.transposition();
        for (int i = 0; i < super.getRow(); i++) {
            for (int j = 0; j < super.getRow(); j++) {
                matrix.set(i, j, matrix.get(i, j) / super.det());
            }
        }
        return matrix;
    }
}
