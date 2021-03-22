package com.diplomski.controller;

import com.diplomski.dto.Sektor_pogonaDTO;
import com.diplomski.model.Montaza;
import com.diplomski.model.Pogon;
import com.diplomski.model.Print_centar;
import com.diplomski.service.PogonService;
import com.diplomski.service.Print_centarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/print_centar")
public class Print_centarController {
    @Autowired
    private Print_centarService print_centarService;
    @Autowired
    private PogonService pogonService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> savePrint_centar(@RequestBody Sektor_pogonaDTO sektor_pogonaDTO, HttpServletRequest httpServletRequest) {
        try {
            Print_centar print_centar = new Print_centar();
            print_centar.setKolMasinaSp(sektor_pogonaDTO.getKolMasinaSp());
            print_centar.setMaxKolZap(sektor_pogonaDTO.getMaxKolZap());
            print_centar.setNazivSp(sektor_pogonaDTO.getNazivSp());
            print_centar.setPovrsina(sektor_pogonaDTO.getPovrsina());

            Optional<Pogon> pogon = pogonService.findById(sektor_pogonaDTO.getPogonPId());
            if(pogon.isPresent() ) {
                pogon.ifPresent(pogon1 -> {
                    print_centar.setPogonPId(pogon1);
                });
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }

            print_centarService.save(print_centar);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Print_centar>> getPrint_centars() {
        List<Print_centar> print_centars = print_centarService.findAllByTipSp("Print_centar");
        if(print_centars != null)
        {
            return new ResponseEntity<>(print_centars, HttpStatus.OK);
        }
        return new ResponseEntity<>(print_centars, HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePrint_centar(@PathVariable Integer id) {
        print_centarService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
