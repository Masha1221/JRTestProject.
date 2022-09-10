package com.example.demo.DTOs;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private boolean status;
}
