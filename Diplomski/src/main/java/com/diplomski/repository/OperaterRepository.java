package com.diplomski.repository;

import com.diplomski.model.Operater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperaterRepository extends JpaRepository<Operater, Integer> {
    List<Operater> findALlByRadnikTip(String radnikTip);
    Operater save(Operater admin);
    void deleteById(Integer id);
}
