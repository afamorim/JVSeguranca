package com.vortice.seguranca.abstracao.cliente.bean;

import java.io.InputStream;

import com.vortice.exception.AmbienteException;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateRN;
import com.vortice.view.BasePageBean;

public class SegurancaPageBean extends BasePageBean {
	
	
	public SegurancaDelegateIf getDelegate() throws AmbienteException{
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("configuracao.xml");
		this.setIs(inputStream);
		String sessionBean = this.getSessionBean();
		if (sessionBean != null && sessionBean.equals("1"))
			return new SegurancaDelegateFacade();
		else return new SegurancaDelegateRN();
	}
	
	protected void sort(final String column, final boolean ascending){
	}
	
	protected boolean isDefaultAscending(String sortColumn){
		return true;
	}
}
