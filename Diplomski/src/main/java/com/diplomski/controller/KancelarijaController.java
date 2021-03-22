package com.diplomski.controller;


import com.diplomski.dto.KancelarijaDTO;
import com.diplomski.model.Kancelarija;
import com.diplomski.service.KancelarijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/kancelarija")
public class KancelarijaController {
    @Autowired
    private KancelarijaService kancelarijaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveKancelarja(@RequestBody KancelarijaDTO kancelarijaDTO, HttpServletRequest httpServletRequest) {
        try {
            Kancelarija kancelarija = new Kancelarija();
            kancelarija.setKolOrmanaK(kancelarijaDTO.getKol_ormana_k());
            kancelarija.setKolRacunara(kancelarijaDTO.getKol_racunara());
            kancelarija.setKolStolovaK(kancelarijaDTO.getKol_stolova_k());
            kancelarija.setKolStolicaK(kancelarijaDTO.getKol_stolica_k());

            kancelarijaService.save(kancelarija);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Kancelarija>> getKancelarijas() {
        List<Kancelarija> kancelarijas = kancelarijaService.findAll();
        if(kancelarijas != null)
        {
            return new ResponseEntity<>(kancelarijas, HttpStatus.OK);
        }
        return new ResponseEntity<>(kancelarijas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKancelarija(@PathVariable Integer id) {
        kancelarijaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
