package com.example.demo.service;

import com.example.demo.model.RegistriranUporabnik;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegistriranUporabnikService {

    //Create
    RegistriranUporabnik saveRegistriranUporabnik(RegistriranUporabnik registriranUporabnik);

    //Read
    List<RegistriranUporabnik> fetchRegistriranUporabnikList();

    //Update
    RegistriranUporabnik updateRegistriranUporabnik(RegistriranUporabnik uporabnik, int id);

    //delete
    void deleteRegistriranUporabnikById(int id);

    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik1(String phoneByCountry, String emailByGmail);
    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik2(int imeLength, int passwordLength);

}
