package omsu.javaprojects.model;

import omsu.javaprojects.exceptions.IllegalIdException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private int id;
    private int[] data = new int[0];

    public Group() {
        id = 1;
    }

    public Group(int id, int... data) throws IllegalIdException {
        if (id <= 0) {
            throw new IllegalIdException();
        }
        this.id = id;
        int size = (int) (data.length);
        this.data = new int[size];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
    }

    public Group(Group obj) {
        this.id = obj.id;
        this.data = new int[obj.data.length];
        this.data = obj.data;
    }

    public Group(Group obj, int id) {
        this.id = id;
        this.data = new int[obj.data.length];
        this.data = obj.data;
    }

    public int getId() {
        return id;
    }

    public int[] getData() {
        return data;
    }

    public int length() {
        return data.length;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalIdException();
        }
        this.id = id;
    }

    public void setData(int... data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getId() == group.getId() &&
                Objects.equals(getData(), group.getData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getData());
    }
}
