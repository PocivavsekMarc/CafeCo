package com.example.demo.controller;

import com.example.demo.model.RegistriranUporabnik;
import com.example.demo.service.RegistriranUporabnikService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UporabnikController {

    @Autowired
    private RegistriranUporabnikService registriranUporabnikService;

    @PostMapping("/r_uporabniki")
    public RegistriranUporabnik saveRegistriranUporabnik(@RequestBody RegistriranUporabnik registriranUporabnik) {
        return registriranUporabnikService.saveRegistriranUporabnik(registriranUporabnik);
    }

    @GetMapping("/r_uporabniki")
    public List<RegistriranUporabnik> fetchRegistriraniUporabniki() {
        return registriranUporabnikService.fetchRegistriranUporabnikList();
    }

    @PutMapping("/r_uporabniki/{id}")
    public RegistriranUporabnik updateRegistriranUporabnik (@RequestBody RegistriranUporabnik registriranUporabnik, @PathVariable("id") int id) {
        return registriranUporabnikService.updateRegistriranUporabnik(registriranUporabnik, id);
    }

    @DeleteMapping("r_uporabniki/{id}")
    public String deleteRegistriranUporabnikById(@PathVariable("id") int id) {
        registriranUporabnikService.deleteRegistriranUporabnikById(id);
        return "Deleted Sucessfully.";
    }
}
