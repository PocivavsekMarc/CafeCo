package com.example.demo.controller;

import com.example.demo.model.RegistriranUporabnik;
import com.example.demo.service.RegistriranUporabnikService;
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

    @GetMapping("/r_uporabniki/1/{phoneByCountry}/{emailService}")
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik1(
            @PathVariable("phoneByCountry") String phoneByCountry, @PathVariable("emailService") String emailService) {
        return registriranUporabnikService.fetchSpecificRegistriranUporabnik1(phoneByCountry, emailService);
    }

    @GetMapping("/r_uporabniki/2/{imeLength}/{passwordLength}")
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik2(
            @PathVariable("imeLength") int imeLength, @PathVariable("passwordLength") int passwordLength) {
        return registriranUporabnikService.fetchSpecificRegistriranUporabnik2(imeLength, passwordLength);
    }

    @GetMapping("/r_uporabniki/3/{phoneByCountry}/{emailService}/{stBonusTock}")
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik1(
            @PathVariable("phoneByCountry") String phoneByCountry, @PathVariable("emailService") String emailService, @PathVariable("stBonusTock") int stBonusTock) {
        return registriranUporabnikService.fetchSpecificRegistriranUporabnik3(phoneByCountry, emailService, stBonusTock);
    }

    @GetMapping("/r_uporabniki/4/{imeLength}/{passwordLength}/{emailLength}")
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik2(
            @PathVariable("imeLength") int imeLength, @PathVariable("passwordLength") int passwordLength, @PathVariable("emailLength") int emailLength) {
        return registriranUporabnikService.fetchSpecificRegistriranUporabnik4(imeLength, passwordLength, emailLength);
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
