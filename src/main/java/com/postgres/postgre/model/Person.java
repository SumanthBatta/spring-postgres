package com.postgres.postgre.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id  //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

