package org.centaurus.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @Id
    private String matricul;

    private String name;

    private String surname;

    public Student() {

    }

    public String getMatricul() {
        return matricul;
    }

    public void setMatricul(String matricul) {
        this.matricul = matricul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return matricul != null ? matricul.equals(student.matricul) : student.matricul == null;
    }

    @Override
    public int hashCode() {
        return matricul != null ? matricul.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matricul='" + matricul + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
