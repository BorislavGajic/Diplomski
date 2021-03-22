package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Montaza;
import com.diplomski.model.Pogon;
import com.diplomski.model.Sektor_pogona;
import com.diplomski.model.Test_linija;
import com.diplomski.service.PogonService;
import com.diplomski.service.SektorPogonaService;
import com.diplomski.service.Test_linijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/test_linija")
public class Test_linijaController {
    @Autowired
    private Test_linijaService test_linijaService;

    @Autowired
    private PogonService pogonService;

    @Autowired
    private SektorPogonaService sektorPogonaService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveTest_linija(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Test_linija test_linija = new Test_linija();
            test_linija.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            test_linija.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            test_linija.setNazivSp(sektor_pogonaDTO.getNazivSp());
            test_linija.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    test_linija.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            test_linijaService.save(test_linija);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Test_linija>> getTest_linija() {
        List<Test_linija> test_linijas = test_linijaService.findAllByTipSp("Test_linija");
        if(test_linijas != null)
        {
            return new ResponseEntity<>(test_linijas, HttpStatus.OK);
        }
        return new ResponseEntity<>(test_linijas, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTest_linija(@PathVariable Integer id) {
        test_linijaService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
