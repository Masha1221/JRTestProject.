package com.example.demo.controllers;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.responses.StatusResponse;
import com.example.demo.services_Impl.UsersServiseImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersServiseImpl usersServise;

    @PostMapping("/users")
    public Integer createUser(@RequestBody UserDTO user) {
        UserDTO userDTO = usersServise.createUser(user);
        log.info("Adding a new user. User - {},{},{}.", userDTO.getName(),
                userDTO.getEmail(), userDTO.isStatus());
        return userDTO.getId();
    }

    @GetMapping("/users/{id}")
    public UserDTO getOwnerById(@PathVariable Integer id) {
        UserDTO userDTO = usersServise.getUserById(id);
        log.info("Getting information user by id {}. User - {},{}.", id, userDTO.getName(),
                userDTO.getEmail());
        return userDTO;
    }

    @PutMapping("/users/{id}")
    public StatusResponse changeStatus(@PathVariable("id") Integer id,
                                       @RequestBody UserDTO userDTO) {
        log.info("Change the status of the user with id - {}.", id);
        return usersServise.changeStatus(id, userDTO.isStatus());
    }
}
