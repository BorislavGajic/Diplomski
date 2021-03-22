package com.diplomski.controller;

import com.diplomski.dto.Tip_osDTO;
import com.diplomski.model.Tip_os;
import com.diplomski.service.Tip_osService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/tip_os")
public class Tip_osController {
    @Autowired
    private Tip_osService tip_osService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTip_os(@RequestBody Tip_osDTO tip_osDTO, HttpServletRequest httpServletRequest) {
        try {
            Tip_os tip_os = new Tip_os();
            tip_os.setBrPolova(tip_osDTO.getBrPolova());
            tip_os.setNazTos(tip_osDTO.getNazTos());

            tip_osService.save(tip_os);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Tip_os>> getTip_os() {
        List<Tip_os> tip_oss = tip_osService.findAll();
        if(tip_oss != null)
        {
            return new ResponseEntity<>(tip_oss, HttpStatus.OK);
        }
        return new ResponseEntity<>(tip_oss, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTip_os(@PathVariable Integer id) {
        tip_osService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
