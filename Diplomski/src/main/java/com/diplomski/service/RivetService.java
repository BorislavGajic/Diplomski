package com.diplomski.service;

import com.diplomski.model.Rivet;
import com.diplomski.repository.RiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RivetService {
    @Autowired
    private RiverRepository riverRepository;

    public Rivet save(Rivet rivet) {
        return riverRepository.save(rivet);
    }

    public List<Rivet> findAllByTipSp(String tipSp) {
        return riverRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        riverRepository.deleteById(id);
    }
}
