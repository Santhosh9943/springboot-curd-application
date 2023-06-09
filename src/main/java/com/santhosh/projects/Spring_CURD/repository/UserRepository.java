package com.santhosh.projects.Spring_CURD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santhosh.projects.Spring_CURD.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
