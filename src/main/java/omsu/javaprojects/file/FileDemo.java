package omsu.javaprojects.file;

import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDemo {
    private static int count = 0;

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

    public static int[] readIntArrayFromByteStream(final InputStream in, int[] array) throws IOException {
        byte[] b = new byte[array.length * 4];
        in.read(b);
        return convertByteArrayToIntArray(b, array);
    }

    private static int[] convertByteArrayToIntArray(byte[] data, int[] arr) {
        IntBuffer intBuf =
                ByteBuffer.wrap(data)
                        .order(ByteOrder.BIG_ENDIAN)
                        .asIntBuffer();
        intBuf.get(arr);
        return arr;
    }

    private static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public static void saveAsCSV(House house, String path) {
        String cadastral = house.getCadastralId().replace(':', '_');
        String fullPath = path + "house_" + cadastral + ".csv";
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullPath), Charset.forName("UTF-8")))) {
            bw.write("Данные о доме;;\n");
            bw.write("Кадастровый номер;;" + house.getCadastralId() + "\n");
            bw.write("Адрес;;" + house.getAdress() + "\n");
            bw.write("Старший по дому;;" + house.getSenior().getFirstName()
                    + " " + house.getSenior().getLastName() + " " + house.getSenior().getPatronymic() + "\n");
            bw.write("Данные о квартирах;;\n");
            bw.write("№;Площадь, кв.м.;Владельцы\n");
            List<Flat> flats = house.getFlats();
            for (int i = 0; i < flats.size(); i++) {
                Flat temp = flats.get(i);
                bw.write(temp.getNumber() + ";" + temp.getArea() + ";");
                List<Person> tempOwners = temp.getOwners();
                for (int j = 0; j < tempOwners.size() - 1; j++) {
                    bw.write(tempOwners.get(j).getFullName() + ", ");
                }
                Person last = tempOwners.get(tempOwners.size() - 1);
                bw.write(last.getFullName());
                bw.write("\n");
            }
        } catch (IOException ex) {
            System.out.println("Error writing file");
        }
    }
    //Данные о доме;;
    //Кадастровый номер;;12345
    //Адрес;;Мира 55
    //Старший по дому;;Иванов Сидор
    //Данные о квартирах;;
    //№;Площадь, кв.м.;Владельцы
    //1;40;Петров А.В.
    //2;65;Сидорова О.М.
    //3;58;Васечкин И.П., Золотов С.Б.

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

    public static int[] readIntArrayFromInputStream(final InputStream in, int[] array) throws IOException {
        Scanner scanner = new Scanner(in);
        for (int i = 0; i < array.length; i++) {
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            }
        }
        return array;
    }

    public static int[] readIntArrayWithRAF(String path, int offset, int size) throws FileNotFoundException, IOException {
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {
            file.seek(offset * 4);
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = file.readInt();
            }
            return array;
        }
    }

    public static List<File> getFilesWithExtension(final File folder, final String extension) {
        List<File> fileNames = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (!file.isDirectory() && file.getName().endsWith(extension)) {
                fileNames.add(file);
            }
        }
        return fileNames;
    }


    public static List<String> getFilesMatchedRegex(final File dir, String regex) {
        List<String> list = new ArrayList<>();
        getMatchedRegex(dir, regex, list);
        return list;
    }

    private static void getMatchedRegex(final File folder, String regex, List<String> toAdd) {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                if (file.getName().matches(regex)) {
                    toAdd.add(file.getAbsolutePath());
                }
            } else {
                if (file.getName().matches(regex)) {
                    toAdd.add(file.getAbsolutePath());
                }
                getMatchedRegex(file, regex, toAdd);
            }
        }
    }
}
