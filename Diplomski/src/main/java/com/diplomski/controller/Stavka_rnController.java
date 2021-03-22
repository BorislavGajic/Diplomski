package com.diplomski.controller;

import com.diplomski.dto.RnSasDTO;
import com.diplomski.dto.SastavnicaRekurzijaDTO;
import com.diplomski.dto.StanjeDTO;
import com.diplomski.dto.Stavka_rnDTO;
import com.diplomski.model.*;
import com.diplomski.service.MaterijalService;
import com.diplomski.service.Radni_nalogService;
import com.diplomski.service.Stavka_rnService;
import com.diplomski.service.Stavka_sasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/stavka_rn")
public class Stavka_rnController {
    @Autowired
    private Stavka_rnService stavka_rnService;

    @Autowired
    private MaterijalService materijalService;

    @Autowired
    private Radni_nalogService radni_nalogService;

    @Autowired
    private Stavka_sasService stavka_sasService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveStavka_rn(@RequestBody Stavka_rnDTO stavka_rnDTO, HttpServletRequest httpServletRequest) {
        try {
            Stavka_rn stavka_rn = new Stavka_rn();
            List<Stavka_rn> stavka_rns = stavka_rnService.findAll();
            if(stavka_rns.isEmpty()){
                Stavka_rnKey stavka_rnKey = new Stavka_rnKey(stavka_rnDTO.getRnId(), 1);
                stavka_rn.setStavka_rnKey(stavka_rnKey);
            }
            else{
                int velicina = stavka_rns.size();
                Stavka_rn stavka_rn1 = stavka_rns.get(velicina-1);
                for(Stavka_rn s : stavka_rns){
                    if(s.getStavka_rnKey().getSrnId() > stavka_rn1.getStavka_rnKey().getSrnId() ){
                        stavka_rn1 = s;
                    }
                }
                Stavka_rnKey stavka_rnKey = new Stavka_rnKey(stavka_rnDTO.getRnId(), stavka_rn1.getStavka_rnKey().getSrnId()+1);
                stavka_rn.setStavka_rnKey(stavka_rnKey);
            }


            stavka_rn.setKolicinaRn(stavka_rnDTO.getKolicinaRn());


            Optional<Radni_nalog> radni_nalog = radni_nalogService.findById(stavka_rnDTO.getRnId());
            if(radni_nalog.isPresent() ) {
                radni_nalog.ifPresent(radni_nalog1 -> {
                    stavka_rn.setRnId(radni_nalog1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Materijal> materijal = materijalService.findById(stavka_rnDTO.getMatId());
            if(materijal.isPresent() ) {
                materijal.ifPresent(materijal1 -> {
                    stavka_rn.setMatId(materijal1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            stavka_rnService.save(stavka_rn);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Stavka_rn>> getStavka_rn() {
        List<Stavka_rn> stavka_rns = stavka_rnService.findAll();
        if(stavka_rns != null)
        {
            return new ResponseEntity<>(stavka_rns, HttpStatus.OK);
        }
        return new ResponseEntity<>(stavka_rns, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteStavka_rn(@PathVariable Integer id,@PathVariable Integer id1) {
        Stavka_rnKey stavka_rnKey = new Stavka_rnKey(id,id1);
        stavka_rnService.remove(stavka_rnKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<List<Stavka_rn>> getSRNpoRN(@PathVariable Integer id) {
        List<Stavka_rn> stavka_rns = stavka_rnService.findAll();
        List<Stavka_rn> noviSrn = new ArrayList<Stavka_rn>();
        if(stavka_rns != null)
        {
            for(Stavka_rn srn : stavka_rns){
                if(srn.getRnId().getRnId() == id){
                    noviSrn.add(srn);

                }
            }
            return new ResponseEntity<>(noviSrn, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/{id}/{id1}/srnssas" ,consumes = "application/json")
    public ResponseEntity<Void> saveRnSas(@RequestBody RnSasDTO rnSasDTO, @PathVariable Integer id, @PathVariable Integer id1, HttpServletRequest httpServletRequest) {
        try {
            List<Stavka_rn> stavka_rns = stavka_rnService.findAll();
            List<Stavka_sas> stavka_sass = stavka_sasService.findAll();

            // dodavanje ako je ispravno uneto
            if(stavka_rns != null) {
                for (Stavka_sas stavkaSas : stavka_sass) {
                    if (stavkaSas.getStavka_sasKey().getsId() == rnSasDTO.getsId() && stavkaSas.getStavka_sasKey().getSsId() == rnSasDTO.getsSasId()) {
                        for( Stavka_rn stavka_rn : stavka_rns){
                            if (stavka_rn.getStavka_rnKey().getRnId() == id && stavka_rn.getStavka_rnKey().getRnId() == id1) {
                                stavka_rn.getStavka_sasSet().add(stavkaSas);
                                stavka_rnService.save(stavka_rn);
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
