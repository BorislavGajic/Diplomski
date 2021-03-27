package com.diplomski.service;

import com.diplomski.model.Test;
import com.diplomski.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public List<Test> findAll() {
        return testRepository.findAll(); }

    public void remove(Integer id) {
        testRepository.deleteById(id);
    }

    public Optional<Test> findById(Integer id) { return  testRepository.findById(id); }
}
