package com.diplomski.controller;

import com.diplomski.dto.PogonDTO;
import com.diplomski.model.Pogon;
import com.diplomski.service.PogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/pogon")
public class PogonController {
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> savePogon(@RequestBody PogonDTO pogonDTO, HttpServletRequest httpServletRequest) {
        try {
            Pogon pogon = new Pogon();
            pogon.setKolMasinaP(pogonDTO.getKolMasinaP());
            pogon.setKolOrmanaP(pogonDTO.getKolOrmanaP());
            pogon.setKolStolicaP(pogonDTO.getKolStolicaP());
            pogon.setKolStolovaP(pogonDTO.getKolStolovaP());

            pogonService.save(pogon);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Pogon>> getPogon() {
        List<Pogon> pogons = pogonService.findAll();
        if(pogons != null)
        {
            return new ResponseEntity<>(pogons, HttpStatus.OK);
        }
        return new ResponseEntity<>(pogons, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePogon(@PathVariable Integer id) {
        pogonService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
