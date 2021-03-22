package com.diplomski.repository;

import com.diplomski.model.Stanje;
import com.diplomski.model.StanjeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StanjeRepository extends JpaRepository<Stanje, StanjeKey> {
    List<Stanje> findAll();
    Stanje save(Stanje stanje);
    void deleteById(StanjeKey stanjeKey);
}
