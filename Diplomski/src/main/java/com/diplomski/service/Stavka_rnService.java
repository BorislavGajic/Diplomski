package com.diplomski.service;

import com.diplomski.model.*;
import com.diplomski.repository.Stavka_rnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Stavka_rnService {
    @Autowired
    private Stavka_rnRepository stavka_rnRepository;

    public Stavka_rn save(Stavka_rn stavka_rn) {
        return stavka_rnRepository.save(stavka_rn);
    }

    public List<Stavka_rn> findAll() {
        return stavka_rnRepository.findAll(); }

    public void remove(Stavka_rnKey id) {
        stavka_rnRepository.deleteById(id);
    }

    public Optional<Stavka_rn> findById(Stavka_rnKey id) { return  stavka_rnRepository.findById(id); }
}
