package com.diplomski.repository;

import com.diplomski.model.TipTestKey;
import com.diplomski.model.Tip_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipTestRepository extends JpaRepository<Tip_test, TipTestKey> {
    List<Tip_test> findAll();
    Tip_test save(Tip_test tip_test);
    void deleteById(TipTestKey tipTestKey);
    Optional<Tip_test> findById(TipTestKey tipTestKey);
}
