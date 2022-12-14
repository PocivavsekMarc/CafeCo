package com.example.demo.controller;


import com.example.demo.dao.NagradaRepository;
import com.example.demo.model.Nagrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
