package com.bloodlynk.bloodlynk_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bloodlynk.bloodlynk_api.entity.BloodStock;

public interface BloodStockRepository extends JpaRepository<BloodStock, Long> {

    // Find stocks by blood group and units available
    List<BloodStock> findByBloodGroupAndUnitsAvailableGreaterThan(String bloodGroup, int units);

    // Find stocks by blood group, units, and bank area
    List<BloodStock> findByBloodGroupAndUnitsAvailableGreaterThanAndBloodBank_Area(
            String bloodGroup, int units, String area);

    // Find all stocks for a specific bank
    List<BloodStock> findByBloodBankId(Long bankId);
}
