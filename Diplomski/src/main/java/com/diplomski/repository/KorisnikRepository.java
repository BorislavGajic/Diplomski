package com.diplomski.repository;

import com.diplomski.model.Admin;
import com.diplomski.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    List<Korisnik> findAll();
    Korisnik save(Korisnik korisnik);
    void deleteById(Integer id);
}
