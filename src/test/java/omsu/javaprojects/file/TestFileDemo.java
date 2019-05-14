package omsu.javaprojects.file;

import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFileDemo {
    @Test
    public void testIntArrayByteStreams() throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        int[] arr = {1, 2, 3, 4};
        FileDemo.writeIntArrayToByteStream(bout, arr);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        int[] res = new int[4];
        FileDemo.readIntArrayFromByteStream(bin, res);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], res[i]);
        }
        assertTrue(Arrays.equals(res, arr));
    }

    @Test
    public void testReadIntArrRAF() throws IOException {
        int[] arr = {1, 2, 3, 4};
        FileDemo.writeIntArrayToByteStream(new FileOutputStream("./test.out"), arr);
        int[] ans = {3, 4};
        int[] res = FileDemo.readIntArrayWithRAF("./test.out", 2, 2);
        for (int i = 0; i < ans.length; i++) {
            assertEquals(ans[i], res[i]);
        }
    }


    @Test
    public void testIntArrayNotByteStream() throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        int[] arr = {1, 2, 3, 4};
        FileDemo.writeIntArrayToOutputStream(bout, arr);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        int[] res = new int[4];
        FileDemo.readIntArrayFromInputStream(bin, res);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], res[i]);
        }
    }

    @Test
    public void testCSVSave() {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("AAA", "AAA", "AAA", "---");
        people.add(p1);
        Person p2 = new Person("BBB", "BBB", "BBB", "---");
        people.add(p2);
        Flat flat1 = new Flat(11, 100, people);
        ///////////////////////
        people = new ArrayList<>();
        p1 = new Person("CCC", "CCC", "CCC", "---");
        people.add(p1);
        p2 = new Person("DDD", "DDD", "DDD", "---");
        people.add(p2);
        Flat flat2 = new Flat(22, 200, people);
        ///////////////////////
        people = new ArrayList<>();
        p1 = new Person("EEE", "EEE", "EEE", "---");
        people.add(p1);
        p2 = new Person("FFF", "FFF", "FFF", "---");
        people.add(p2);
        Flat flat3 = new Flat(33, 300, people);
        ///////////////////////
        List<Flat> flats = new ArrayList<>();
        flats.add(flat1);
        flats.add(flat2);
        flats.add(flat3);
        Person senior = new Person("Senior", "Senior", "Senior", "---");
        House house = new House("CADASTRAL", "MIRA55A", senior, flats);
        FileDemo.saveAsCSV(house, "./");
    }

    @Test
    public void testFileListFromPath() {
        File mockFolder = mock(File.class);
        File mockDir = mock(File.class);
        when(mockDir.isDirectory()).thenReturn(true);
        when(mockDir.getName()).thenReturn("dir.java");
        File[] mockListFiles = {mockDir, new File("test.java"), new File("test2"), new File("test3.java")};
        when(mockFolder.listFiles()).thenReturn(mockListFiles);
        List<File> files = FileDemo.getFilesWithExtension(mockFolder, ".java");
        assertEquals(2, files.size());
    }

    @Test
    public void testFileListFromPathRecursive() throws IOException {
        File mockFolder = mock(File.class);
        File mockDir = mock(File.class);
        when(mockDir.isDirectory()).thenReturn(true);
        when(mockDir.getName()).thenReturn("dir");
        File mockDirFile1 = mock(File.class);
        File mockDirFile2 = mock(File.class);
        File mockDirFile3 = mock(File.class);
        when(mockDirFile1.isDirectory()).thenReturn(false);
        when(mockDirFile1.getName()).thenReturn("TEST");
        when(mockDirFile1.getAbsolutePath()).thenReturn("C:/TEST");
        when(mockDirFile2.isDirectory()).thenReturn(false);
        when(mockDirFile2.getName()).thenReturn("memento");
        when(mockDirFile2.getAbsolutePath()).thenReturn("C:/memento");
        when(mockDirFile3.isDirectory()).thenReturn(false);
        when(mockDirFile3.getName()).thenReturn("data.json");
        when(mockDirFile3.getAbsolutePath()).thenReturn("C:/data.json");
        File[] listFiles = {mockDirFile1,mockDirFile2,mockDirFile3};
        when(mockDir.listFiles()).thenReturn(listFiles);
        File[] mockListFiles = {mockDir, new File("test.java"), new File("test2"), new File("test3.java")};
        when(mockFolder.listFiles()).thenReturn(mockListFiles);
        List<String> files = FileDemo.getFilesMatchedRegex(mockFolder, ".*\\.java");
        assertEquals(2, files.size());
    }
}
