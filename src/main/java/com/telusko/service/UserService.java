package com.telusko.service;

import com.telusko.paylods.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
  public UserDto createUser(UserDto user);
  public UserDto updateUser(UserDto user,Integer userId);
  public List<UserDto> getAllUsers();
  public UserDto getUserById(Integer userId);
  public void deleteUser(Integer id);
}
