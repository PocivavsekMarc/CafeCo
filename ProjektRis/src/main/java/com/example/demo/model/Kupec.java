package com.example.demo.model;

public class Kupec extends Uporabnik {
	private String naslov;

	public Kupec(String uporabnisko_ime, String password, String email, String phoneNumber) {
		super(uporabnisko_ime, password, email, phoneNumber);
	}

	public void narociKavniCatering(int steviloOseb, String datum) {
		throw new UnsupportedOperationException();
	}

	public void narociloNaptikovNaDom(String[] izbraniNapitki) {
		throw new UnsupportedOperationException();
	}

	public void prikazMoznostiPlacila() {
		throw new UnsupportedOperationException();
	}
}