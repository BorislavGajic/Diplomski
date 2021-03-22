package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.model.Stanje;
import com.diplomski.model.StanjeKey;
import com.diplomski.repository.StanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanjeService {
    @Autowired
    private StanjeRepository stanjeRepository;

    public Stanje save(Stanje stanje) {
        return stanjeRepository.save(stanje);
    }

    public List<Stanje> findAll() {
        return stanjeRepository.findAll(); }

    public void remove(StanjeKey stanjeKey) {
        stanjeRepository.deleteById(stanjeKey);
    }
}
