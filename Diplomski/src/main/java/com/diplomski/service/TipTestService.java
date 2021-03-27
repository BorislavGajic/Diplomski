package com.diplomski.service;

import com.diplomski.model.TipTestKey;
import com.diplomski.model.Tip_test;
import com.diplomski.repository.TipTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipTestService {
    @Autowired
    private TipTestRepository tipTestRepository;

    public Tip_test save(Tip_test tip_test) {
        return tipTestRepository.save(tip_test);
    }

    public List<Tip_test> findAll() {
        return tipTestRepository.findAll(); }

    public void remove(TipTestKey tipTestKey) {
        tipTestRepository.deleteById(tipTestKey);
    }

    public Optional<Tip_test> findById(TipTestKey tipTestKey) { return  tipTestRepository.findById(tipTestKey); }
}
