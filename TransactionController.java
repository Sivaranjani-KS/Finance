package com.example.LearnSpringBoot.controller;

import com.example.LearnSpringBoot.model.Transaction;
import com.example.LearnSpringBoot.model.User;
import com.example.LearnSpringBoot.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    // CREATE (VALIDATION ADDED)
    @PostMapping
    public Transaction create(@Valid @RequestBody Transaction t) {
        return service.save(t);
    }

    // READ
    @GetMapping
    public List<Transaction> getAll() {
        return service.getAll();
    }

    // DELETE (WITH BASIC CHECK)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, @RequestBody User user) {
        service.delete(id, user);
        return "Deleted successfully";
    }

    // UPDATE (VALIDATION ADDED)
    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @Valid @RequestBody Transaction t) {
        return service.update(id, t);
    }
}
