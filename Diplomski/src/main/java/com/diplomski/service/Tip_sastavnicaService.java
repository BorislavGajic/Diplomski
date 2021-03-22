package com.diplomski.service;

import com.diplomski.model.Tip_os;
import com.diplomski.model.Tip_sastavnica;
import com.diplomski.repository.Tip_sastavnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tip_sastavnicaService {
    @Autowired
    private Tip_sastavnicaRepository tip_sastavnicaRepository;

    public Tip_sastavnica save(Tip_sastavnica tip_sastavnica) {
        return tip_sastavnicaRepository.save(tip_sastavnica);
    }
    public Optional<Tip_sastavnica> findById(Integer id) { return  tip_sastavnicaRepository.findById(id); }
    public List<Tip_sastavnica> findAll() {
        return tip_sastavnicaRepository.findAll(); }

    public void remove(Integer id) {
        tip_sastavnicaRepository.deleteById(id);
    }
}
