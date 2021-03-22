package com.diplomski.service;

import com.diplomski.model.Montaza;
import com.diplomski.model.Reparacija;
import com.diplomski.repository.ReparacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparacijaService {
    @Autowired
    private ReparacijaRepository reparacijaRepository;

    public Reparacija save(Reparacija reparacija) {
        return reparacijaRepository.save(reparacija);
    }

    public List<Reparacija> findAllByTipSp(String tipSp) {
        return reparacijaRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        reparacijaRepository.deleteById(id);
    }
}
