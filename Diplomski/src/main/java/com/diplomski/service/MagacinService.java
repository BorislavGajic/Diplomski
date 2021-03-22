package com.diplomski.service;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Magacin;
import com.diplomski.repository.MagacinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagacinService {

    @Autowired
    private MagacinRepository magacinRepository;

    public Magacin save(Magacin magacin) {
        return magacinRepository.save(magacin);
    }
    public Optional<Magacin> findById(Integer id) { return  magacinRepository.findById(id); }
    public List<Magacin> findAll() {
        return magacinRepository.findAll(); }

    public void remove(Integer id) {
        magacinRepository.deleteById(id);
    }
}
