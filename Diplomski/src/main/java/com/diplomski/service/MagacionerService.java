package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.model.Magacioner;
import com.diplomski.repository.MagacionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagacionerService {
    @Autowired
    private MagacionerRepository magacionerRepository;

    public Magacioner save(Magacioner magacioner) {
        return magacionerRepository.save(magacioner);
    }

    public List<Magacioner> findAllByRadnikTip(String radnikTip) {
        return magacionerRepository.findALlByRadnikTip(radnikTip); }

    public void remove(Integer id) {
        magacionerRepository.deleteById(id);
    }
}
