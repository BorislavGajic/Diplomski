package com.diplomski.repository;

import com.diplomski.model.Montaza;
import com.diplomski.model.Print_centar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Print_centarRepository extends JpaRepository<Print_centar, Integer> {
    List<Print_centar> findAllByTipSp(String tipSp);
    Print_centar save(Print_centar print_centar);
    void deleteById(Integer id);
}
