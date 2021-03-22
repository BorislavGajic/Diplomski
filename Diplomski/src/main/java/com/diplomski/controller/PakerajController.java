package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Montaza;
import com.diplomski.model.Pakeraj;
import com.diplomski.model.Pogon;
import com.diplomski.service.PakerajService;
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
@RequestMapping(value = "/pakeraj")
public class PakerajController {
    @Autowired
    private PakerajService pakerajService;
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> savePakeraj(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Pakeraj pakeraj = new Pakeraj();
            pakeraj.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            pakeraj.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            pakeraj.setNazivSp(sektor_pogonaDTO.getNazivSp());
            pakeraj.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    pakeraj.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            pakerajService.save(pakeraj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Pakeraj>> getPakerajs() {
        List<Pakeraj> pakerajs = pakerajService.findAllByTipSp("Pakeraj");
        if(pakerajs != null)
        {
            return new ResponseEntity<>(pakerajs, HttpStatus.OK);
        }
        return new ResponseEntity<>(pakerajs, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePakeraj(@PathVariable Integer id) {
        pakerajService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
