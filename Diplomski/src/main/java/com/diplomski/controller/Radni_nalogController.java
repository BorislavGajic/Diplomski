package com.diplomski.controller;

import com.diplomski.dto.AdminDTO;
import com.diplomski.dto.Radni_nalogDTO;
import com.diplomski.model.Admin;
import com.diplomski.model.Kancelarija;
import com.diplomski.model.Pogon;
import com.diplomski.model.Radni_nalog;
import com.diplomski.service.KancelarijaService;
import com.diplomski.service.PogonService;
import com.diplomski.service.Radni_nalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/radni_nalog")
public class Radni_nalogController {
    @Autowired
    private Radni_nalogService radni_nalogService;

    @Autowired
    private KancelarijaService kancelarijaService;

    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveRN(@RequestBody Radni_nalogDTO radni_nalogDTO, HttpServletRequest httpServletRequest) {
        try {
            Radni_nalog radni_nalog = new Radni_nalog();


            Optional<Kancelarija> kancelarija = kancelarijaService.findById(radni_nalogDTO.getKancelarijaKaId());
            if(kancelarija.isPresent() ) {
                kancelarija.ifPresent(kancelarija1 -> {
                    radni_nalog.setKancelarijaKaId(kancelarija1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Pogon> pogon = pogonService.findById(radni_nalogDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    radni_nalog.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            radni_nalogService.save(radni_nalog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Radni_nalog>> getRadniNalogs() {
        List<Radni_nalog> radni_nalogs = radni_nalogService.findAll();
        if(radni_nalogs != null)
        {
            return new ResponseEntity<>(radni_nalogs, HttpStatus.OK);
        }
        return new ResponseEntity<>(radni_nalogs, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRadniNalog(@PathVariable Integer id) {
        radni_nalogService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
