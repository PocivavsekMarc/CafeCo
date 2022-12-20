package com.example.demo.controller;


import com.example.demo.dao.NagradaRepository;
import com.example.demo.dao.RegistriranUporabnikRepository;
import com.example.demo.model.Nagrada;
import com.example.demo.model.RegistriranUporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/nagrade")
public class NagradeController {

    private static final Logger log = Logger.getLogger(NagradeController.class.toString());

    @Autowired
    NagradaRepository dao;

    @Autowired
    RegistriranUporabnikRepository daoRUporabnik;

    @GetMapping("/{id}")
    public Nagrada getNagrada(@PathVariable int id) {
        log.info("GET nagrade z id: " + id);
        return dao.findById(id).get();
    }
    @PostMapping
    public Nagrada novaNagrada(@RequestBody Nagrada nagrada) {
        log.info("Dodajanje nove nagrade " + nagrada);
        return dao.save(nagrada);
    }

    @GetMapping
    public Iterable<Nagrada> getVseNagrade() {
        return dao.findAll();
    }

    @GetMapping("/1/{stBonusTock}/{dolzinaImena}")
    public List<Nagrada> getSpecificNagrade(@PathVariable("stBonusTock") int stBonusTock, @PathVariable("dolzinaImena") int dolzinaImena) {
        List<Nagrada> vseNagrade = (List<Nagrada>) dao.findAll();
        List<Nagrada> KriterijList = new ArrayList<>();
        for (Nagrada nagrada : vseNagrade) {
            if (nagrada.getSteviloBonusTock() > stBonusTock && nagrada.getIme().length() > dolzinaImena) {
                KriterijList.add(nagrada);
            }
        }
        return KriterijList;
    }

    /*
    po imenu nagrade (lahko mas vec monitorjev ki razlicno stanejo)
    po st bonus tock - da je nad
    ce ima kateri uporabnik dovol tock, potem se doda v list
    */
    @GetMapping("/2/{ime}/{stBonusTock}")
    public List<Nagrada> getSpecificNagrade2(@PathVariable("ime") String ime, @PathVariable("stBonusTock") int stBonusTock) {
        List<Nagrada> filteredNagrade = new ArrayList<>();

        int mostPoints = 0;

        for (RegistriranUporabnik registriranUporabnik : daoRUporabnik.findAll()) {

            if (registriranUporabnik.getBonusTocke() > mostPoints) {
                mostPoints = registriranUporabnik.getBonusTocke();
            }
        }

        for (Nagrada nagrada : dao.findAll()) {
            if (ime.equals(nagrada.getIme()) && nagrada.getSteviloBonusTock() >= stBonusTock && nagrada.getSteviloBonusTock() <= mostPoints) {
                filteredNagrade.add(nagrada);
            }
        }
        return filteredNagrade;
    }

    @PutMapping("{id}")
    public ResponseEntity<Nagrada> updateNagrada(@PathVariable int id, @RequestBody Nagrada nagrada) throws Exception {
        Nagrada updateNagrada = dao.findById(id)
                .orElseThrow(() -> new Exception("Employee doesnt exist"));

        updateNagrada.setIme(nagrada.getIme());
        updateNagrada.setSteviloBonusTock(nagrada.getSteviloBonusTock());

        dao.save(updateNagrada);

        return ResponseEntity.ok(updateNagrada);

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteNagrada(@PathVariable int id) throws Exception {
        Nagrada deleteNagrada = dao.findById(id)
                .orElseThrow(() -> new Exception("Employee doesnt exist"));

        dao.delete(deleteNagrada);

        return ResponseEntity.ok().build();
    }

}
