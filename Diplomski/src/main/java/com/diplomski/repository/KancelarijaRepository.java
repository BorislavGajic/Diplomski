package com.diplomski.repository;

import com.diplomski.model.Kancelarija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface KancelarijaRepository extends JpaRepository<Kancelarija, Integer> {

    List<Kancelarija> findAll();
    Kancelarija save(Kancelarija kancelarija);
    Optional<Kancelarija> findById(Integer id);
    void deleteById(Integer id);

}
