package com.utn.recuperatoriopp;

public class Auto {
    private Integer id;
    private String make;
    private String model;
    private Integer year;

    public Auto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Auto(Integer id, String make, String model, Integer year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



}
