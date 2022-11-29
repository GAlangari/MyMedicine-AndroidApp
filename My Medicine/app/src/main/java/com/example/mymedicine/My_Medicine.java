package com.example.mymedicine;

import androidx.room.*;


@Entity

public class My_Medicine {

    @PrimaryKey (autoGenerate =true)
    private int id;

    @ColumnInfo(name = "Name")
    private String name;


    @ColumnInfo(name = "Age")
    private String age;


    @ColumnInfo(name = "Medicine_Name")
    private String medicine_name;


    @ColumnInfo(name = "Dose")
    private String dose;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public String getDose() {
        return dose;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}
