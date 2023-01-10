package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public abstract class Uporabnik {
	public String uporabnisko_ime;
	public String password;
	public String email;
	public String phoneNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roles = new ArrayList<>();

	public Uporabnik(String uporabnisko_ime, String password, String email, String phoneNumber) {
		this.uporabnisko_ime = uporabnisko_ime;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Uporabnik() {

	}

	public String getUporabnisko_ime() {
		return uporabnisko_ime;
	}

	public void setUporabnisko_ime(String uporabnisko_ime) {
		this.uporabnisko_ime = uporabnisko_ime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setId(int id) {
		this.id = id;
	}
}