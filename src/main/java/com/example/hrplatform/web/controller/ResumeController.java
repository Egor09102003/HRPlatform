package com.example.hrplatform.web.controller;

import com.example.hrplatform.entity.Resume;
import com.example.hrplatform.service.ResumeService;
import com.example.hrplatform.web.annotation.ApiV1;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiV1
@RequiredArgsConstructor
@Controller
public class ResumeController {

    @NonNull
    ResumeService resumeService;

    @PostMapping("/resume/add")
    public ResponseEntity<Resume> addResume(@RequestBody Resume resume) {
        return new ResponseEntity<>(resumeService.addNewResume(resume), HttpStatus.OK);
    }
}
