package com.example.demo.service;

import com.example.demo.dao.RegistriranUporabnikRepository;
import com.example.demo.model.RegistriranUporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik1(String phoneByCountry, String emailService) {
        String country = phoneByCountry.substring(0, 3);

        List<RegistriranUporabnik> filteredUporabnikList = new ArrayList<>();

        for (RegistriranUporabnik uporabnik : dao.findAll()) {
            String email = uporabnik.getEmail();
            //ce so prve 3 stevilke telefonske st. enake podani drzavi in ce je mail '@gmail.com' (9)
            String uporabnikEmailService = email.substring(email.length() - 10);
            if (uporabnik.getPhoneNumber().substring(0, 3).equals(country) && uporabnik.getEmail().substring(email.length() - 10).equals(emailService)) {
                filteredUporabnikList.add(uporabnik);
            }
        }

        return filteredUporabnikList;
    }

    @Override
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik2(int imeLength, int passwordLength) {

        List<RegistriranUporabnik> filteredUporabnikList = new ArrayList<>();

        for (RegistriranUporabnik uporabnik : dao.findAll()) {
            if (uporabnik.getUporabnisko_ime().length() >= imeLength && uporabnik.getPassword().length() >= passwordLength) {
                filteredUporabnikList.add(uporabnik);
            }
        }
        return filteredUporabnikList;
    }

    @Override
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik3(String phoneByCountry, String emailService, int stBonusTock) {
        String country = phoneByCountry.substring(0, 3);

        List<RegistriranUporabnik> filteredUporabnikList = new ArrayList<>();

        for (RegistriranUporabnik uporabnik : dao.findAll()) {
            String email = uporabnik.getEmail();
            //ce so prve 3 stevilke telefonske st. enake podani drzavi in ce je mail '@gmail.com' (9)
            String uporabnikEmailService = email.substring(email.length() - 10);
            if (uporabnik.getPhoneNumber().substring(0, 3).equals(country)
                    && uporabnik.getEmail().substring(email.length() - 10).equals(emailService)
                    && uporabnik.getBonusTocke() >= stBonusTock) {
                filteredUporabnikList.add(uporabnik);
            }
        }

        return filteredUporabnikList;
    }
    @Override
    public List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik4(int imeLength, int passwordLength, int emailLength) {
        List<RegistriranUporabnik> filteredUporabnikList = new ArrayList<>();

        for (RegistriranUporabnik uporabnik : dao.findAll()) {
            if (uporabnik.getUporabnisko_ime().length() >= imeLength && uporabnik.getPassword().length() >= passwordLength && uporabnik.getEmail().length() >= emailLength) {
                filteredUporabnikList.add(uporabnik);
            }
        }
        return filteredUporabnikList;
    }
}
