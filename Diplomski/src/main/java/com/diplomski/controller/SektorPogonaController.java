package com.diplomski.controller;

import com.diplomski.model.Sektor_pogona;
import com.diplomski.service.SektorPogonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/sektor_pogona")
public class SektorPogonaController {

    @Autowired
    private SektorPogonaService sektorPogonaService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Sektor_pogona>> getSPs() {
        List<Sektor_pogona> sektor_pogonas = sektorPogonaService.findAll();
        if(sektor_pogonas != null)
        {
            return new ResponseEntity<>(sektor_pogonas, HttpStatus.OK);
        }
        return new ResponseEntity<>(sektor_pogonas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSP(@PathVariable Integer id) {
        sektorPogonaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
