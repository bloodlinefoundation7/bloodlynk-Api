package com.bloodlynk.bloodlynk_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bloodlynk.bloodlynk_api.entity.*;
import com.bloodlynk.bloodlynk_api.repository.*;

@RestController
@RequestMapping("/admin/blood-stock")
public class BloodStockController {

    @Autowired
    private BloodStockRepository stockRepo;

    @Autowired
    private BloodBankRepository bankRepo;

    // Add blood stock for a bank
    @PostMapping("/add")
    public BloodStock addStock(@RequestParam Long bankId, @RequestBody BloodStock stock) {
        BloodBank bank = bankRepo.findById(bankId)
                .orElseThrow(() -> new RuntimeException("Bank not found"));
        stock.setBloodBank(bank);
        return stockRepo.save(stock);
    }

    // Update stock units
    @PutMapping("/update/{stockId}")
    public BloodStock updateStock(@PathVariable Long stockId, @RequestParam int units) {
        BloodStock stock = stockRepo.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setUnitsAvailable(units);
        return stockRepo.save(stock);
    }

    // View stock for a bank
    @GetMapping("/bank/{bankId}")
    public List<BloodStock> getStock(@PathVariable Long bankId) {
        return stockRepo.findByBloodBankId(bankId);
    }

    // Delete stock
    @DeleteMapping("/delete/{stockId}")
    public String deleteStock(@PathVariable Long stockId) {
        stockRepo.deleteById(stockId);
        return "Stock deleted successfully";
    }
}
