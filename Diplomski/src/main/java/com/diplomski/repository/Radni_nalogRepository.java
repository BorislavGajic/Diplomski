package com.diplomski.repository;

import com.diplomski.model.Radni_nalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Radni_nalogRepository extends JpaRepository<Radni_nalog, Integer> {
    Radni_nalog save(Radni_nalog radni_nalog);
    void deleteById(Integer id);
    Optional<Radni_nalog> findById(Integer id);
    List<Radni_nalog> findAll();
}
