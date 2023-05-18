package com.example.hrplatform.service;

import com.example.hrplatform.entity.Account;
import com.example.hrplatform.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {
    AccountRepository accountRepository;

    public List<Account> getAccountList() {
        return new ArrayList<>(accountRepository.findAll());
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }
}
