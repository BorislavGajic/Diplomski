package com.diplomski.repository;

import com.diplomski.model.Kontrola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontrolaRepository extends JpaRepository<Kontrola, Integer> {
    List<Kontrola> findAll();
    Kontrola save(Kontrola test);
    void deleteById(Integer id);
    Optional<Kontrola> findById(Integer id);
}
