package com.hb02.embeddable;

import com.hb02.Address;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student {

    @Id
    private int id;

    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;

    private int grade;

    @Embedded // optional
    private Address address;

    // !!! GETTER - SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // !!! toString()

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }

}