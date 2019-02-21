package omsu.javaprojects.matrix;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DemoMatrix {

    public static double getMatrixSum(IMatrix matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getRow(); j++) {
                sum += matrix.get(i, j);
            }
        }
        return sum;
    }


    public static void scan(InputStream in, IMatrix matrix) throws IOException {
        Scanner s = new Scanner(in);
        int row = s.nextInt();
        if (row != matrix.getRow()) {
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
        writer.write(String.format("%d\n", matrix.getRow()));
        double temp;
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getRow(); j++) {
                temp = matrix.get(i, j);
                if (temp == -0.) temp = 0.;
                writer.write(String.format("% 8.2f ", temp));
            }
            writer.write("\n");
        }
        writer.flush();
    }


//    public void serializeTraineeToBinaryFile(File file) throws IOException {	//сериализация (однозначная запись, которая предоставляет возможность считать обратно)
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {	// нашего FinanceReport в файл с помощью сериализатора Gson (гугловский)
//            Gson gson = new Gson();
//            gson.toJson(this, bw);
//        }
//    }
//
//    public void deserializeTraineeFromBinaryFile(File file) throws IOException {	//десериализация из файла при помощи Gson
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            Gson gson = new Gson();
//            FinanceReport financeReport = gson.fromJson(br, FinanceReport.class);
//            this.payMap = financeReport.payMap;
//        }
//    }

}
