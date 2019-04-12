package omsu.javaprojects.demo;

import omsu.javaprojects.iter.DataIterator;
import omsu.javaprojects.model.Data;

import java.util.ArrayList;
import java.util.List;

public class DataDemo {

    public static List<Integer> getAll(Data data) {
        DataIterator iter = new DataIterator(data);
        List<Integer> res = new ArrayList<>();
        while(iter.hasNext()){
            res.add(iter.next());
        }
        return res;
    }
}
