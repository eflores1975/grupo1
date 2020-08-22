package com.swordcode.grupo1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CandidatoDistrito implements Serializable {
    private int  distrito;
    private List<Candidato> candidatos;

    public CandidatoDistrito() {
	}

	public CandidatoDistrito(int distrito, List<Candidato> candidatos) {
		this.distrito = distrito;
		this.candidatos = candidatos;
	}

	public int getDistrito() {
		return distrito;
	}

	public void setDistrito(int distrito) {
		this.distrito = distrito;
	}

	public List<Candidato> getCandidatos() {
        if (candidatos == null) candidatos = new ArrayList<>();
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

    public void add(Candidato candidato) {
        getCandidatos().add(candidato);
    }

    public int size() {
        return  getCandidatos().size();
	}	
}