package com.swordcode.grupo1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.jdbc.DataSourceSchemaCreatedEvent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class Temperature implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long                id;
    private BigDecimal          celsius;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date                dateMeasured;

    public Temperature() {
    }

	public Temperature(BigDecimal celsius, Date dateMeasured) {
		this.celsius = celsius;
		this.dateMeasured = dateMeasured;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCelsius() {
		return celsius;
	}

	public void setCelsius(BigDecimal celsius) {
		this.celsius = celsius;
	}

	public Date getDateMeasured() {
		return dateMeasured;
	}

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	public void setDateMeasured(Date dateMeasured) {
		this.dateMeasured = dateMeasured;
	}

}