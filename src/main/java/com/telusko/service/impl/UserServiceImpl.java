package com.telusko.service.impl;

import com.telusko.entities.User;
import com.telusko.exceptions.ResourceNotFoundException;
import com.telusko.paylods.UserDto;
import com.telusko.repositery.UserRepo;
import com.telusko.service.UserService;
import org.hibernate.annotations.NaturalId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto createUser(UserDto userDto) {
       User user = this.userDtoToUser(userDto);
       User savedUser = this.repo.save(user);
       return this.userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = repo.findById(userId)
                                       .orElseThrow(()->new ResourceNotFoundException("USER","ID",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User savedUser = this.repo.save(user);

        return this.userToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {

       List<User> users = this.repo.findAll();
       List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
       return userDtos;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("USER","ID",userId));
        return userToUserDto(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("USER","ID",id));

        repo.delete(user);
    }

    public User userDtoToUser(UserDto userDto){

      User user = mapper.map(userDto,User.class);  //user Dto -> userDto->User
        return  user;

    }

    public UserDto userToUserDto(User user){

        UserDto userDto = mapper.map(user,UserDto.class);  //user -> userDto
        return  userDto;
    }


}
