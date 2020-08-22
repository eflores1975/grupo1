package com.swordcode.grupo1;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Candidato implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long                id;
    private int                 distrito;
    private String              nombre;
    private int                 total;
	
	public Candidato() {
	}

	public Candidato(String nombre) {
		this.nombre = nombre;
	}

	public Candidato(int distrito, String nombre, int total) {
		this.distrito = distrito;
		this.nombre = nombre;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDistrito() {
		return distrito;
	}

	public void setDistrito(int distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}