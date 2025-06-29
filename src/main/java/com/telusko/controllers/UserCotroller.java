package com.telusko.controllers;

import com.telusko.entities.User;
import com.telusko.paylods.ApiResponse;
import com.telusko.paylods.UserDto;
import com.telusko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("user/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable int userId){
       UserDto updatedUser = service.updateUser(userDto,userId);
       return ResponseEntity.ok(updatedUser); //returning updatedUser and status(OK)
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int id){
        service.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse(" User Deleted SuccessFully ",true),HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") int id){
       return  ResponseEntity.ok(service.getUserById(id));
    }

}
