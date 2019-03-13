package omsu.javaprojects.matrix;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class DemoMatrix {

    public static double getMatrixSum(IMatrix matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.get(i, j);
            }
        }
        return sum;
    }


    public static void scan(InputStream in, IMatrix matrix) throws IOException {
        Scanner s = new Scanner(in);
        int row = s.nextInt();
        if (row != matrix.getSize()) {
            throw new IOException();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                matrix.set(i, j, s.nextDouble());
            }
        }
    }

    public static void print(OutputStream out, IMatrix matrix) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(String.format("%d\n", matrix.getSize()));
        double temp;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                temp = matrix.get(i, j);
                if (temp == -0.) temp = 0.;
                writer.write(String.format("% 8.2f ", temp));
            }
            writer.write("\n");
        }
        writer.flush();
    }


    public static void writeObject(FileOutputStream out, Matrix mx) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(mx);
        oos.flush();
        oos.close();
    }

    public static Matrix readObject(FileInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(in);
        return (Matrix) oin.readObject();
    }
}
