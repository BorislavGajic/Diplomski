package com.diplomski.controller;

import com.diplomski.dto.AdminDTO;
import com.diplomski.model.Admin;
import com.diplomski.model.Kancelarija;
import com.diplomski.model.Korisnik;
import com.diplomski.service.AdminService;
import com.diplomski.service.KancelarijaService;
import com.diplomski.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private KancelarijaService kancelarijaService;

    @Autowired
    private KorisnikService korisnikService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Integer> saveAdmin(@RequestBody AdminDTO adminDTO, HttpServletRequest httpServletRequest) {
        try {
            Admin admin = new Admin();
            if(adminDTO.getIme().equals("") || adminDTO.getPrezime().equals("") || adminDTO.getTekuciRacun().equals("") || adminDTO.getJmbg().equals(""))
            {
                return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
            }
            admin.setBonus(adminDTO.getBonus());
            admin.setIme(adminDTO.getIme());
            admin.setPrezime(adminDTO.getPrezime());
            admin.setPlata(adminDTO.getPlata());
            admin.setTekuciRacun(adminDTO.getTekuciRacun());
            admin.setJmbg(adminDTO.getJmbg());

            Optional<Kancelarija> kancelarija = kancelarijaService.findById(adminDTO.getKancelarija_Ka_id());
            if(kancelarija.isPresent() ) {
                kancelarija.ifPresent(kancelarija1 -> {
                    admin.setKancelarijaKaId(kancelarija1);
                });
            }
            else{
                return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
            }
            adminService.save(admin);
            return new ResponseEntity<>(admin.getrId(), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(0,HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> admins = adminService.findAllByRadnikTip("Admin");
        if(admins != null)
        {
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }
        return new ResponseEntity<>(admins, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) {
        adminService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
