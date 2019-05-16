package omsu.javaprojects.models;

import java.util.Objects;

public class Student extends Human{

    private String facultyName;

    public Student(String surname, String name, String patronymic, int age, String facultyName) {
        super(surname, name, patronymic, age);
        this.facultyName=facultyName;
    }

    public Student(Student student) {
        super(student.getSurname(), student.getName(), student.getPatronymic(), student.getAge());
        this.facultyName=student.facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getFacultyName(), student.getFacultyName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getFacultyName());
    }
}
