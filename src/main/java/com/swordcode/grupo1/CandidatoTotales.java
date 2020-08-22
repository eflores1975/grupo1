package com.swordcode.grupo1;

import java.math.BigDecimal;

public class CandidatoTotales {
    private String candidato;
    private int total;
    private BigDecimal pct;

    public CandidatoTotales() {
    }

    public CandidatoTotales(String candidato, int total, BigDecimal pct) {
		this.candidato = candidato;
		this.total = total;
		this.pct = pct;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public BigDecimal getPct() {
		return pct;
	}
	public void setPct(BigDecimal pct) {
		this.pct = pct;
    }
}