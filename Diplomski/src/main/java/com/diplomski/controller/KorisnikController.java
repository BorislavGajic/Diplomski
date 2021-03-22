package com.diplomski.controller;

import com.diplomski.dto.AdminDTO;
import com.diplomski.dto.KorisnikDTO;
import com.diplomski.model.Admin;
import com.diplomski.model.Kancelarija;
import com.diplomski.model.Korisnik;
import com.diplomski.model.Radnik;
import com.diplomski.service.KorisnikService;
import com.diplomski.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private RadnikService radnikService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveKorisnik(@RequestBody KorisnikDTO korisnikDTO, HttpServletRequest httpServletRequest) {
        try {
            Korisnik korisnik = new Korisnik();
            List<Korisnik> korisniks = korisnikService.findAll();
            if(korisniks!= null){
                for(Korisnik k : korisniks){
                    if(k.getKorisnickoIme().equals(korisnikDTO.getKorisnickoIme()) || k.getKorisnickoIme().equals("") || k.getLozinka().equals("")){
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }
            }
            korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
            korisnik.setLozinka(korisnikDTO.getLozinka());
            korisnik.setAktivan(Boolean.TRUE);

            Optional<Radnik> radnik = radnikService.findById(korisnikDTO.getRadnikRId());
            if(radnik.isPresent() ) {
                radnik.ifPresent(radnik1 -> {
                    korisnik.setRadnikRId(radnik1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            korisnikService.save(korisnik);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Korisnik>> getKorsniks() {
        List<Korisnik> korisniks = korisnikService.findAll();
        if(korisniks != null)
        {
            return new ResponseEntity<>(korisniks, HttpStatus.OK);
        }
        return new ResponseEntity<>(korisniks, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Integer id) {
        korisnikService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @PostMapping(value = "/login",produces = "application/json")
    public ResponseEntity<Korisnik> getKorisnik(@RequestBody KorisnikDTO korisnikDTO) {
        List<Korisnik> korisniks = korisnikService.findAll();
        if(korisniks != null)
        {
            for(Korisnik korisnik : korisniks){
                if(korisnik.getKorisnickoIme().equals(korisnikDTO.getKorisnickoIme()) && korisnik.getLozinka().equals(korisnikDTO.getLozinka()))
                    return new ResponseEntity<>(korisnik, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<Korisnik> getKorisnik(@PathVariable String username) {
        List<Korisnik> korisniks = korisnikService.findAll();
        if(korisniks != null)
        {
            for(Korisnik k : korisniks){
                if(k.getKorisnickoIme().equals(username)){
                    return new ResponseEntity<>(k, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }
}
