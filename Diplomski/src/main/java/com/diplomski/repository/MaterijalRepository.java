package com.diplomski.repository;

import com.diplomski.model.Kancelarija;
import com.diplomski.model.Materijal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaterijalRepository extends JpaRepository<Materijal, Integer> {
    List<Materijal> findAll();
    Materijal save(Materijal materijal);
    Optional<Materijal> findById(Integer id);
    void deleteById(Integer id);
}
