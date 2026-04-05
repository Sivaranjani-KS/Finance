package com.example.LearnSpringBoot.controller;

import com.example.LearnSpringBoot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboards")
public class DashboardController {

    @Autowired
    private TransactionService service;

    @GetMapping("/summary")
    public Map<String, Double> summary() {

        try {
            Double income = service.income();
            Double expense = service.expense();

            double safeIncome = (income == null) ? 0 : income;
            double safeExpense = (expense == null) ? 0 : expense;

            Map<String, Double> map = new HashMap<>();
            map.put("Income", safeIncome);
            map.put("Expense", safeExpense);
            map.put("Balance", safeIncome - safeExpense);

            return map;

        } catch (Exception e) {
            
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error while generating dashboard summary"
            );
        }
    }
}

