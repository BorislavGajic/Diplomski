package com.diplomski.controller;


import com.diplomski.dto.StanjeDTO;
import com.diplomski.model.*;
import com.diplomski.service.MagacinService;
import com.diplomski.service.MaterijalService;
import com.diplomski.service.StanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/stanje")
public class StanjeController {
    @Autowired
    private StanjeService stanjeService;

    @Autowired
    private MaterijalService materijalService;

    @Autowired
    private MagacinService magacinService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveStanje(@RequestBody StanjeDTO stanjeDTO, HttpServletRequest httpServletRequest) {
        try {
            Stanje stanje = new Stanje();
            StanjeKey stanjeKey = new StanjeKey(stanjeDTO.getmId(),stanjeDTO.getMatId());
            stanje.setStanjeKey(stanjeKey);


            Optional<Magacin> magacin = magacinService.findById(stanjeDTO.getmId());
            if(magacin.isPresent() ) {
                magacin.ifPresent(magacin1 -> {
                    stanje.setMagacin(magacin1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Materijal> materijal = materijalService.findById(stanjeDTO.getMatId());
            if(materijal.isPresent() ) {
                materijal.ifPresent(materijal1 -> {
                    stanje.setMaterijal(materijal1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            stanjeService.save(stanje);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Stanje>> getStanjes() {
        List<Stanje> stanjes = stanjeService.findAll();
        if(stanjes != null)
        {
            return new ResponseEntity<>(stanjes, HttpStatus.OK);
        }
        return new ResponseEntity<>(stanjes, HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<List<Stanje>> getStanjePoMat(@PathVariable Integer id) {
        List<Stanje> stanjes = stanjeService.findAll();
        List<Stanje> stanjes1 = new ArrayList<Stanje>();
        if(stanjes != null)
        {
            for(Stanje s : stanjes){
                if(s.getStanjeKey().getMatId() == id){
                    stanjes1.add(s);
                }
            }
            return new ResponseEntity<>(stanjes1, HttpStatus.OK);
        }
        return new ResponseEntity<>(stanjes1, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteStanje(@PathVariable Integer id,@PathVariable Integer id1 ) {
        StanjeKey stanjeKey = new StanjeKey(id,id1);
        stanjeService.remove(stanjeKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
