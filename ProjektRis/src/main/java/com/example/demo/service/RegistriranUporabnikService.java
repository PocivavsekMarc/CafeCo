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

    //pogleda ce je telefonska st. iz podane drzave in mail da je gmail.
    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik1(String phoneByCountry, String emailService);

    //ce je dolzina imena in passworda nad podano
    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik2(int imeLength, int passwordLength);

    //pogleda ce je telefonska st. iz podane drzave, mail da je gmail in ce je ima vec bonus tock kot podano.
    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik3(String phoneByCountry, String emailService, int stBonusTock);

    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik4(int imeLength, int passwordLength, int emailLength);
//
//    List<RegistriranUporabnik> fetchSpecificRegistriranUporabnik5(int imeLength, int passwordLength);

}
