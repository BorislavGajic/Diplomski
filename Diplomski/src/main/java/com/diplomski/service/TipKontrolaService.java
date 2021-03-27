package com.diplomski.service;

import com.diplomski.model.TipKontrolaKey;
import com.diplomski.model.TipTestKey;
import com.diplomski.model.Tip_kontrola;
import com.diplomski.model.Tip_test;
import com.diplomski.repository.TipKontrolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipKontrolaService {
    @Autowired
    private TipKontrolaRepository tipKontrolaRepository;

    public Tip_kontrola save(Tip_kontrola tip_kontrola) {
        return tipKontrolaRepository.save(tip_kontrola);
    }

    public List<Tip_kontrola> findAll() {
        return tipKontrolaRepository.findAll(); }

    public void remove(TipKontrolaKey tipKontrolaKey) {
        tipKontrolaRepository.deleteById(tipKontrolaKey);
    }

    public Optional<Tip_kontrola> findById(TipKontrolaKey tipKontrolaKey) { return  tipKontrolaRepository.findById(tipKontrolaKey); }

}
