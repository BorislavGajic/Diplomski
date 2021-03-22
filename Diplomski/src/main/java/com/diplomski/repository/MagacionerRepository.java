package com.diplomski.repository;


import com.diplomski.model.Magacioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagacionerRepository extends JpaRepository<Magacioner, Integer> {
    List<Magacioner> findALlByRadnikTip(String radnikTip);
    Magacioner save(Magacioner admin);
    void deleteById(Integer id);
}
