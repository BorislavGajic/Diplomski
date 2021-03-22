package com.diplomski.controller;

import com.diplomski.dto.MaterijalDTO;
import com.diplomski.model.Materijal;
import com.diplomski.service.MaterijalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/materijal")
public class MaterijalController {
    @Autowired
    private MaterijalService materijalService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveMaterijal(@RequestBody MaterijalDTO materijalDTO, HttpServletRequest httpServletRequest) {
        try {
            Materijal materijal = new Materijal();
            materijal.setNazivMat(materijalDTO.getNazivMat());
            materijal.setOpisMat(materijalDTO.getOpisMat());

            materijalService.save(materijal);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Materijal>> getMaterijals() {
        List<Materijal> materijals = materijalService.findAll();
        if(materijals != null)
        {
            return new ResponseEntity<>(materijals, HttpStatus.OK);
        }
        return new ResponseEntity<>(materijals, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMaterijal(@PathVariable Integer id) {
        materijalService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
