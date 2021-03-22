package com.diplomski.repository;

import com.diplomski.model.Stavka_rn;
import com.diplomski.model.Stavka_rnKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Stavka_rnRepository extends JpaRepository<Stavka_rn, Stavka_rnKey> {
    List<Stavka_rn> findAll();
    Stavka_rn save(Stavka_rn stavka_rn);
    void deleteById(Stavka_rnKey id);
    Optional<Stavka_rn> findById(Stavka_rnKey id);
}
