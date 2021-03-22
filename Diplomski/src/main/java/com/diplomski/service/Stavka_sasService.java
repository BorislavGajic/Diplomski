package com.diplomski.service;

import com.diplomski.model.*;
import com.diplomski.repository.Stavka_sasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Stavka_sasService {

    @Autowired
    private Stavka_sasRepository stavka_sasRepository;

    public Stavka_sas save(Stavka_sas stavka_sas) {
        return stavka_sasRepository.save(stavka_sas);
    }

    public List<Stavka_sas> findAll() {
        return stavka_sasRepository.findAll(); }

    public void remove(Stavka_sasKey stavka_sasKey) {
        stavka_sasRepository.deleteById(stavka_sasKey);
    }
    public Optional<Stavka_sas> findById(Stavka_sasKey stavka_sasKey) { return  stavka_sasRepository.findById(stavka_sasKey); }
}
