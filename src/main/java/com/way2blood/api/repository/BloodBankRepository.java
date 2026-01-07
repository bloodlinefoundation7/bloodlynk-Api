package com.way2blood.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.way2blood.api.entity.BloodBank;

public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
    List<BloodBank> findByAreaAndVerified(String area, boolean verified);
}
