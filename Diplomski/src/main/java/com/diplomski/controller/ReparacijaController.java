package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Montaza;
import com.diplomski.model.Pogon;
import com.diplomski.model.Reparacija;
import com.diplomski.service.PogonService;
import com.diplomski.service.ReparacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/reparacija")
public class ReparacijaController {
    @Autowired
    private ReparacijaService reparacijaService;
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveReparacija(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Reparacija reparacija = new Reparacija();
            reparacija.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            reparacija.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            reparacija.setNazivSp(sektor_pogonaDTO.getNazivSp());
            reparacija.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    reparacija.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            reparacijaService.save(reparacija);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Reparacija>> getReparacijas() {
        List<Reparacija> reparacijas = reparacijaService.findAllByTipSp("Reparacija");
        if(reparacijas != null)
        {
            return new ResponseEntity<>(reparacijas, HttpStatus.OK);
        }
        return new ResponseEntity<>(reparacijas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReparacija(@PathVariable Integer id) {
        reparacijaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
