package com.diplomski.service;

import com.diplomski.model.Magacin;
import com.diplomski.model.Test_linija;
import com.diplomski.repository.Test_linijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Test_linijaService {
    @Autowired
    private Test_linijaRepository test_linijaRepository;

    public Test_linija save(Test_linija test_linija) {
        return test_linijaRepository.save(test_linija);
    }

    public List<Test_linija> findAllByTipSp(String tipSp) {
        return test_linijaRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        test_linijaRepository.deleteById(id);
    }

    public Optional<Test_linija> findById(Integer id) { return  test_linijaRepository.findById(id); }
}
