package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> findAllByRadnikTip(String radnikTip) {
        return adminRepository.findALlByRadnikTip(radnikTip); }

    public void remove(Integer id) {
        adminRepository.deleteById(id);
    }
}
