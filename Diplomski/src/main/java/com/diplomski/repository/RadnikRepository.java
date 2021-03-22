package com.diplomski.repository;


import com.diplomski.model.Kancelarija;
import com.diplomski.model.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Integer> {
    List<Radnik> findAll();
    Optional<Radnik> findById(Integer id);
    Radnik save(Radnik ad);
    void deleteById(Integer id);
}
