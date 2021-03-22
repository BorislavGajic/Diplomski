package com.diplomski.service;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Radni_nalog;
import com.diplomski.repository.Radni_nalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Radni_nalogService {
    @Autowired
    private Radni_nalogRepository radni_nalogRepository;

    public Radni_nalog save(Radni_nalog radni_nalog) {
        return radni_nalogRepository.save(radni_nalog);
    }
    public Optional<Radni_nalog> findById(Integer id) { return  radni_nalogRepository.findById(id); }
    public List<Radni_nalog> findAll() {
        return radni_nalogRepository.findAll(); }

    public void remove(Integer id) {
        radni_nalogRepository.deleteById(id);
    }
}
