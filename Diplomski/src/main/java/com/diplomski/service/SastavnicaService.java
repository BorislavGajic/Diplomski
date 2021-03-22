package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.model.Radni_nalog;
import com.diplomski.model.Radnik;
import com.diplomski.model.Sastavnica;
import com.diplomski.repository.SastavnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SastavnicaService {
    @Autowired
    private SastavnicaRepository sastavnicaRepository;

    public Sastavnica save(Sastavnica sastavnica) {
        return sastavnicaRepository.save(sastavnica);
    }
    public Optional<Sastavnica> findById(Integer id) { return  sastavnicaRepository.findById(id); }
    public List<Sastavnica> findAll() {
        return sastavnicaRepository.findAll(); }

    public void remove(Integer id) {
        sastavnicaRepository.deleteById(id);
    }
}
