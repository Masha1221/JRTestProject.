package com.example.demo.controllers;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.responses.StatusResponse;
import com.example.demo.services_Impl.UsersServiseImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersServiseImpl usersServise;

    @PostMapping("/users")
    public Callable<ResponseEntity> createUser(@RequestBody UserDTO user) {
        return () -> {
            try {
                UserDTO userDTO = usersServise.createUser(user);
                return new ResponseEntity<>(userDTO.getId(), HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

    @GetMapping("/users/{id}")
    public UserDTO getOwnerById(@PathVariable Integer id) {
        UserDTO userDTO = usersServise.getUserById(id);
        log.info("Getting information user by id {}. User - {},{}.", id, userDTO.getName(),
                userDTO.getEmail());
        return userDTO;
    }

    @PutMapping("users/{id}")
    public Callable<ResponseEntity> changeStatus(@PathVariable("id") Integer id,
                                                 @RequestBody UserDTO userDTO) {
        return () -> {
            try {
                StatusResponse status = usersServise.changeStatus(id, userDTO.isStatus());
                return new ResponseEntity<>(status, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }
}
