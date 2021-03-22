package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Multipol;
import com.diplomski.model.Pogon;
import com.diplomski.model.Sektor_pogona;
import com.diplomski.service.MultipolService;
import com.diplomski.service.PogonService;
import com.diplomski.service.SektorPogonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/multipol")
public class MultipolController {
    @Autowired
    private MultipolService multipolService;
    @Autowired
    private PogonService pogonService;
    @Autowired
    private SektorPogonaService sektorPogonaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveMultipol(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Multipol multipol = new Multipol();
            multipol.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            multipol.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            multipol.setNazivSp(sektor_pogonaDTO.getNazivSp());
            multipol.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    multipol.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            multipolService.save(multipol);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Multipol>> getMultipols() {
        List<Multipol> multipols = multipolService.findAllByTipSp("Multipol");
        if(multipols != null)
        {
            return new ResponseEntity<>(multipols, HttpStatus.OK);
        }
        return new ResponseEntity<>(multipols, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMultipol(@PathVariable Integer id) {
        multipolService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
