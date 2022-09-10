package com.example.demo.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Entity
@Accessors(chain = true)
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean status;
}
