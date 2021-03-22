package com.diplomski.repository;


import com.diplomski.model.Stavka_rn;
import com.diplomski.model.Stavka_sas;
import com.diplomski.model.Stavka_sasKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Stavka_sasRepository extends JpaRepository<Stavka_sas, Stavka_sasKey> {
    List<Stavka_sas> findAll();
    Stavka_sas save(Stavka_sas stavka_sas);
    void deleteById(Stavka_sasKey stavka_sasKey);
    Optional<Stavka_sas> findById(Stavka_sasKey stavka_sasKey);
}
