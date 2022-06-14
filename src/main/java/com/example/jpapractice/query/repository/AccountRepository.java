package com.example.jpapractice.query.repository;

import com.example.jpapractice.query.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
