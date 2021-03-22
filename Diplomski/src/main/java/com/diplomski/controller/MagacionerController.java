package com.diplomski.controller;

import com.diplomski.dto.MagacionerDTO;
import com.diplomski.model.Magacin;
import com.diplomski.model.Magacioner;
import com.diplomski.service.MagacinService;
import com.diplomski.service.MagacionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/magacioner")
public class MagacionerController {
    @Autowired
    private MagacionerService magacionerService;

    @Autowired
    private MagacinService magacinService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Integer> saveMagacioner(@RequestBody MagacionerDTO magacionerDTO, HttpServletRequest httpServletRequest) {
        try {
            Magacioner magacioner = new Magacioner();

            if(magacionerDTO.getIme().equals("") || magacionerDTO.getPrezime().equals("") || magacionerDTO.getTekuciRacun().equals("") || magacionerDTO.getJmbg().equals(""))
            {
                return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
            }

            magacioner.setBonus(magacionerDTO.getBonus());
            magacioner.setIme(magacionerDTO.getIme());
            magacioner.setPrezime(magacionerDTO.getPrezime());
            magacioner.setPlata(magacionerDTO.getPlata());
            magacioner.setTekuciRacun(magacionerDTO.getTekuciRacun());
            magacioner.setJmbg(magacionerDTO.getJmbg());

            Optional<Magacin> magacin = magacinService.findById(magacionerDTO.getMagacinMId());
            if(magacin.isPresent() ) {
                magacin.ifPresent(magacin1 -> {
                    magacioner.setMagacinMId(magacin1);
                });
            }
            else{
                return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
            }
            magacionerService.save(magacioner);
            return new ResponseEntity<>(magacioner.getrId(), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(0, HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Magacioner>> getMagacioners() {
        List<Magacioner> magacioners = magacionerService.findAllByRadnikTip("Magacioner");
        if(magacioners != null)
        {
            return new ResponseEntity<>(magacioners, HttpStatus.OK);
        }
        return new ResponseEntity<>(magacioners, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMagacioner(@PathVariable Integer id) {
        magacionerService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
