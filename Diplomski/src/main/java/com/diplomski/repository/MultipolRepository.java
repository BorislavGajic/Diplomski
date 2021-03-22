package com.diplomski.repository;

import com.diplomski.model.Multipol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MultipolRepository extends JpaRepository<Multipol, Integer> {
    List<Multipol> findAllByTipSp(String tipSp);
    Multipol save(Multipol multipol);
    void deleteById(Integer id);
    Optional<Multipol> findById(Integer id);
}
