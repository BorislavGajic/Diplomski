package com.diplomski.repository;

import com.diplomski.model.Stanje;
import com.diplomski.model.StanjeKey;
import com.diplomski.model.Tos_multipol;
import com.diplomski.model.Tos_multipolKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tos_multipolRepository extends JpaRepository<Tos_multipol, Tos_multipolKey> {
    List<Tos_multipol> findAll();
    Tos_multipol save(Tos_multipol tos_multipol);
    void deleteById(Tos_multipolKey tos_multipolKey);
}
