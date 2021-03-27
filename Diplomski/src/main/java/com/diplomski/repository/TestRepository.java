package com.diplomski.repository;

import com.diplomski.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findAll();
    Test save(Test test);
    void deleteById(Integer id);
    Optional<Test> findById(Integer id);
}
