package com.diplomski.repository;

import com.diplomski.model.Sastavnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SastavnicaRepository extends JpaRepository<Sastavnica, Integer> {

    Sastavnica save(Sastavnica sastavnica);
    void deleteById(Integer id);
    Optional<Sastavnica> findById(Integer id);
    List<Sastavnica> findAll();

}
