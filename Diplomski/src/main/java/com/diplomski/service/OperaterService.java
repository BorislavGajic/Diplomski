package com.diplomski.service;

import com.diplomski.model.Admin;
import com.diplomski.model.Operater;
import com.diplomski.repository.OperaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperaterService {

    @Autowired
    private OperaterRepository operaterRepository;

    public Operater save(Operater operater) {
        return operaterRepository.save(operater);
    }

    public List<Operater> findAllByRadnikTip(String radnikTip) {
        return operaterRepository.findALlByRadnikTip(radnikTip); }

    public void remove(Integer id) {
        operaterRepository.deleteById(id);
    }

}
