package com.example.assignment2sp24bse138;

public class Person {

    private String name;
    private String fatherName;
    private String cnicNo;
    private String date;
    private String gender;
    private String city;

    public Person(String name, String fatherName, String cnicNo, String date, String gender, String city) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnicNo = cnicNo;
        this.date = date;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getCnicNo() {
        return cnicNo;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String toString(){
        return String.format("Name : %s | Father Name : %s | CNIC : %s | Date : %s | Gender : %s | City : %s", name, fatherName, cnicNo, date, gender, city);

    }
}
