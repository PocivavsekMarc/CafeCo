package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegistriranUporabnik extends Uporabnik {

	private int bonusTocke;

	public RegistriranUporabnik(String uporabnisko_ime, String password, String email, String phoneNumber, int bonusTocke) {
		super(uporabnisko_ime, password, email, phoneNumber);
		this.bonusTocke = bonusTocke;
	}

	public RegistriranUporabnik() {
		super();
	}


	public void oddajOceno(int ocena) {
		throw new UnsupportedOperationException();
	}

	public void prikaziDailyFeed() {
		throw new UnsupportedOperationException();
	}

	public void dodajBonusTocke() {
		throw new UnsupportedOperationException();
	}

	public int getBonusTocke() {
		return bonusTocke;
	}

	public void setBonusTocke(int bonusTocke) {
		this.bonusTocke = bonusTocke;
	}

	public void prevzemNagrad(Nagrada izbranaNagrada) {
		throw new UnsupportedOperationException();
	}
}