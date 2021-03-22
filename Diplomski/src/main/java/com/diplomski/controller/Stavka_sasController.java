package com.diplomski.controller;

import com.diplomski.dto.RnSasDTO;
import com.diplomski.dto.SsasStanjeDTO;
import com.diplomski.dto.Stavka_sasDTO;
import com.diplomski.model.*;
import com.diplomski.service.SastavnicaService;
import com.diplomski.service.StanjeService;
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
@RequestMapping(value = "/stavka_sas")
public class Stavka_sasController {
    @Autowired
    private Stavka_sasService stavka_sasService;

    @Autowired
    private SastavnicaService sastavnicaService;

    @Autowired
    private StanjeService stanjeService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveStavka_sas(@RequestBody Stavka_sasDTO stavka_sasDTO, HttpServletRequest httpServletRequest) {
        try {
            Stavka_sas stavka_sas = new Stavka_sas();
            List<Stavka_sas> stavka_sass = stavka_sasService.findAll();
            if(stavka_sass.isEmpty()) {
                Stavka_sasKey stavka_sasKey = new Stavka_sasKey(stavka_sasDTO.getsId(), 1);
                stavka_sas.setStavka_sasKey(stavka_sasKey);
            }else{
                int velicina = stavka_sass.size();
                Stavka_sas stavka_sas1 = stavka_sass.get(velicina-1);
                for(Stavka_sas s : stavka_sass){
                    if(s.getStavka_sasKey().getSsId() > stavka_sas1.getStavka_sasKey().getSsId() ){
                        stavka_sas1 = s;
                    }
                }
                Stavka_sasKey stavka_sasKey = new Stavka_sasKey(stavka_sasDTO.getsId(), stavka_sas1.getStavka_sasKey().getSsId()+1);
                stavka_sas.setStavka_sasKey(stavka_sasKey);
            }


            stavka_sas.setKolicinaSs(stavka_sasDTO.getKolicinaSs());

            Optional<Sastavnica> sastavnica = sastavnicaService.findById(stavka_sasDTO.getsId());
            if(sastavnica.isPresent() ) {
                sastavnica.ifPresent(sastavnica1 -> {
                    stavka_sas.setsId(sastavnica1);
                });
            }
            else{
                System.out.println("Nije nasao sastavnicu");
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            stavka_sasService.save(stavka_sas);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Stavka_sas>> getStavka_sas() {
        List<Stavka_sas> stavka_sas = stavka_sasService.findAll();
        if(stavka_sas != null)
        {
            return new ResponseEntity<>(stavka_sas, HttpStatus.OK);
        }
        return new ResponseEntity<>(stavka_sas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteStavka_sas(@PathVariable Integer id,@PathVariable Integer id1) {
        Stavka_sasKey stavka_sasKey = new Stavka_sasKey(id,id1);
        stavka_sasService.remove(stavka_sasKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<List<Stavka_sas>> getSSpoSa(@PathVariable Integer id) {
        List<Stavka_sas> stavka_sas = stavka_sasService.findAll();
        List<Stavka_sas> noveSsas = new ArrayList<Stavka_sas>();
        if(stavka_sas != null)
        {
            for(Stavka_sas ss : stavka_sas){
                if(ss.getStavka_sasKey().getsId() == id){
                    noveSsas.add(ss);

                }
            }
            return new ResponseEntity<>(noveSsas, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/{id}/{id1}/ssasstanje" ,consumes = "application/json")
    public ResponseEntity<Void> saveRnSas(@RequestBody SsasStanjeDTO ssasStanjeDTO, @PathVariable Integer id,@PathVariable Integer id1, HttpServletRequest httpServletRequest) {
        try {
            List<Stavka_sas> stavka_sass = stavka_sasService.findAll();
            List<Stanje> stanjes = stanjeService.findAll();

            if( stavka_sass != null){
                for(Stavka_sas s : stavka_sass){
                    if(s.getStavka_sasKey().getsId() == id && s.getStavka_sasKey().getSsId() == id1){
                        for( Stanje st : stanjes){
                            if(st.getStanjeKey().getmId() == ssasStanjeDTO.getmId() && st.getStanjeKey().getMatId() == ssasStanjeDTO.getMatId()){
                                s.getStanjeSet().add(st);
                                stavka_sasService.save(s);
                                return new ResponseEntity<>(HttpStatus.CREATED);
                            }
                        }
                    }
                }
            }

            System.out.println("Poslednji return");
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
