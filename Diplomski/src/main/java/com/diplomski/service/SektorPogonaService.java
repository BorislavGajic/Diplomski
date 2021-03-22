package com.diplomski.service;

import com.diplomski.model.Sastavnica;
import com.diplomski.model.Sektor_pogona;
import com.diplomski.repository.SektorPogonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SektorPogonaService {
    @Autowired
    private SektorPogonaRepository sektorPogonaRepository;

    public List<Sektor_pogona> findAll() {
        return sektorPogonaRepository.findAll(); }

    public void remove(Integer id) {
        sektorPogonaRepository.deleteById(id);
    }
}
