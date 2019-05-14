package omsu.javaprojects.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import omsu.javaprojects.service.deserialize.PersonDeserializer;
import omsu.javaprojects.service.serialize.PersonSerializer;

import java.util.Objects;

@JsonSerialize(using = PersonSerializer.class)
@JsonDeserialize(using = PersonDeserializer.class)
public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthDate;

    public Person(String firstName, String lastName, String patronymic, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getPatronymic(), person.getPatronymic()) &&
                Objects.equals(getBirthDate(), person.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPatronymic(), getBirthDate());
    }
}
