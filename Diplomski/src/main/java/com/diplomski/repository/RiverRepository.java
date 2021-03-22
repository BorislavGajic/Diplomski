package com.diplomski.repository;

import com.diplomski.model.Rivet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiverRepository extends JpaRepository<Rivet, Integer> {
    List<Rivet> findAllByTipSp(String tipSp);
    Rivet save(Rivet montaza);
    void deleteById(Integer id);

}
