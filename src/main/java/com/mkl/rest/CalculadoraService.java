package com.mkl.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mkl.vo.VOCalculadora;

@Path("/mkl")
public class CalculadoraService {
	
	private Response resp = new Response();
	private int resultado;
	
	@POST
	@Path("/calcular")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public CalculadoraService realizarCalculo(VOCalculadora calc) {
		CalculadoraService sc = new CalculadoraService();
		try {
			sc.resp.setCodRta(0);
			sc.resp.setDescRta("OK");
			sc.resultado = calc.getResultado();
			return sc;
		} catch (Exception e) {
			sc.resp.setCodRta(200);
			sc.resp.setDescRta(e.getMessage());
			sc.resultado = 0;
			return sc;
		}
	}


	public Response getResp() {
		return resp;
	}

	public void setResp(Response resp) {
		this.resp = resp;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}
