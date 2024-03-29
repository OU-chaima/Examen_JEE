package com.example.exam_jsf.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Employe {
    @Id
    @GeneratedValue
    private int id ;
    private String name;
   private String email;
   private List<String> skills;
   @ManyToMany
   private List<Project>projects;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
