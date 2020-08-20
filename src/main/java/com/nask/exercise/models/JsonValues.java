package com.nask.exercise.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JsonValues {

    @Id
    private int id;
    @Column(columnDefinition="VARCHAR(1024)")
    private String value;

    public JsonValues() {
    }

    public JsonValues(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}