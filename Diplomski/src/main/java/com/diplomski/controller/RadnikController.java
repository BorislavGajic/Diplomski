package com.diplomski.controller;



import com.diplomski.model.Radnik;
import com.diplomski.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/radnik")
public class RadnikController {

    @Autowired
    private RadnikService radnikService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Radnik>> getRadniks() {
        List<Radnik> radniks = radnikService.findAll();
        if(radniks != null)
        {
            return new ResponseEntity<>(radniks, HttpStatus.OK);
        }
        return new ResponseEntity<>(radniks, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRadnik(@PathVariable Integer id) {
        radnikService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

}
