package com.diplomski.service;

import com.diplomski.model.Korisnik;
import com.diplomski.model.Osigurac;
import com.diplomski.model.Tip_os;
import com.diplomski.repository.OsiguracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsiguracService {
    @Autowired
    private OsiguracRepository osiguracRepository;

    public Osigurac save(Osigurac osigurac) {
        return osiguracRepository.save(osigurac);
    }

    public List<Osigurac> findAll() {
        return osiguracRepository.findAll(); }

    public void remove(Integer id) {
        osiguracRepository.deleteById(id);
    }

    public Optional<Osigurac> findById(Integer id) { return  osiguracRepository.findById(id); }
}
