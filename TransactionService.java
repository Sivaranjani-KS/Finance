package com.example.LearnSpringBoot.service;

import com.example.LearnSpringBoot.model.Transaction;
import com.example.LearnSpringBoot.model.User;
import com.example.LearnSpringBoot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    // ✅ CREATE
    public Transaction save(Transaction t) {

        // 🔐 ROLE CHECK
        if (t.getUser() != null &&
                "VIEWER".equalsIgnoreCase(t.getUser().getRole())) {

            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Access Denied: VIEWER cannot create transactions"
            );
        }

        return repo.save(t);
    }

    // ✅ READ
    public List<Transaction> getAll() {
        return repo.findAll();
    }

    // ✅ DELETE
    public void delete(Long id, User user) {

        // 🔐 ROLE CHECK
        if (user != null &&
                "VIEWER".equalsIgnoreCase(user.getRole())) {

            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Access Denied: VIEWER cannot delete transactions"
            );
        }

        // 🔍 CHECK IF EXISTS
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Transaction not found"
            );
        }

        repo.deleteById(id);
    }

    // ✅ UPDATE
    public Transaction update(Long id, Transaction t) {

        // 🔐 ROLE CHECK
        if (t.getUser() != null &&
                "VIEWER".equalsIgnoreCase(t.getUser().getRole())) {

            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Access Denied: VIEWER cannot update transactions"
            );
        }

        // 🔍 FIND EXISTING
        Transaction existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Transaction not found"
                        ));

        // ✅ UPDATE FIELDS
        existing.setAmount(t.getAmount());
        existing.setType(t.getType());
        existing.setCategory(t.getCategory());
        existing.setDate(t.getDate());
        existing.setDescription(t.getDescription());

        return repo.save(existing);
    }

    // ✅ DASHBOARD
    public Double income() {
        return repo.getTotalIncome();
    }

    public Double expense() {
        return repo.getTotalExpense();
    }
}