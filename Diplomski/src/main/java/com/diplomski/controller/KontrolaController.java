package com.diplomski.controller;

import com.diplomski.dto.KontrolaDTO;
import com.diplomski.model.*;
import com.diplomski.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/kontrola")
public class KontrolaController {
    @Autowired
    private KontrolaService kontrolaService;

    @Autowired
    private QS_kontrolaService qs_kontrolaService;

    @Autowired
    private Tip_osService tip_osService;

    @Autowired
    private ReparacijaService reparacijaService;

    @Autowired
    private OsiguracService osiguracService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveKontrola(@RequestBody KontrolaDTO kontrolaDTO, HttpServletRequest httpServletRequest) {

            Kontrola kontrola = new Kontrola();
            KontrolaKey kontrolaKey = new KontrolaKey(kontrolaDTO.getQsId(),kontrolaDTO.getTosId());
            kontrola.setKontrolaKey(kontrolaKey);
            kontrola.setNazKont(kontrolaDTO.getNazKont());

            Optional<QS_kontrola> qs_kontrola = qs_kontrolaService.findById(kontrolaDTO.getQsId());
            if(qs_kontrola.isPresent() ) {
                qs_kontrola.ifPresent(qs_kontrola1 -> {
                    kontrola.setQsId(qs_kontrola1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Tip_os> tip_os = tip_osService.findById(kontrolaDTO.getTosId());
            if(tip_os.isPresent() ) {
                tip_os.ifPresent(tip_os1 -> {
                    kontrola.setTosId(tip_os1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Osigurac> osigurac = osiguracService.findById(kontrolaDTO.getOsId());
            if(osigurac.isPresent() ) {
                osigurac.ifPresent(osigurac1 -> {
                    kontrola.setOsigurac(osigurac1);
                    kontrolaService.save(kontrola);
                    osigurac1.setKontrola(kontrola);
                    osiguracService.save(osigurac1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Kontrola>> getKontrola() {
        List<Kontrola> kontrolas = kontrolaService.findAll();
        if(kontrolas != null)
        {
            return new ResponseEntity<>(kontrolas, HttpStatus.OK);
        }
        return new ResponseEntity<>(kontrolas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteKontrola(@PathVariable Integer id,@PathVariable Integer id1 ) {
        KontrolaKey kontrolaKey = new KontrolaKey(id,id1);
        Optional<Kontrola> kontrola = kontrolaService.findById(kontrolaKey);
        if(kontrola.isPresent() ) {
            kontrola.ifPresent(kontrola1 -> {
                Optional<Osigurac> osigurac = osiguracService.findById(kontrola1.getOsigurac().getOsId());
                if(osigurac.isPresent() ) {
                    osigurac.ifPresent(osigurac1 -> {
                        osigurac1.setKontrola(null);
                    });
                }
            });
        }
        kontrolaService.remove(kontrolaKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @PutMapping(value = "/reparacija" ,consumes = "application/json")
    public ResponseEntity<Void> putKoRe(@RequestBody KontrolaDTO kontrolaDTO,HttpServletRequest httpServletRequest) {
        try {
            List<Kontrola> kontrolas = kontrolaService.findAll();
            List<Reparacija> reparacijas = reparacijaService.findAllByTipSp("Reparacija");
            // dodavanje ako je ispravno uneto
            if(kontrolas != null) {
                for (Kontrola kontrola : kontrolas) {
                    if (kontrola.getKontrolaKey().getQsId() == kontrolaDTO.getQsId() && kontrola.getKontrolaKey().getTosId() == kontrolaDTO.getTosId()) {
                        for( Reparacija reparacija : reparacijas){
                            if (reparacija.getSpId() == kontrolaDTO.getReId()) {
                                kontrola.setReId(reparacija);
                                kontrolaService.save(kontrola);
                                return new ResponseEntity<>(HttpStatus.CREATED);
                            }
                        }
                    }
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
