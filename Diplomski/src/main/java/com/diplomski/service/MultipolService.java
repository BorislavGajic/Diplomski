package com.diplomski.service;

import com.diplomski.model.Magacin;
import com.diplomski.model.Montaza;
import com.diplomski.model.Multipol;
import com.diplomski.repository.MultipolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultipolService {
    @Autowired
    private MultipolRepository multipolRepository;

    public Multipol save(Multipol multipol) {
        return multipolRepository.save(multipol);
    }

    public List<Multipol> findAllByTipSp(String tipSp) {
        return multipolRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        multipolRepository.deleteById(id);
    }

    public Optional<Multipol> findById(Integer id) { return  multipolRepository.findById(id); }
}
