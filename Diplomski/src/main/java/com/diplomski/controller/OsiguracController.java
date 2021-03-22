package com.diplomski.controller;

import com.diplomski.dto.OsiguracDTO;
import com.diplomski.model.*;
import com.diplomski.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/osigurac")
public class OsiguracController {
    @Autowired
    private OsiguracService osiguracService;

    @Autowired
    private RivetService rivetService;

    @Autowired
    private MontazaService montazaService;

    @Autowired
    private PakerajService pakerajService;

    @Autowired
    private Print_centarService print_centarService;

    @Autowired
    private Tip_osService tip_osService;

    @Autowired
    private Tos_multipolService tos_multipolService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveOsigurac(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            Osigurac osigurac = new Osigurac();

            osigurac.setMaxNapon(osiguracDTO.getMaxNapon());
            osigurac.setSnaga(osiguracDTO.getSnaga());

            osiguracService.save(osigurac);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Osigurac>> getOsiguracs() {
        List<Osigurac> osiguracs = osiguracService.findAll();
        if(osiguracs != null)
        {
            return new ResponseEntity<>(osiguracs, HttpStatus.OK);
        }
        return new ResponseEntity<>(osiguracs, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOsigurac(@PathVariable Integer id) {
        osiguracService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @PutMapping(value = "/rivet" ,consumes = "application/json")
    public ResponseEntity<Void> putOsRi(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Rivet> rivets = rivetService.findAllByTipSp("Rivet");
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Rivet rivet : rivets){
                            if (rivet.getSpId() == osiguracDTO.getRiId()) {
                                osigurac.setRiId(rivet);
                                osiguracService.save(osigurac);
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

    @PutMapping(value = "/montaza" ,consumes = "application/json")
    public ResponseEntity<Void> putOsMo(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Montaza> montazas = montazaService.findAllByTipSp("Montaza");
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Montaza montaza : montazas){
                            if (montaza.getSpId() == osiguracDTO.getMoId()) {
                                osigurac.setMoId(montaza);
                                osiguracService.save(osigurac);
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

    @PutMapping(value = "/pakeraj" ,consumes = "application/json")
    public ResponseEntity<Void> putOsPa(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Pakeraj> pakerajs = pakerajService.findAllByTipSp("Pakeraj");
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Pakeraj pakeraj : pakerajs){
                            if (pakeraj.getSpId() == osiguracDTO.getPaId()) {
                                osigurac.setPaId(pakeraj);
                                osiguracService.save(osigurac);
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

    @PutMapping(value = "/print_centar" ,consumes = "application/json")
    public ResponseEntity<Void> putOsPc(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Print_centar> print_centars = print_centarService.findAllByTipSp("Print_centar");
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Print_centar print_centar : print_centars){
                            if (print_centar.getSpId() == osiguracDTO.getPcId()) {
                                osigurac.setPcId(print_centar);
                                osiguracService.save(osigurac);
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

    @PutMapping(value = "/tos" ,consumes = "application/json")
    public ResponseEntity<Void> putOsTos(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Tip_os> tip_oss = tip_osService.findAll();
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Tip_os tip_os : tip_oss){
                            if (tip_os.getTosId() == osiguracDTO.getTosId()) {
                                osigurac.setTosId(tip_os);
                                osiguracService.save(osigurac);
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

    @PutMapping(value = "/tos_multipol" ,consumes = "application/json")
    public ResponseEntity<Void> putOsTosMultipol(@RequestBody OsiguracDTO osiguracDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Osigurac> osiguracs = osiguracService.findAll();
            List<Tos_multipol> tos_multipols = tos_multipolService.findAll();
            // dodavanje ako je ispravno uneto
            if(osiguracs != null) {
                for (Osigurac osigurac : osiguracs) {
                    if (osigurac.getOsId()== osiguracDTO.getOsId()) {
                        for( Tos_multipol tos_multipol : tos_multipols){
                            if (tos_multipol.getTos_multipolKey().getTosId() == osiguracDTO.getTosId() && tos_multipol.getTos_multipolKey().getMuId() == osiguracDTO.getMuId()) {
                                osigurac.setTosMultipolId(tos_multipol);
                                osiguracService.save(osigurac);
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
