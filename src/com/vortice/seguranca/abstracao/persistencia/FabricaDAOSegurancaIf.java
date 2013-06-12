package com.vortice.seguranca.abstracao.persistencia;

import com.vortice.persistencia.FabricaDAOIf;
import com.vortice.seguranca.dao.FuncaoDAOIf;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.dao.LinkDAOIf;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.dao.UsuarioDAOIf;


public interface FabricaDAOSegurancaIf extends FabricaDAOIf {
	
	public UsuarioDAOIf getUsuarioDAOIf();
	
	public PerfilDAOIf getPerfilDAOIf();
	
	public FuncaoDAOIf getFuncaoDAOIf();
	
	public FuncionalidadeDAOIf getFuncionalidadeDAOIf();
	
	public LinkDAOIf getLinkDAOIf();
}
