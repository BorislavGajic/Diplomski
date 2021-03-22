package com.diplomski.service;

import com.diplomski.model.Magacin;
import com.diplomski.model.Tip_os;
import com.diplomski.repository.Tip_osRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tip_osService {
    @Autowired
    private Tip_osRepository tip_osRepository;

    public Tip_os save(Tip_os tip_os) {
        return tip_osRepository.save(tip_os);
    }
    public Optional<Tip_os> findById(Integer id) { return  tip_osRepository.findById(id); }
    public List<Tip_os> findAll() {
        return tip_osRepository.findAll(); }

    public void remove(Integer id) {
        tip_osRepository.deleteById(id);
    }
}
