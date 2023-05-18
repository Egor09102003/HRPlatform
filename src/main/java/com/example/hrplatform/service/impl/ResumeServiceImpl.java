package com.example.hrplatform.service.impl;

import com.example.hrplatform.entity.Resume;
import com.example.hrplatform.repository.ResumeRepository;
import com.example.hrplatform.service.ResumeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ResumeServiceImpl implements ResumeService {
    ResumeRepository resumeRepository;

    public Resume addNewResume(Resume resume) {
        return resumeRepository.save(resume);
    }
}
