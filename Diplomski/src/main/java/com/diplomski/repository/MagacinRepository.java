package com.diplomski.repository;


import com.diplomski.model.Kancelarija;
import com.diplomski.model.Magacin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MagacinRepository extends JpaRepository<Magacin, Integer> {
    List<Magacin> findAll();
    Magacin save(Magacin magacin);
    Optional<Magacin> findById(Integer id);
    void deleteById(Integer id);
}
