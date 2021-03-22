package com.diplomski.repository;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Pogon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PogonRepository extends JpaRepository<Pogon, Integer> {
    List<Pogon> findAll();
    Pogon save(Pogon pogon);
    Optional<Pogon> findById(Integer id);
    void deleteById(Integer id);
}
