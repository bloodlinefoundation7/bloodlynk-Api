package com.bloodlynk.bloodlynk_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bloodlynk.bloodlynk_api.entity.BloodStock;
import com.bloodlynk.bloodlynk_api.repository.BloodStockRepository;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private BloodStockRepository stockRepo;

    // Search blood availability by blood group
    @GetMapping("/search")
    public List<BloodStock> search(
            @RequestParam String bloodGroup,
            @RequestParam(required = false) String area) {

        if (area != null && !area.isEmpty()) {
            return stockRepo.findByBloodGroupAndUnitsAvailableGreaterThanAndBloodBank_Area(
                    bloodGroup, 0, area);
        }

        return stockRepo.findByBloodGroupAndUnitsAvailableGreaterThan(bloodGroup, 0);
    }
}
