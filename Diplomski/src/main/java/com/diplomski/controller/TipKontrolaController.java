package com.diplomski.controller;

import com.diplomski.dto.TipKontrolaDTO;
import com.diplomski.model.*;
import com.diplomski.service.QS_kontrolaService;
import com.diplomski.service.TipKontrolaService;
import com.diplomski.service.Tip_osService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/tip_kontrola")
public class TipKontrolaController {

    @Autowired
    private TipKontrolaService tipKontrolaService;

    @Autowired
    private QS_kontrolaService qs_kontrolaService;

    @Autowired
    private Tip_osService tip_osService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTipKontrola(@RequestBody TipKontrolaDTO tipKontrolaDTO, HttpServletRequest httpServletRequest) {

        Tip_kontrola tip_kontrola = new Tip_kontrola();
        TipKontrolaKey tipKontrolaKey = new TipKontrolaKey(tipKontrolaDTO.getQsId(),tipKontrolaDTO.getTosId());
        tip_kontrola.setTipKontrolaKey(tipKontrolaKey);

        Optional<QS_kontrola> qs_kontrola = qs_kontrolaService.findById(tipKontrolaDTO.getQsId());
        if(qs_kontrola.isPresent() ) {
            qs_kontrola.ifPresent(qs_kontrola1 -> {
                tip_kontrola.setQsId(qs_kontrola1);
            });
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        Optional<Tip_os> tip_os = tip_osService.findById(tipKontrolaDTO.getTosId());
        if(tip_os.isPresent() ) {
            tip_os.ifPresent(tip_os1 -> {
                tip_kontrola.setTosId(tip_os1);
            });
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        this.tipKontrolaService.save(tip_kontrola);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Tip_kontrola>> getTipKontrola() {
        List<Tip_kontrola> tip_kontrolas = tipKontrolaService.findAll();
        if(tip_kontrolas != null)
        {
            return new ResponseEntity<>(tip_kontrolas, HttpStatus.OK);
        }
        return new ResponseEntity<>(tip_kontrolas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteTipKontrola(@PathVariable Integer id,@PathVariable Integer id1 ) {
        TipKontrolaKey tipKontrolaKey = new TipKontrolaKey(id,id1);
        tipKontrolaService.remove(tipKontrolaKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
