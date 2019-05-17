package omsu.javaprojects.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDemo {
    //1 part 1
    public static void writeIntArrayToByteStream(final OutputStream out, int[] array) throws IOException {
        byte[] bytes = convertIntArrayToByteArray(array);
        out.write(bytes);
    }

    private static byte[] convertIntArrayToByteArray(int[] data) throws IOException {
        if (data == null) {
            return null;
        }
        byte[] bytes = new byte[data.length * 4];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(toByteArray(data[i]), 0, bytes, i * 4, 4);
        }
        return bytes;
    }

    private static byte[] toByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
    //1 part 2
    public static int[] readIntArrayFromByteStream(final InputStream in, int[] array) throws IOException {
        byte[] b = new byte[array.length * 4];
        in.read(b);
        return convertByteArrayToIntArray(b, array);
    }

    private static int[] convertByteArrayToIntArray(byte[] data, int[] arr) {
        IntBuffer intBuf = ByteBuffer
                .wrap(data)
                .order(ByteOrder.BIG_ENDIAN)
                .asIntBuffer();
        intBuf.get(arr);
        return arr;
    }
    //2 part 1
    public static void writeIntArrayToOutputStream(final OutputStream out, int[] array) {
        try (Writer writer = new OutputStreamWriter(out)) {
            for (int i = 0; i < array.length - 1; i++) {
                writer.write(String.valueOf(array[i]) + ' ');
            }
            writer.write(String.valueOf(array[array.length - 1]));
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //2 part 2
    public static int[] readIntArrayFromInputStream(final InputStream in, int[] array) throws IOException {
        Scanner scanner = new Scanner(in);
        for (int i = 0; i < array.length; i++) {
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            }
        }
        return array;
    }
    //3
    public static int[] readIntArrayWithRAF(String path, int offset, int size) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            file.seek(offset * 4);
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = file.readInt();
            }
            return array;
        }
    }
    //4
    public static List<File> getFilesWithExtension(final File folder, final String extension) {
        List<File> fileNames = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (!file.isDirectory() && file.getName().endsWith(extension)) {
                fileNames.add(file);
            }
        }
        return fileNames;
    }
}
