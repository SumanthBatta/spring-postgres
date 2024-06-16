package com.postgres.postgre.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id  //for primary key
    private long id;
    private String name;
}

