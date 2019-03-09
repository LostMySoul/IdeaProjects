package omsu.javaprojects.matrix;

import org.junit.Test;

import java.io.FileInputStream;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void get() {
        Matrix matrix = new Matrix(3);
        assertNotNull(matrix);
        assertEquals(0.0, matrix.get(1,1), 1e-7);
    }

    @Test
    public void set() {
        Matrix matrix = new Matrix(1,2,3,4);
        Matrix a= new Matrix(1,2,3,5);
        matrix.set(1,1,5);
        assertEquals(a, matrix);
    }

    @Test
    public void det() {
        Matrix matrix = new Matrix(1,2,3,4);
        assertEquals(-2.0, matrix.det(), 1e-7);
    }

    @Test
    public void getMinor() {
    }

    @Test
    public void inverted() {
        InvertableMatrix matrix = new InvertableMatrix(new Matrix(1,0,0,0,1,0,0,0,10));
        IInvertableMatrix inv = matrix.getInvertedMatrix();
        IInvertableMatrix iinv = inv.getInvertedMatrix();
        assertEquals(matrix, iinv);
    }

    @Test
    public void MatrixElemSum() {
        Matrix matrix = new Matrix(1,2,3,4);
        assertEquals(10,DemoMatrix.getMatrixSum(matrix),1e-10);

    }
    @Test
    public void MatrixSize() {
        Matrix matrix = new Matrix(1,2,3,4);
        assertEquals(2,matrix.getSize(),1e-10);

    }

}