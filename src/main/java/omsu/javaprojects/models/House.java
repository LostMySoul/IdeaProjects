package omsu.javaprojects.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import omsu.javaprojects.service.serialize.HouseSerializer;
import omsu.javaprojects.service.deserialize.HouseDeserializer;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonSerialize(using = HouseSerializer.class)
@JsonDeserialize(using = HouseDeserializer.class)
public class House implements Serializable {
    private String cadastralId;
    private String adress;
    private Person senior;
    private List<Flat> flats;

    public House(String cadastralId, String adress, Person senior, List<Flat> flats) {
        this.cadastralId = cadastralId;
        this.adress = adress;
        this.senior = senior;
        this.flats = flats;
    }

    public String getCadastralId() {
        return cadastralId;
    }

    public void setCadastralId(String cadastralId) {
        this.cadastralId = cadastralId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Person getSenior() {
        return senior;
    }

    public void setSenior(Person senior) {
        this.senior = senior;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(getCadastralId(), house.getCadastralId()) &&
                Objects.equals(getAdress(), house.getAdress()) &&
                Objects.equals(getSenior(), house.getSenior()) &&
                Objects.equals(getFlats(), house.getFlats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCadastralId(), getAdress(), getSenior(), getFlats());
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralId='" + cadastralId + '\'' +
                ", adress='" + adress + '\'' +
                ", senior=" + senior +
                ", flats=" + flats +
                '}';
    }
}
