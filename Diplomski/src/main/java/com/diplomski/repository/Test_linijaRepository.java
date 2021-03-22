package com.diplomski.repository;

import com.diplomski.model.Magacin;
import com.diplomski.model.Test_linija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Test_linijaRepository extends JpaRepository<Test_linija, Integer> {
    List<Test_linija> findAllByTipSp(String tipSp);
    Test_linija save(Test_linija montaza);
    void deleteById(Integer id);
    Optional<Test_linija> findById(Integer id);
}
