package com.cenfotec.graphql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String modelCode;

    private String brandName;

    private LocalDate launchDate;

    private transient String formattedDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getFormattedDate() {
        return getLaunchDate().toString();
    }

    public Vehicle(int id, String type, String modelCode, String brandName, LocalDate launchDate, String formattedDate) {
        this.id = id;
        this.type = type;
        this.modelCode = modelCode;
        this.brandName = brandName;
        this.launchDate = launchDate;
        this.formattedDate = formattedDate;
    }

    public Vehicle() {
    }
}