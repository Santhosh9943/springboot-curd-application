package com.santhosh.projects.Spring_CURD.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santhosh.projects.Spring_CURD.dto.UserDto;
import com.santhosh.projects.Spring_CURD.entity.User;
import com.santhosh.projects.Spring_CURD.repository.UserRepository;
import com.santhosh.projects.Spring_CURD.service.UserService;
import com.santhosh.projects.Spring_CURD.utils.MyResponseBean;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Common method to build the MyResponseBean object
	private <T> MyResponseBean<T> buildResponse(T data, String message, boolean success) {
		return MyResponseBean.<T>builder()
			.data(data)
			.message(message)
			.success(success)
			.build();
	}

	@Override
	public MyResponseBean<UserDto> createUser(UserDto userDto) {
		if (userDto.getId() == null) {
			User user = modelMapper.map(userDto, User.class);
			userRepository.save(user);
			UserDto savedUserDto = modelMapper.map(user, UserDto.class);
			return buildResponse(savedUserDto, "User Created Successfully", true);
		} else {
			return buildResponse(null, "Not Created", false);
		}
	}

	@Override
	public MyResponseBean<UserDto> getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			UserDto userDto = modelMapper.map(user.get(), UserDto.class);
			return buildResponse(userDto, "Get User By Id Successfully", true);
		} else {
			return buildResponse(null, "Get User By Id Failed", false);
		}
	}

	@Override
	public MyResponseBean<List<UserDto>> getAllUsers() {
		List<User> allUser = userRepository.findAll();
		List<UserDto> allUserDto = allUser.stream()
			.map(user -> modelMapper.map(user, UserDto.class))
			.toList();
		return buildResponse(allUserDto, "Get All Users Successfully", true);
	}

	@Override
	public MyResponseBean<UserDto> updateUser(Long id, UserDto userDto) {
		Optional<User> user1 = userRepository.findById(id);
		User user = user1.get();
		if (userDto.getId() != null && userDto.getId().equals(user.getId())) {
			user = modelMapper.map(userDto, User.class);
			userRepository.save(user);
			return buildResponse(userDto, "User Updated Successfully", true);
		} else {
			return buildResponse(null, "Not Updated", false);
		}
	}

	@Override
	public MyResponseBean<String> deleteUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.deleteById(userId);
			return buildResponse(user.toString(), userId + " UserId Deleted Successfully", true);
		} else {
			return buildResponse(null, "Not Deleted", false);
		}
	}
}
