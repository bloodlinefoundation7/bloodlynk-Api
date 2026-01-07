package com.way2blood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.way2blood.api.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password); 

}
