package com.example.hrplatform.repository;

import com.example.hrplatform.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository  extends JpaRepository<Resume, Long> {

}
