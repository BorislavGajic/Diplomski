package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Pogon;
import com.diplomski.model.Rivet;
import com.diplomski.service.PogonService;
import com.diplomski.service.RivetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/rivet")
public class RivetController {

    @Autowired
    private RivetService rivetService;
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveRivet(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Rivet rivet = new Rivet();
            rivet.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            rivet.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            rivet.setNazivSp(sektor_pogonaDTO.getNazivSp());
            rivet.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    rivet.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            rivetService.save(rivet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Rivet>> getRivets() {
        List<Rivet> rivets = rivetService.findAllByTipSp("Rivet");
        if(rivets != null)
        {
            return new ResponseEntity<>(rivets, HttpStatus.OK);
        }
        return new ResponseEntity<>(rivets, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDivet(@PathVariable Integer id) {
        rivetService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
