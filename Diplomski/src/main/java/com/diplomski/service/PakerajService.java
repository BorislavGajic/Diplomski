package com.diplomski.service;

import com.diplomski.model.Pakeraj;
import com.diplomski.repository.PakerajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PakerajService {
    @Autowired
    private PakerajRepository pakerajRepository;

    public Pakeraj save(Pakeraj pakeraj) {
        return pakerajRepository.save(pakeraj);
    }

    public List<Pakeraj> findAllByTipSp(String tipSp) {
        return pakerajRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        pakerajRepository.deleteById(id);
    }
}
