package omsu.javaprojects.lambda.models;

import java.util.Objects;

public class Student extends Human {
    private String faculty;
    private String university;
    private String speciality;

    public Student(String firstName, String surname, String patronymic, Gender sex, int age, String faculty, String university, String speciality) {
        super(firstName, surname, patronymic, sex, age);
        this.faculty = faculty;
        this.university = university;
        this.speciality = speciality;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getFaculty(), student.getFaculty()) &&
                Objects.equals(university, student.university) &&
                Objects.equals(speciality, student.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFaculty(), university, speciality);
    }
}
