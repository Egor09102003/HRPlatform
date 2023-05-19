package com.example.hrplatform.web.controller;

import com.example.hrplatform.entity.Account;
import com.example.hrplatform.entity.Resume;
import com.example.hrplatform.service.AccountService;
import com.example.hrplatform.service.validation.NoSuchElementException;
import com.example.hrplatform.web.annotation.ApiV1;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getAccountById(@RequestParam(name="id", required = false, defaultValue = "-1") Long id
            , Model model, @AuthenticationPrincipal User user) {
        Account account;
        if (id == -1 && user != null) {
            account = accountService.getAccountByUsername(user.getUsername());
        }
        else if (accountService.getAccountById(id).isPresent()) {
            account = accountService.getAccountById(id).get();
        } else {
            throw new NoSuchElementException(String.format("Not found account with id %d", id));
        }
        model.addAttribute("name", account.getName());
        model.addAttribute("age", account.getAge());
        model.addAttribute("male", account.getMale());
        model.addAttribute("mail", account.getMail());
        Resume resume = account.getResume();
        if (resume != null) {
            model.addAttribute("experience", resume.getExperience());
        }
        return new ModelAndView("account_info");
    }

    @PostMapping(value = "/accounts/register")
    public ModelAndView addNewAccount(Account account, Model model) {
        Account currentAccount = accountService.getAccountByUsername(account.getUsername());

        if (currentAccount != null) {
            model.addAttribute("message", "This username is already in use");
            return new ModelAndView("registration");
        }

        accountService.addNewAccount(account);
        return new ModelAndView("redirect:/login");
    }
}
