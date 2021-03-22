package com.diplomski.service;

import com.diplomski.model.Korisnik;
import com.diplomski.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll(); }

    public void remove(Integer id) {
        korisnikRepository.deleteById(id);
    }
}
