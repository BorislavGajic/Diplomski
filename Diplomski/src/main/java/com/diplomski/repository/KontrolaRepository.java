package com.diplomski.repository;

import com.diplomski.model.Kontrola;
import com.diplomski.model.KontrolaKey;
import com.diplomski.model.Tip_os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontrolaRepository extends JpaRepository<Kontrola, KontrolaKey> {
    List<Kontrola> findAll();
    Kontrola save(Kontrola test);
    void deleteById(KontrolaKey kontrolaKey);
    Optional<Kontrola> findById(KontrolaKey kontrolaKey);
}
