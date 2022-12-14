package com.example.demo.service;

import com.example.demo.dao.RegistriranUporabnikRepository;
import com.example.demo.model.RegistriranUporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegistriranUporabnikImpl implements RegistriranUporabnikService {

    @Autowired
    RegistriranUporabnikRepository dao;


    //Create
    @Override
    public RegistriranUporabnik saveRegistriranUporabnik(RegistriranUporabnik registriranUporabnik) {
        return (RegistriranUporabnik) dao.save(registriranUporabnik);
    }

    //Read
    @Override
    public List<RegistriranUporabnik> fetchRegistriranUporabnikList() {
        return (List<RegistriranUporabnik>) dao.findAll();
    }

    //Update
    @Override
    public RegistriranUporabnik updateRegistriranUporabnik(RegistriranUporabnik registriranUporabnik, int id) {
        RegistriranUporabnik registriranUporabnikToUpdate = (RegistriranUporabnik) dao.findById(id).get();

        if (Objects.nonNull(registriranUporabnik.getUporabnisko_ime()) && !"".equalsIgnoreCase(registriranUporabnik.getUporabnisko_ime())) {
            registriranUporabnikToUpdate.setUporabnisko_ime(registriranUporabnik.getUporabnisko_ime());
        }
        if (Objects.nonNull(registriranUporabnik.getPassword()) && !"".equalsIgnoreCase(registriranUporabnik.getPassword())) {
            registriranUporabnikToUpdate.setPassword(registriranUporabnik.getPassword());
        }
        if (Objects.nonNull(registriranUporabnik.getEmail()) && !"".equalsIgnoreCase(registriranUporabnik.getEmail())) {
            registriranUporabnikToUpdate.setEmail(registriranUporabnik.getEmail());
        }
        if (Objects.nonNull(registriranUporabnik.getPhoneNumber()) && !"".equalsIgnoreCase(registriranUporabnik.getPhoneNumber())) {
            registriranUporabnikToUpdate.setPhoneNumber(registriranUporabnik.getPhoneNumber());
        }
        if (registriranUporabnik.getBonusTocke() != (int)registriranUporabnik.getBonusTocke()) {
            registriranUporabnikToUpdate.setBonusTocke(registriranUporabnik.getBonusTocke());
        }


        return (RegistriranUporabnik) dao.save(registriranUporabnik);
    }

    //Delete
    @Override
    public void deleteRegistriranUporabnikById(int id) {
        dao.deleteById(id);
    }
}
