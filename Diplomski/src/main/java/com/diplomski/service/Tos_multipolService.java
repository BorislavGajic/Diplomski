package com.diplomski.service;

import com.diplomski.model.Stanje;
import com.diplomski.model.StanjeKey;
import com.diplomski.model.Tos_multipol;
import com.diplomski.model.Tos_multipolKey;
import com.diplomski.repository.Tos_multipolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tos_multipolService {
    @Autowired
    private Tos_multipolRepository tos_multipolRepository;

    public Tos_multipol save(Tos_multipol tos_multipol) {
        return tos_multipolRepository.save(tos_multipol);
    }

    public List<Tos_multipol> findAll() {
        return tos_multipolRepository.findAll(); }

    public void remove(Tos_multipolKey tos_multipolKey) {
        tos_multipolRepository.deleteById(tos_multipolKey);
    }
}
