package com.diplomski.service;

import com.diplomski.model.Montaza;
import com.diplomski.repository.MontazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MontazaService {
    @Autowired
    private MontazaRepository montazaRepository;

    public Montaza save(Montaza montaza) {
        return montazaRepository.save(montaza);
    }

    public List<Montaza> findAllByTipSp(String tipSp) {
        return montazaRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        montazaRepository.deleteById(id);
    }
}
