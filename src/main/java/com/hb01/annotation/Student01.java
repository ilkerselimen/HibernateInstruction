package com.hb01.annotation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity//!!! @Entity ile Bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, student01
@Table(name="t_student01") //!!! DB de tablo isminin "t_student01" olarak degismesini sagladim.
//opsiyoneldir, tablo adi konulmazsa class adini tablo adi olarak default alir
public class Student01 {

    private int id;
    private String name;
    private int grade;

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

    // !!! toString

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
