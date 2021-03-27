package com.diplomski.repository;

import com.diplomski.model.TipKontrolaKey;
import com.diplomski.model.TipTestKey;
import com.diplomski.model.Tip_kontrola;
import com.diplomski.model.Tip_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipKontrolaRepository extends JpaRepository<Tip_kontrola, TipKontrolaKey> {
    List<Tip_kontrola> findAll();
    Tip_kontrola save(Tip_kontrola tip_kontrola);
    void deleteById(TipKontrolaKey tipKontrolaKey);
    Optional<Tip_kontrola> findById(TipKontrolaKey tipKontrolaKey);
}
