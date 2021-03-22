package com.diplomski.controller;

import com.diplomski.dto.Tip_sastavnicaDTO;
import com.diplomski.model.Tip_sastavnica;
import com.diplomski.service.Tip_sastavnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tip_sastavnica")
public class Tip_sastavnicaController {

    @Autowired
    private Tip_sastavnicaService tip_sastavnicaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTip_sastavnica(@RequestBody Tip_sastavnicaDTO tip_sastavnicaDTO, HttpServletRequest httpServletRequest) {
        try {
            Tip_sastavnica tip_sastavnica = new Tip_sastavnica();
            tip_sastavnica.setNazivTs(tip_sastavnicaDTO.getNazivTs());

            tip_sastavnicaService.save(tip_sastavnica);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Tip_sastavnica>> getTip_sastavnica() {
        List<Tip_sastavnica> tip_sastavnicas = tip_sastavnicaService.findAll();
        if(tip_sastavnicas != null)
        {
            return new ResponseEntity<>(tip_sastavnicas, HttpStatus.OK);
        }
        return new ResponseEntity<>(tip_sastavnicas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTip_sastavnica(@PathVariable Integer id) {
        tip_sastavnicaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
