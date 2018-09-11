package com.mkl.vo;

public class VOCalculadora {
	
	private int nro1;
	private int nro2;
	private String operacion;
	private int resultado;
	
	public void setNro1(int nro1) {
		this.nro1 = nro1;
	}
	public void setNro2(int nro2) {
		this.nro2 = nro2;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	public int getResultado()
	{
		switch(this.operacion)
		{
		case "Suma":
			this.resultado = this.nro1 + this.nro2;
			break;
		case "Resta":
			this.resultado = this.nro1 - this.nro2;
			break;
		case "Multiplicacion":
			this.resultado = this.nro1 * this.nro2;
			break;
		case "Division":
			this.resultado = this.nro1 / this.nro2;
			break;
		}
		return resultado;
	}
}
