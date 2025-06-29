package com.telusko.controllers;

import com.telusko.entities.User;
import com.telusko.paylods.UserDto;
import com.telusko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserCotroller {

    @Autowired
    UserService service;

    @PostMapping("user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
      UserDto savedUser =  service.createUser(userDto);
      return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
