package com.vortice.seguranca.abstracao.rn;

import java.io.InputStream;
import java.io.Serializable;

import com.vortice.abstracao.RegraNegocio;
import com.vortice.exception.AmbienteException;
import com.vortice.seguranca.abstracao.persistencia.FabricaDAOMsSql;
import com.vortice.seguranca.abstracao.persistencia.FabricaDAOPostgres;
import com.vortice.seguranca.abstracao.persistencia.FabricaDAOSegurancaIf;

public class SegurancaRegraNegocio extends RegraNegocio implements Serializable{
	
	private String tipoBanco;
	
	private FabricaDAOSegurancaIf dao;
	
	public SegurancaRegraNegocio() throws AmbienteException{
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("configuracao.xml");
		this.setIs(inputStream);
		tipoBanco = this.getTipoBanco();
		if (tipoBanco.equals("PostgreSql")) dao = new FabricaDAOPostgres();
		else if (tipoBanco.equals("MSSql")) dao = new FabricaDAOMsSql();
	}

	public FabricaDAOSegurancaIf getFabrica() {
		return dao;
	}
	
}