package com.example.hrplatform.service;

import com.example.hrplatform.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAccountList();

    Optional<Account> getAccountById(Long id);

    Account getAccountByUsername(String username);

    void addNewAccount(Account account);
}
