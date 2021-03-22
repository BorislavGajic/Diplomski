package com.diplomski.repository;

import com.diplomski.model.Tip_os;
import com.diplomski.model.Tip_sastavnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tip_sastavnicaRepository extends JpaRepository<Tip_sastavnica, Integer> {
    List<Tip_sastavnica> findAll();
    Tip_sastavnica save(Tip_sastavnica tip_sastavnica);
    Optional<Tip_sastavnica> findById(Integer id);
    void deleteById(Integer id);
}
