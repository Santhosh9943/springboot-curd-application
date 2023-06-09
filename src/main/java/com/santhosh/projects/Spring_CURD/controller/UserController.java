package com.santhosh.projects.Spring_CURD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.projects.Spring_CURD.dto.UserDto;
import com.santhosh.projects.Spring_CURD.service.UserService;
import com.santhosh.projects.Spring_CURD.utils.MyResponseBean;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("create")
	public ResponseEntity<MyResponseBean<UserDto>> saveUser(@RequestBody UserDto userDto) {
		MyResponseBean<UserDto> response = userService.createUser(userDto);
		return ResponseEntity.ok(response);
	}

	@GetMapping("allusers")
	public ResponseEntity<MyResponseBean<List<UserDto>>> allUsers() {
		MyResponseBean<List<UserDto>> response = userService.getAllUsers();
		return ResponseEntity.ok(response);
	}

	@GetMapping("userbyid/{id}")
	public ResponseEntity<MyResponseBean<UserDto>> getUserById(@PathVariable Long id) {
		MyResponseBean<UserDto> response = userService.getUserById(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("updatebyid/{id}")
	public ResponseEntity<MyResponseBean<UserDto>> updateUsers(@PathVariable Long id, @RequestBody UserDto userDto) {
		MyResponseBean<UserDto> response = userService.updateUser(id, userDto);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<MyResponseBean<String>> deleteUsers(@PathVariable Long id) {
		MyResponseBean<String> response = userService.deleteUser(id);
		return ResponseEntity.ok(response);
	}
}
