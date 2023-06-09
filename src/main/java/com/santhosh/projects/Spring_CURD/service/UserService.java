package com.santhosh.projects.Spring_CURD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.santhosh.projects.Spring_CURD.dto.UserDto;
import com.santhosh.projects.Spring_CURD.utils.MyResponseBean;

public interface UserService {
	MyResponseBean<UserDto> createUser(UserDto userDto);

    MyResponseBean<UserDto> getUserById(Long userId);

    MyResponseBean<List<UserDto>> getAllUsers();

    MyResponseBean<UserDto> updateUser(Long id, UserDto userDto);

    MyResponseBean<String> deleteUser(Long userId);
}
