package com.diplomski.service;

import com.diplomski.model.*;
import com.diplomski.repository.KontrolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KontrolaService {
    @Autowired
    private KontrolaRepository kontrolaRepository;

    public Kontrola save(Kontrola kontrola) {
        return kontrolaRepository.save(kontrola);
    }

    public List<Kontrola> findAll() {
        return kontrolaRepository.findAll(); }

    public void remove(Integer id) {
        kontrolaRepository.deleteById(id);
    }

    public Optional<Kontrola> findById(Integer id) { return  kontrolaRepository.findById(id); }
}
