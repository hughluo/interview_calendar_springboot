package com.wexort.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wexort.demo.model.Interviewer;
import com.wexort.demo.repository.InterviewerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewerController {
    @Autowired
    InterviewerRepository repository;

    @GetMapping("/init")
    public String bulkAdd() {
        repository.saveAll(Arrays.asList(new Interviewer("Albert", "Zhang", "albert.z@gmail.com")
                , new Interviewer("Justin", "Bieber", "justin.b@gmail.com")
                , new Interviewer("Tony", "Stark", "tony.s@gmail.com")));

        return "Interviewers are inited";
    }

    @PostMapping("/add")
    public String addNewInterviewer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        Interviewer n = new Interviewer(firstName, lastName, email);
        repository.save(n);

        return "Interviewer is created";
    }

    @GetMapping("/all")
    public List<Interviewer> findAll() {
        return repository.findAll();
    }

}
