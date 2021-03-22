package com.diplomski.repository;

import com.diplomski.model.Montaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MontazaRepository extends JpaRepository<Montaza, Integer> {
    List<Montaza> findAllByTipSp(String tipSp);
    Montaza save(Montaza montaza);
    void deleteById(Integer id);
}
