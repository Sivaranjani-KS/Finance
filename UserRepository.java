package com.example.LearnSpringBoot.repository;


import com.example.LearnSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
