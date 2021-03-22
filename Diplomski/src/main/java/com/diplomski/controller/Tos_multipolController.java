package com.diplomski.controller;

import com.diplomski.dto.StanjeDTO;
import com.diplomski.dto.Tos_multipolDTO;
import com.diplomski.model.*;
import com.diplomski.service.MultipolService;
import com.diplomski.service.Tip_osService;
import com.diplomski.service.Tos_multipolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/tos_multipol")
public class Tos_multipolController {
    @Autowired
    private Tos_multipolService tos_multipolService;

    @Autowired
    private Tip_osService tip_osService;

    @Autowired
    private MultipolService multipolService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> tos_multipolSave(@RequestBody Tos_multipolDTO tos_multipolDTO, HttpServletRequest httpServletRequest) {
        try {
            Tos_multipol tos_multipol = new Tos_multipol();
            Tos_multipolKey tos_multipolKey = new Tos_multipolKey(tos_multipolDTO.getMuId(),tos_multipolDTO.getTosId());
            tos_multipol.setTos_multipolKey(tos_multipolKey);


            Optional<Multipol> multipol = multipolService.findById(tos_multipolDTO.getMuId());
            if(multipol.isPresent() ) {
                multipol.ifPresent(multipol1 -> {
                    tos_multipol.setMuId(multipol1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Tip_os> tip_os = tip_osService.findById(tos_multipolDTO.getTosId());
            if(tip_os.isPresent() ) {
                tip_os.ifPresent(tip_os1 -> {
                    tos_multipol.setTosId(tip_os1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            tos_multipolService.save(tos_multipol);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Tos_multipol>> getTos_multipols() {
        List<Tos_multipol> tos_multipols = tos_multipolService.findAll();
        if(tos_multipols != null)
        {
            return new ResponseEntity<>(tos_multipols, HttpStatus.OK);
        }
        return new ResponseEntity<>(tos_multipols, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteTos_multipol(@PathVariable Integer id,@PathVariable Integer id1 ) {
        Tos_multipolKey tos_multipolKey = new Tos_multipolKey(id,id1);
        tos_multipolService.remove(tos_multipolKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
