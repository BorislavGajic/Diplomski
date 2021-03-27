package com.diplomski.controller;

import com.diplomski.dto.TipTestDTO;
import com.diplomski.model.*;
import com.diplomski.service.Test_linijaService;
import com.diplomski.service.TipTestService;
import com.diplomski.service.Tip_osService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/tip_test")
public class Tip_testController {

    @Autowired
    private TipTestService tipTestService;

    @Autowired
    private Test_linijaService test_linijaService;

    @Autowired
    private Tip_osService tip_osService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTipTest(@RequestBody TipTestDTO tipTestDTO, HttpServletRequest httpServletRequest) {
        try {
            Tip_test tip_test = new Tip_test();
            TipTestKey tipTestKey = new TipTestKey(tipTestDTO.getTlId(),tipTestDTO.getTosId());
            tip_test.setTipTestKey(tipTestKey);

            Optional<Test_linija> test_linija = test_linijaService.findById(tipTestDTO.getTlId());
            if(test_linija.isPresent() ) {
                test_linija.ifPresent(test_linija1 -> {
                    tip_test.setTlId(test_linija1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Tip_os> tip_os = tip_osService.findById(tipTestDTO.getTosId());
            if(tip_os.isPresent() ) {
                tip_os.ifPresent(tip_os1 -> {
                    tip_test.setTosId(tip_os1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            this.tipTestService.save(tip_test);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Tip_test>> getTipTests() {
        List<Tip_test> tip_tests = tipTestService.findAll();
        if(tip_tests != null)
        {
            return new ResponseEntity<>(tip_tests, HttpStatus.OK);
        }
        return new ResponseEntity<>(tip_tests, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteTipTest(@PathVariable Integer id,@PathVariable Integer id1 ) {
        TipTestKey tipTestKey = new TipTestKey(id,id1);
        tipTestService.remove(tipTestKey);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
