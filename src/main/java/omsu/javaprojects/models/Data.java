package omsu.javaprojects.models;

import omsu.javaprojects.exec.Executable;
import omsu.javaprojects.iter.DataIterator;

import java.util.Objects;


public class Data implements Iterable, Executable {
    private String nameOfSet;
    private Group[] groups = null;

    public Data() {
        nameOfSet = "Default Data";
    }

    public Data(String nameOfSet, Group... data) {
        this.nameOfSet = nameOfSet;
        groups = new Group[data.length];
        for (int i = 0; i < data.length; i++) {
            groups[i] = data[i];
        }
    }

    public Data(Data obj) {
        this.nameOfSet = obj.nameOfSet;
        groups = new Group[obj.groups.length];
        for (int i = 0; i < obj.groups.length; i++) {
            groups[i] = obj.groups[i];
        }
    }

    public Data(Data obj, String nameOfSet) {
        this.nameOfSet = nameOfSet;
        groups = new Group[obj.groups.length];
        for (int i = 0; i < obj.groups.length; i++) {
            groups[i] = obj.groups[i];
        }
    }

    public void setNameOfSet(String nameOfSet) {
        this.nameOfSet = nameOfSet;
    }

    public String getNameOfSet() {
        return nameOfSet;
    }

    public void setGroups(Group... groups) {
        this.groups = new Group[groups.length];
        for (int i = 0; i < groups.length; i++) {
            this.groups[i] = groups[i];
        }
    }

    public Group[] getGroups() {
        return groups;
    }

    public int length() {
        return this.groups.length;
    }

    @Override
    public DataIterator iterator() {
        DataIterator iter = new DataIterator(this);
        return iter;
    }

    @Override
    public void execute() {
        System.out.println("Executed from " + this.getClass().getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(getNameOfSet(), data.getNameOfSet()) &&
                Objects.equals(getGroups(), data.getGroups());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNameOfSet(), getGroups());
    }
}