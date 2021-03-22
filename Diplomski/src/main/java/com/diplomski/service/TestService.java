package com.diplomski.service;

import com.diplomski.model.Kontrola;
import com.diplomski.model.KontrolaKey;
import com.diplomski.model.Test;
import com.diplomski.model.TestKey;
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

    public void remove(TestKey testKey) {
        testRepository.deleteById(testKey);
    }

    public Optional<Test> findById(TestKey testKey) { return  testRepository.findById(testKey); }
}
