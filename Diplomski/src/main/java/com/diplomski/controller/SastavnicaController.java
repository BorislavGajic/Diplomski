package com.diplomski.controller;

import com.diplomski.dto.SasMatDTO;
import com.diplomski.dto.SastavnicaDTO;
import com.diplomski.dto.SastavnicaRekurzijaDTO;
import com.diplomski.model.*;
import com.diplomski.service.MaterijalService;
import com.diplomski.service.SastavnicaService;
import com.diplomski.service.Tip_sastavnicaService;
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
@RequestMapping(value = "/sastavnica")
public class SastavnicaController {

    @Autowired
    private SastavnicaService sastavnicaService;

    @Autowired
    private Tip_sastavnicaService tip_sastavnicaService;

    @Autowired
    private MaterijalService materijalService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveSastavnica(@RequestBody SastavnicaDTO sastavnicaDTO, HttpServletRequest httpServletRequest) {
        try {
            Sastavnica sastavnica = new Sastavnica();

            Optional<Tip_sastavnica> tip_sastavnica = tip_sastavnicaService.findById(sastavnicaDTO.getTsId());
            if(tip_sastavnica.isPresent() ) {
                tip_sastavnica.ifPresent(tip_sastavnica1 -> {
                    sastavnica.setTip_sastavnicaTsId(tip_sastavnica1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            sastavnicaService.save(sastavnica);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Sastavnica>> getSastavnicas() {
        List<Sastavnica> sastavnicas = sastavnicaService.findAll();
        if(sastavnicas != null)
        {
            return new ResponseEntity<>(sastavnicas, HttpStatus.OK);
        }
        return new ResponseEntity<>(sastavnicas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSastavnica(@PathVariable Integer id) {
        sastavnicaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping(value = "/{id}/semnje", produces = "application/json")
    public ResponseEntity<List<Sastavnica>> getDrugeSastavnicas(@PathVariable Integer id) {
        List<Sastavnica> sastavnicas = sastavnicaService.findAll();
        List<Sastavnica> sastavnicas1 = new ArrayList<Sastavnica>();
        if(!sastavnicas.isEmpty())
        {
            for(Sastavnica s : sastavnicas){
                if(s.getsId() != id){
                    sastavnicas1.add(s);
                }
            }
            return new ResponseEntity<>(sastavnicas1, HttpStatus.OK);
        }
        return new ResponseEntity<>(sastavnicas1, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/{id}/rekurzija" ,consumes = "application/json")
    public ResponseEntity<Void> saveSastavnicaRekurzija(@RequestBody SastavnicaRekurzijaDTO sastavnicaRekurzijaDTO,@PathVariable Integer id, HttpServletRequest httpServletRequest) {
        try {
            List<Sastavnica> sastavnicas = sastavnicaService.findAll();

            // prepreka ulancavanja
            for(Sastavnica s1 : sastavnicas){
                if(s1.getsId() == id){
                    for(Sastavnica sRek : sastavnicas){
                        if(sRek.getSastavn1icaSet().contains(s1) && sRek.getsId() == sastavnicaRekurzijaDTO.getsId()){
                            System.out.println(3);
                            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                        }
                    }
                }
            }
            // dodavanje ako je ispravno uneto
            if(sastavnicaRekurzijaDTO.getsId() != id && sastavnicas != null) {
                for (Sastavnica sRek : sastavnicas) {
                    if (sRek.getsId() == sastavnicaRekurzijaDTO.getsId()) {
                        for (Sastavnica s1 : sastavnicas) {
                            if (s1.getsId() == id) {
                                s1.getSastavn1icaSet().add(sRek);
                                sastavnicaService.save(s1);
                                return new ResponseEntity<>(HttpStatus.CREATED);
                            }
                        }
                    }
                }
            }
            System.out.println(4);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @PutMapping(value = "/{id}/sasmat" ,consumes = "application/json")
    public ResponseEntity<Void> saveRnSas(@RequestBody SasMatDTO sasMatDTO, @PathVariable Integer id, HttpServletRequest httpServletRequest) {
        try {
            List<Sastavnica> sastavnicas = sastavnicaService.findAll();
            List<Materijal> materijals = materijalService.findAll();

            // dodavanje ako je ispravno uneto
            if(sastavnicas != null) {
                for (Materijal materijal : materijals) {
                    if (materijal.getMatId() == sasMatDTO.getMatId()) {
                        for( Sastavnica sastavnica : sastavnicas){
                            if (sastavnica.getsId() == id) {
                                sastavnica.getMaterijalSet().add(materijal);
                                sastavnicaService.save(sastavnica);
                                return new ResponseEntity<>(HttpStatus.CREATED);
                            }
                        }
                    }
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
