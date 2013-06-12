package com.vortice.seguranca.abstracao.persistencia;

import com.vortice.seguranca.dao.FuncaoDAOIf;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.dao.LinkDAOIf;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.dao.UsuarioDAOIf;
import com.vortice.seguranca.dao.mssql.FuncaoDAOMsSql;
import com.vortice.seguranca.dao.mssql.FuncionalidadeDAOMsSql;
import com.vortice.seguranca.dao.mssql.LinkDAOMsSql;
import com.vortice.seguranca.dao.mssql.PerfilDAOMsSql;
import com.vortice.seguranca.dao.mssql.UsuarioDAOMsSql;


public class FabricaDAOMsSql implements FabricaDAOSegurancaIf {

	public UsuarioDAOIf getUsuarioDAOIf() {
		return new UsuarioDAOMsSql();
	}

	public PerfilDAOIf getPerfilDAOIf() {
		return new PerfilDAOMsSql();
	}

	public FuncaoDAOIf getFuncaoDAOIf() {
		return new FuncaoDAOMsSql();
	}

	public FuncionalidadeDAOIf getFuncionalidadeDAOIf() {
		return new FuncionalidadeDAOMsSql();
	}

	public LinkDAOIf getLinkDAOIf() {
		return new LinkDAOMsSql();
	}

}
