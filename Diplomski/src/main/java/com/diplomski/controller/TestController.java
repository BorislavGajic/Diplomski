package com.diplomski.controller;

import com.diplomski.dto.KontrolaDTO;
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
    private Test_linijaService test_linijaService;

    @Autowired
    private Tip_osService tip_osService;

    @Autowired
    private ReparacijaService reparacijaService;

    @Autowired
    private OsiguracService osiguracService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTest(@RequestBody TestDTO testDTO, HttpServletRequest httpServletRequest) {
        try {
            Test test = new Test();
            TestKey testKey = new TestKey(testDTO.getTlId(),testDTO.getTosId());
            test.setTestKey(testKey);
            test.setNazTest(testDTO.getNazTest());

            Optional<Test_linija> test_linija = test_linijaService.findById(testDTO.getTlId());
            if(test_linija.isPresent() ) {
                test_linija.ifPresent(test_linija1 -> {
                    test.setTlId(test_linija1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
            Optional<Tip_os> tip_os = tip_osService.findById(testDTO.getTosId());
            if(tip_os.isPresent() ) {
                tip_os.ifPresent(tip_os1 -> {
                    test.setTosId(tip_os1);
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

    @DeleteMapping(value = "/{id}/{id1}")
    public ResponseEntity<Void> deleteTest(@PathVariable Integer id,@PathVariable Integer id1 ) {
        TestKey testKey = new TestKey(id,id1);
        Optional<Test> test = testService.findById(testKey);
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
        testService.remove(testKey);
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
                    if (test.getTestKey().getTlId() == testDTO.getTlId() && test.getTestKey().getTosId() == testDTO.getTosId()) {
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
