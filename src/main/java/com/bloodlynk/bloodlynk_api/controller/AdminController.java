package com.bloodlynk.bloodlynk_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bloodlynk.bloodlynk_api.entity.*;
import com.bloodlynk.bloodlynk_api.repository.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private BloodBankRepository bankRepo;

    // Admin login
    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminRepo.findByUsernameAndPassword(
                admin.getUsername(), admin.getPassword());
    }

    // Add blood bank
    @PostMapping("/blood-banks")
    public BloodBank addBank(@RequestBody BloodBank bank) {
        return bankRepo.save(bank);
    }

    // View all blood banks
    @GetMapping("/blood-banks")
    public List<BloodBank> getAllBanks() {
        return bankRepo.findAll();
    }

    // Verify blood bank
    @PutMapping("/blood-banks/{id}/verify")
    public BloodBank verify(@PathVariable Long id) {
        BloodBank bank = bankRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank not found"));
        bank.setVerified(true);
        return bankRepo.save(bank);
    }
}
