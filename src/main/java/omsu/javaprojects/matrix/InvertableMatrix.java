package omsu.javaprojects.matrix;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    public InvertableMatrix(int row) {
        super(row);
        for(int i=0; i<row; i++) {
            super.set(i, i, 1.0);
        }
    }

    public InvertableMatrix(Matrix matrix) {
        super(matrix);
        if (Math.abs(this.det())<1e-7) {
            throw new MatrixException();
        }
    }


    @Override
    public IInvertableMatrix getInvertedMatrix() {
        if (super.det() == 0) {
            throw new IllegalArgumentException();
        }
        Matrix matrix = new Matrix(super.getSize());
        for (int i = 0; i < super.getSize(); i++) {
            for (int j = 0; j < super.getSize(); j++) {
                matrix.set(i, j, Math.pow(-1, i + j + 2) * super.getMinor(i, j).det());
            }
        }
        matrix.transposition();
        for (int i = 0; i < super.getSize(); i++) {
            for (int j = 0; j < super.getSize(); j++) {
                matrix.set(i, j, matrix.get(i, j) / super.det());
            }
        }
        return new InvertableMatrix(matrix);
    }
}
