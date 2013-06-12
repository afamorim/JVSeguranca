package com.vortice.seguranca.cliente;

import java.io.InputStream;

import com.vortice.abstracao.BusinessDelegateAB;
import com.vortice.exception.AmbienteException;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateRN;

public class FabricaSeguracancaDelegate extends BusinessDelegateAB{
	
	private Integer sessionBean;
	
	public FabricaSeguracancaDelegate(Integer aSessionBean){
		sessionBean = aSessionBean;
	}
	
	public FabricaSeguracancaDelegate(){
	}
	
	public SegurancaDelegateIf getSegurancaDelegate() throws AmbienteException{
		if (getTipoDelegate().equals("1")){
			return new SegurancaDelegateFacade();
		}else{
			return new SegurancaDelegateRN();
		}
	}

}
