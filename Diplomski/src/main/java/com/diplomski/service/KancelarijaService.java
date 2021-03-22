package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.model.Kancelarija;
import com.diplomski.repository.KancelarijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KancelarijaService {
    @Autowired
    private KancelarijaRepository kancelarijaRepository;

    public Kancelarija save(Kancelarija kancelarija) {
        return kancelarijaRepository.save(kancelarija);
    }
    public Optional<Kancelarija> findById(Integer id) { return  kancelarijaRepository.findById(id); }
    public List<Kancelarija> findAll() {
        return kancelarijaRepository.findAll(); }

    public void remove(Integer id) {
        kancelarijaRepository.deleteById(id);
    }
}
