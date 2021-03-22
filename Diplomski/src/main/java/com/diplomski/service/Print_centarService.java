package com.diplomski.service;

import com.diplomski.model.Montaza;
import com.diplomski.model.Print_centar;
import com.diplomski.repository.Print_centarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Print_centarService {
    @Autowired
    private Print_centarRepository print_centarRepository;

    public Print_centar save(Print_centar print_centar) {
        return print_centarRepository.save(print_centar);
    }

    public List<Print_centar> findAllByTipSp(String tipSp) {
        return print_centarRepository.findAllByTipSp(tipSp); }

    public void remove(Integer id) {
        print_centarRepository.deleteById(id);
    }
}
