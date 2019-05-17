package omsu.javaprojects.file;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void testFileListFromPath() {
        File mockFolder = mock(File.class);
        File mockDir = mock(File.class);
        when(mockDir.isDirectory()).thenReturn(true);
        when(mockDir.getName()).thenReturn("dir.java");
        File[] mockListFiles = {
                mockDir,
                new File("test.java"),
                new File("test2"),
                new File("test3.java")
        };
        when(mockFolder.listFiles()).thenReturn(mockListFiles);
        List<File> files = FileDemo.getFilesWithExtension(mockFolder, ".java");
        assertEquals(2, files.size());
    }
}
