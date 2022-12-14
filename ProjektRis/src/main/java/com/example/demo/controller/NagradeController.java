package com.example.demo.controller;


import com.example.demo.dao.NagradaRepository;
import com.example.demo.model.Nagrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/nagrade")
public class NagradeController {

    private static final Logger log = Logger.getLogger(NagradeController.class.toString());

    @Autowired
    NagradaRepository dao;

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
