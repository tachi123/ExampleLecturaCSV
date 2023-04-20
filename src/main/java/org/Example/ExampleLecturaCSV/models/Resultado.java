package org.Example.ExampleLecturaCSV.models;

import org.Example.ExampleLecturaCSV.EnumResultado;

import com.opencsv.bean.CsvBindByPosition;

public class Resultado {
	
	@CsvBindByPosition(position = 0)
	private Integer ronda;

	@CsvBindByPosition(position = 1)
	private String equipo1;
	
	@CsvBindByPosition(position = 2)
	private Integer cantGoles1;
	
	@CsvBindByPosition(position = 3)
	private Integer cantGoles2;
	
	@CsvBindByPosition(position = 4)
	private String equipo2;

	public Integer getRonda() {
		return ronda;
	}

	public void setRonda(Integer ronda) {
		this.ronda = ronda;
	}
	
	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public Integer getCantGoles1() {
		return cantGoles1;
	}

	public void setCantGoles1(Integer cantGoles1) {
		this.cantGoles1 = cantGoles1;
	}

	public Integer getCantGoles2() {
		return cantGoles2;
	}

	public void setCantGoles2(Integer cantGoles2) {
		this.cantGoles2 = cantGoles2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}
	
	
	public EnumResultado ganoEmpatoOPerdioElEquipo1() {
		
		if(this.cantGoles1> this.cantGoles2)
			return EnumResultado.GANADOR;
		
		if(this.cantGoles1< this.cantGoles2)
			return EnumResultado.PERDEDOR;
		
		return EnumResultado.EMPATE;
	}
	
	
}
