package com.repositories;


import com.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    
}