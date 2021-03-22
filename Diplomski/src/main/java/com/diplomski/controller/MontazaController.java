package com.diplomski.controller;


import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Montaza;
import com.diplomski.model.Pogon;
import com.diplomski.service.MontazaService;
import com.diplomski.service.PogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/montaza")
public class MontazaController {

    @Autowired
    private MontazaService montazaService;
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveMontaza(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Montaza montaza = new Montaza();
            montaza.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            montaza.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            montaza.setNazivSp(sektor_pogonaDTO.getNazivSp());
            montaza.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    montaza.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            montazaService.save(montaza);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Montaza>> getMontazas() {
        List<Montaza> montazas = montazaService.findAllByTipSp("Montaza");
        if(montazas != null)
        {
            return new ResponseEntity<>(montazas, HttpStatus.OK);
        }
        return new ResponseEntity<>(montazas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMontaza(@PathVariable Integer id) {
        montazaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
