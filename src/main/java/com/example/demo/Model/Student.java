package com.example.demo.Model;

import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String imagename;
    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @Lob
    private byte[] data;
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }



    public Student() {
    }

    private String name;
    private String College;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCollege(String college) {
        College = college;
    }

    private int age;


    public String getName() {
        return name;
    }

    public String getCollege() {
        return College;
    }

    public int getAge() {
        return age;
    }
}
