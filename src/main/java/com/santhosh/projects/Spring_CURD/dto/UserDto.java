package com.santhosh.projects.Spring_CURD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
