package omsu.javaprojects.models;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import omsu.javaprojects.service.deserialize.FlatDeserializer;
import omsu.javaprojects.service.serialize.FlatSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonSerialize(using = FlatSerializer.class)
@JsonDeserialize(using = FlatDeserializer.class)
public class Flat implements Serializable {
    private int number;
    private double area;
    private List<Person> owners;

    public Flat(int number, double area, List<Person> owners) {
        this.number = number;
        this.area = area;
        this.owners = owners;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", owners=" + owners +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;
        Flat flat = (Flat) o;
        return getNumber() == flat.getNumber() &&
                Double.compare(flat.getArea(), getArea()) == 0 &&
                Objects.equals(getOwners(), flat.getOwners());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getArea(), getOwners());
    }
}
