package com.diplomski.repository;

import com.diplomski.model.Pakeraj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PakerajRepository extends JpaRepository<Pakeraj, Integer> {
    List<Pakeraj> findAllByTipSp(String tipSp);
    Pakeraj save(Pakeraj pakeraj);
    void deleteById(Integer id);
}
