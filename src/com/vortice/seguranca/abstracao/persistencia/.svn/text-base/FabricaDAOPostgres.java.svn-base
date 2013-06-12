/*
 * Created on 13/03/2005
 */
package com.vortice.seguranca.abstracao.persistencia;

import com.vortice.seguranca.dao.FuncaoDAOIf;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.dao.LinkDAOIf;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.dao.UsuarioDAOIf;
import com.vortice.seguranca.dao.postgresql.FuncaoDAOPostgreSql;
import com.vortice.seguranca.dao.postgresql.FuncionalidadeDAOPostgreSql;
import com.vortice.seguranca.dao.postgresql.LinkDAOPostgreSql;
import com.vortice.seguranca.dao.postgresql.PerfilDAOPostgreSql;
import com.vortice.seguranca.dao.postgresql.UsuarioDAOPostgreSql;

/**
 * @author Desenvolvimento
 */
public class FabricaDAOPostgres implements FabricaDAOSegurancaIf {
	
	public UsuarioDAOIf getUsuarioDAOIf(){
		return new UsuarioDAOPostgreSql();
	}
	
	public PerfilDAOIf getPerfilDAOIf(){
		return new PerfilDAOPostgreSql();
	}
	
	public FuncaoDAOIf getFuncaoDAOIf(){
		return new FuncaoDAOPostgreSql();
	}
	
	public FuncionalidadeDAOIf getFuncionalidadeDAOIf(){
		return new FuncionalidadeDAOPostgreSql();
	}
	
	public LinkDAOIf getLinkDAOIf(){
		return new LinkDAOPostgreSql();
	}
	
}
