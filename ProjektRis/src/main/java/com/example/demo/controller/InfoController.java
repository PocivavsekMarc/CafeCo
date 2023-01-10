package com.example.demo.controller;

import com.example.demo.dao.NagradaRepository;
import com.example.demo.model.Nagrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    NagradaRepository dao;

    @GetMapping("/info")
    public String infoMsg() {
        dao.save(new Nagrada("avto", 5000));
        return "Dodana je bila nova nagrada.";
    }

}
