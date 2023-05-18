package com.example.hrplatform.web.controller;

import com.example.hrplatform.entity.Account;
import com.example.hrplatform.entity.Resume;
import com.example.hrplatform.service.AccountService;
import com.example.hrplatform.service.validation.NoSuchElementException;
import com.example.hrplatform.web.annotation.ApiV1;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView getAccountList(@RequestParam(name="id", required = false, defaultValue = "0") Long id
            , Model model) {
        if (accountService.getAccountById(id).isPresent()) {
            Account account = accountService.getAccountById(id).get();
            model.addAttribute("name", account.getName());
            model.addAttribute("age", account.getAge());
            model.addAttribute("male", account.getMale());
            model.addAttribute("mail", account.getMail());
            Resume resume = account.getResume();
            model.addAttribute("experience", resume.getExperience());
        } else {
            throw new NoSuchElementException(String.format("Not found account with id %d", id));
        }
        model.addAttribute("account", accountService.getAccountById(id).get());
        return new ModelAndView("account_info");
    }
}
