package com.diplomski.service;

import com.diplomski.model.QS_kontrola;
import com.diplomski.model.Test_linija;
import com.diplomski.repository.QS_kontrolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QS_kontrolaService {
    @Autowired
    private QS_kontrolaRepository qs_kontrolaRepository;

    public QS_kontrola save(QS_kontrola qs_kontrola) {
        return qs_kontrolaRepository.save(qs_kontrola);
    }

    public List<QS_kontrola> findAllByTipSp(String tipSp) {
        return qs_kontrolaRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        qs_kontrolaRepository.deleteById(id);
    }

    public Optional<QS_kontrola> findById(Integer id) { return  qs_kontrolaRepository.findById(id); }
}
