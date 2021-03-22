package com.diplomski.repository;

import com.diplomski.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    List<Admin> findALlByRadnikTip(String radnikTip);
    Admin save(Admin admin);
    void deleteById(Integer id);
}
