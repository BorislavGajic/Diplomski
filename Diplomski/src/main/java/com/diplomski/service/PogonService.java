package com.diplomski.service;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Pogon;
import com.diplomski.repository.PogonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PogonService {

    @Autowired
    private PogonRepository pogonRepository;

    public Pogon save(Pogon pogon) {
        return pogonRepository.save(pogon);
    }
    public Optional<Pogon> findById(Integer id) { return  pogonRepository.findById(id); }
    public List<Pogon> findAll() {
        return pogonRepository.findAll(); }

    public void remove(Integer id) {
        pogonRepository.deleteById(id);
    }
}
