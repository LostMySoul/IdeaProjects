package omsu.javaprojects.lambda.models;

import java.util.Objects;

public class Human {

    private String firstName;
    private String surname;
    private String patronymic;
    private Gender sex;
    private int age;

    public Human(String firstName, String surname, String patronymic, Gender sex, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getSurname(), human.getSurname()) &&
                Objects.equals(getFirstName(), human.getFirstName()) &&
                Objects.equals(getPatronymic(), human.getPatronymic()) &&
                getSex() == human.getSex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getFirstName(), getPatronymic(), getSex(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
