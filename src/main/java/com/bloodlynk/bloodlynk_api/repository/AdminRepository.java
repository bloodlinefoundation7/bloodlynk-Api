package com.bloodlynk.bloodlynk_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bloodlynk.bloodlynk_api.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password); 

}
