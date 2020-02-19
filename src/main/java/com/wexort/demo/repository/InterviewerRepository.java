package com.wexort.demo.repository;

import java.util.List;

import com.wexort.demo.model.Interviewer;

import org.springframework.data.repository.CrudRepository;

public interface InterviewerRepository extends CrudRepository<Interviewer, Long> {
    List<Interviewer> findByFirstName(String FirstName);

    List<Interviewer> findAll();
}