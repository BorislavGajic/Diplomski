package com.diplomski.repository;

import com.diplomski.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, TestKey> {
    List<Test> findAll();
    Test save(Test test);
    void deleteById(TestKey testKey);
    Optional<Test> findById(TestKey testKey);
}
