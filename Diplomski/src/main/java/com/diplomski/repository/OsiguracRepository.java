package com.diplomski.repository;

import com.diplomski.model.Osigurac;
import com.diplomski.model.Tip_os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsiguracRepository extends JpaRepository<Osigurac, Integer> {
    List<Osigurac> findAll();
    Optional<Osigurac> findById(Integer id);
    Osigurac save(Osigurac osigurac);
    void deleteById(Integer id);
}
