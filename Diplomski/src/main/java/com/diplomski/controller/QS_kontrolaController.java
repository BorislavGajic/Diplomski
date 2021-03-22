package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Pogon;
import com.diplomski.model.QS_kontrola;
import com.diplomski.model.Sektor_pogona;
import com.diplomski.service.PogonService;
import com.diplomski.service.QS_kontrolaService;
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
@RequestMapping(value = "/qs_kontrola")
public class QS_kontrolaController {
    @Autowired
    private QS_kontrolaService qs_kontrolaService;
    @Autowired
    private PogonService pogonService;
    @Autowired
    private SektorPogonaService sektorPogonaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveQS_kontrola(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            QS_kontrola qs_kontrola = new QS_kontrola();
            qs_kontrola.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            qs_kontrola.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            qs_kontrola.setNazivSp(sektor_pogonaDTO.getNazivSp());
            qs_kontrola.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    qs_kontrola.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            qs_kontrolaService.save(qs_kontrola);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<QS_kontrola>> getQS_kontrola() {
        List<QS_kontrola> qs_kontrolas = qs_kontrolaService.findAllByTipSp("QS_kontrola");
        if(qs_kontrolas != null)
        {
            return new ResponseEntity<>(qs_kontrolas, HttpStatus.OK);
        }
        return new ResponseEntity<>(qs_kontrolas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteQS_kontrola(@PathVariable Integer id) {
        qs_kontrolaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
