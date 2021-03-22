package com.diplomski.repository;

import com.diplomski.model.Magacin;
import com.diplomski.model.Test_linija;
import com.diplomski.model.Tip_os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tip_osRepository extends JpaRepository<Tip_os, Integer> {
    List<Tip_os> findAll();
    Tip_os save(Tip_os tip_os);
    Optional<Tip_os> findById(Integer id);
    void deleteById(Integer id);
}
