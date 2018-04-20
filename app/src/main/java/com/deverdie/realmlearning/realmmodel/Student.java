package com.deverdie.realmlearning.realmmodel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by USER275 on 4/20/2018.
 */

public class Student extends RealmObject {
    @PrimaryKey
    private int studentId;

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String city;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
