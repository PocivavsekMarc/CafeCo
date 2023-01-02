package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nagrada {

	private String ime;
	private int steviloBonusTock;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public Nagrada(String ime, int steviloBonusTock) {
		this.ime = ime;
		this.steviloBonusTock = steviloBonusTock;
	}

	public Nagrada() {

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getSteviloBonusTock() {
		return steviloBonusTock;
	}

	public void setSteviloBonusTock(int steviloBonusTock) {
		this.steviloBonusTock = steviloBonusTock;
	}

	@Override
	public String toString() {
		return "Nagrada: " + ime + "  Stevilo Bonus Tock: " + steviloBonusTock;
	}
}