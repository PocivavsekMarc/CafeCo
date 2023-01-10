package com.example.demo.dao;

import com.example.demo.model.RegistriranUporabnik;
import org.springframework.data.repository.CrudRepository;

public interface RegistriranUporabnikRepository extends CrudRepository<RegistriranUporabnik, Integer> {

    RegistriranUporabnik findByEmail(String email);

}
