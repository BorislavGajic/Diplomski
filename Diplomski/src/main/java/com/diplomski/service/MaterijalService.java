package com.diplomski.service;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Materijal;
import com.diplomski.repository.MaterijalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterijalService {
    @Autowired
    private MaterijalRepository materijalRepository;

    public Materijal save(Materijal materijal) {
        return materijalRepository.save(materijal);
    }
    public Optional<Materijal> findById(Integer id) { return  materijalRepository.findById(id); }
    public List<Materijal> findAll() {
        return materijalRepository.findAll(); }

    public void remove(Integer id) {
        materijalRepository.deleteById(id);
    }
}
