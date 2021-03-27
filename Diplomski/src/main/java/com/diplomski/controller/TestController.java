package com.diplomski.controller;

import com.diplomski.dto.TestDTO;
import com.diplomski.model.*;
import com.diplomski.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private ReparacijaService reparacijaService;

    @Autowired
    private OsiguracService osiguracService;

    @Autowired
    private TipTestService tipTestService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTest(@RequestBody TestDTO testDTO, HttpServletRequest httpServletRequest) {
        try {
            Test test = new Test();
            TipTestKey tipTestKey = new TipTestKey(testDTO.getTlId(),testDTO.getTosId());

            test.setNazTest(testDTO.getNazTest());

            Optional<Tip_test> tip_test = tipTestService.findById(tipTestKey);
            if(tip_test.isPresent() ) {
                tip_test.ifPresent(tip_test1 -> {
                    test.setTip_test(tip_test1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Osigurac> osigurac = osiguracService.findById(testDTO.getOsId());
            if(osigurac.isPresent() ) {
                osigurac.ifPresent(osigurac1 -> {
                    test.setOsigurac(osigurac1);
                    testService.save(test);
                    osigurac1.setTest(test);
                    osiguracService.save(osigurac1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Test>> getTests() {
        List<Test> tests = testService.findAll();
        if(tests != null)
        {
            return new ResponseEntity<>(tests, HttpStatus.OK);
        }
        return new ResponseEntity<>(tests, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Integer id ) {
        Optional<Test> test = testService.findById(id);
        if(test.isPresent() ) {
            test.ifPresent(test1 -> {
                Optional<Osigurac> osigurac = osiguracService.findById(test1.getOsigurac().getOsId());
                if(osigurac.isPresent() ) {
                    osigurac.ifPresent(osigurac1 -> {
                        osigurac1.setTest(null);
                    });
                }
            });
        }
        testService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @PutMapping(value = "/reparacija" ,consumes = "application/json")
    public ResponseEntity<Void> putTeRe(@RequestBody TestDTO testDTO, HttpServletRequest httpServletRequest) {
        try {
            List<Test> tests = testService.findAll();
            List<Reparacija> reparacijas = reparacijaService.findAllByTipSp("Reparacija");
            // dodavanje ako je ispravno uneto
            if(tests != null) {
                for (Test test : tests) {
                    if (test.getTestId() == testDTO.getTestId()) {
                        for( Reparacija reparacija : reparacijas){
                            if (reparacija.getSpId() == testDTO.getReId()) {
                                test.setReId(reparacija);
                                testService.save(test);
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
