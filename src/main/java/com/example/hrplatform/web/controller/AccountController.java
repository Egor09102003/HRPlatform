package com.example.hrplatform.web.controller;

import com.example.hrplatform.entity.Account;
import com.example.hrplatform.service.AccountService;
import com.example.hrplatform.web.annotation.ApiV1;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@ApiV1
@RequiredArgsConstructor
@Controller
public class AccountController {
    @NonNull
    AccountService accountService;

    @GetMapping(value = "/accounts/list")
    public List<Account> getAccountList() {
        return accountService.getAccountList();
    }

    @GetMapping(value = "/accounts/id")
    public Optional<Account> getAccountList(@RequestParam(name="id", required = false, defaultValue = "0") Long id) {
        return accountService.getAccountById(id);
    }
}
