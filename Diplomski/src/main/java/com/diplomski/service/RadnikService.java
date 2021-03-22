package com.diplomski.service;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Radnik;
import com.diplomski.repository.RadnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RadnikService {
    @Autowired
    private RadnikRepository radnikRepository;

    public Radnik save(Radnik radnik) {
        return radnikRepository.save(radnik);
    }

    public List<Radnik> findAll() {
        return radnikRepository.findAll(); }

    public void remove(Integer id) {
        radnikRepository.deleteById(id);
    }

    public Optional<Radnik> findById(Integer id) { return  radnikRepository.findById(id); }

}
