package com.diplomski.repository;

import com.diplomski.model.QS_kontrola;
import com.diplomski.model.Test_linija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QS_kontrolaRepository extends JpaRepository<QS_kontrola, Integer> {
    List<QS_kontrola> findAllByTipSp(String tipSp);
    QS_kontrola save(QS_kontrola qs_kontrola);
    void deleteById(Integer id);
    Optional<QS_kontrola> findById(Integer id);
}
