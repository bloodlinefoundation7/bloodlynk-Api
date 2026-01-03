package com.bloodlynk.bloodlynk_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bloodlynk.bloodlynk_api.entity.BloodBank;

public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
    List<BloodBank> findByAreaAndVerified(String area, boolean verified);
}
