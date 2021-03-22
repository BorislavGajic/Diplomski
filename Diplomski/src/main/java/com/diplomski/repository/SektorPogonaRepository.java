package com.diplomski.repository;

import com.diplomski.model.Radnik;
import com.diplomski.model.Sektor_pogona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SektorPogonaRepository extends JpaRepository<Sektor_pogona, Integer> {
    List<Sektor_pogona> findAll();
    void deleteById(Integer id);
}
