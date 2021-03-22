package com.diplomski.controller;

import com.diplomski.dto.AdminDTO;
import com.diplomski.dto.OperaterDTO;
import com.diplomski.model.Admin;
import com.diplomski.model.Kancelarija;
import com.diplomski.model.Operater;
import com.diplomski.model.Pogon;
import com.diplomski.service.OperaterService;
import com.diplomski.service.PogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/operater")
public class OperaterController {
    @Autowired
    private OperaterService operaterService;

    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Integer> saveOperater(@RequestBody OperaterDTO operaterDTO, HttpServletRequest httpServletRequest) {
        try {
            Operater operater = new Operater();

            if(operaterDTO.getIme().equals("") || operaterDTO.getPrezime().equals("") || operaterDTO.getTekuciRacun().equals("") || operaterDTO.getJmbg().equals(""))
            {
                return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
            }

            operater.setBonus(operaterDTO.getBonus());
            operater.setIme(operaterDTO.getIme());
            operater.setPrezime(operaterDTO.getPrezime());
            operater.setPlata(operaterDTO.getPlata());
            operater.setTekuciRacun(operaterDTO.getTekuciRacun());
            operater.setJmbg(operaterDTO.getJmbg());

            Optional<Pogon> pogon = pogonService.findById(operaterDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    operater.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(0,HttpStatus.NOT_MODIFIED);
            }
            operaterService.save(operater);
            return new ResponseEntity<>(operater.getrId(), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(0 , HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Operater>> getOperaters() {
        List<Operater> operaters = operaterService.findAllByRadnikTip("Operater");
        if(operaters != null)
        {
            return new ResponseEntity<>(operaters, HttpStatus.OK);
        }
        return new ResponseEntity<>(operaters, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOperater(@PathVariable Integer id) {
        operaterService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
