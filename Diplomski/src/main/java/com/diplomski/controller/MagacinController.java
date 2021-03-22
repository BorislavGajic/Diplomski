package com.diplomski.controller;

import com.diplomski.dto.MagacinDTO;
import com.diplomski.model.Magacin;
import com.diplomski.service.MagacinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/magacin")
public class MagacinController {

    @Autowired
    private MagacinService magacinService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveMagacin(@RequestBody MagacinDTO magacinDTO, HttpServletRequest httpServletRequest) {
        try {
            Magacin magacin = new Magacin();
            magacin.setKolOrmanaM(magacinDTO.getKolOrmanaM());
            magacin.setKolPaleta(magacinDTO.getKolPaleta());
            magacin.setKolViljuskara(magacinDTO.getKolViljuskara());
            magacin.setMaxKolMaterijala(magacinDTO.getMaxKolMaterijala());

            magacinService.save(magacin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Magacin>> getMagacins() {
        List<Magacin> magacins = magacinService.findAll();
        if(magacins != null)
        {
            return new ResponseEntity<>(magacins, HttpStatus.OK);
        }
        return new ResponseEntity<>(magacins, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMagacin(@PathVariable Integer id) {
        magacinService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
