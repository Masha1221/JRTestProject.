package com.example.demo.services_Impl;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.entities.UserEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.responses.StatusResponse;
import com.example.demo.services.UsersServise;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsersServiseImpl implements UsersServise {

    private final UsersRepository usersRepository;

    public UsersServiseImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        usersRepository.save(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found owner with id" + id));
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

    @Override
    public StatusResponse changeStatus(Integer id, Boolean newStatus) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Not found owner with id" + id));
        boolean old = userEntity.isStatus();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setStatus(newStatus);
        usersRepository.save(userEntity);
        boolean newStatus1 = userDTO.isStatus();
        return new StatusResponse(userDTO.getId(), newStatus1, old);
    }
}

