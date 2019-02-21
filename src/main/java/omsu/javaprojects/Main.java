package omsu.javaprojects;

import omsu.javaprojects.matrix.DemoMatrix;
import omsu.javaprojects.matrix.IMatrix;
import omsu.javaprojects.matrix.InvertableMatrix;
import omsu.javaprojects.matrix.Matrix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("test matrix:");
        Matrix matrix = new Matrix(3);
        DemoMatrix.scan(new FileInputStream("3x3.txt"), matrix);
        DemoMatrix.print(System.out, matrix);
        System.out.println("matrix det: " + matrix.det());
        System.out.println("matrix elem sum: " + DemoMatrix.getMatrixSum(matrix));
        System.out.println("matrix row num: " + matrix.getRow());
        System.out.println("matrix elem (1,2): " + matrix.get(1,2));
        System.out.println("changing elem (1,2) to 99");
        matrix.set(1,2,99);
        System.out.println("Matrix with changed elem:");
        DemoMatrix.print(System.out, matrix);
        System.out.println();
        //////////////////////////////////////////////////////////////
        System.out.println("Invertable matrix:");
        InvertableMatrix invertableMatrix = new InvertableMatrix(3);
        DemoMatrix.scan(new FileInputStream("simpleMatrixToInvert.txt"), invertableMatrix);
        DemoMatrix.print(System.out, invertableMatrix);
        System.out.println("Inverted matrix:");
        DemoMatrix.print(System.out, invertableMatrix.getInvertedMatrix());
        System.out.println("\nserializing into file test.txt inverted matrix");
        DemoMatrix.print(new FileOutputStream("test.txt"),invertableMatrix.getInvertedMatrix());
        Matrix scanned = new Matrix(3);
        DemoMatrix.scan(new FileInputStream("test.txt"), scanned);
        System.out.println("Scanned matrix:");
        DemoMatrix.print(System.out, scanned);
    }
}
