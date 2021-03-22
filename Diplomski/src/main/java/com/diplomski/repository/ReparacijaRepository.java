package com.diplomski.repository;

import com.diplomski.model.Montaza;
import com.diplomski.model.Reparacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparacijaRepository extends JpaRepository<Reparacija, Integer> {
    List<Reparacija> findAllByTipSp(String tipSp);
    Reparacija save(Reparacija reparacija);
    void deleteById(Integer id);
}
