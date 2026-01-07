package com.way2blood.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.way2blood.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
