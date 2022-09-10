package com.example.demo.services;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.responses.StatusResponse;
import org.springframework.stereotype.Component;

@Component
public interface UsersServise {

    UserDTO getUserById(Integer id);

    StatusResponse changeStatus(Integer id, Boolean newStatus);

    UserDTO createUser(UserDTO userDTO);

}
