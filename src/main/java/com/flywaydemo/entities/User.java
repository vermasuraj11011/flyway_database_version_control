package com.flywaydemo.entities;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String name;
    private int age;
    private String mobile;
    private String email;

}
