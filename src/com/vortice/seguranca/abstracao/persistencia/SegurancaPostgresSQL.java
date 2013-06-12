package com.vortice.seguranca.abstracao.persistencia;

import java.io.Serializable;

import com.vortice.persistencia.PostGreSqlDAO;
import com.vortice.persistencia.conexao.ConexaoIf;
import com.vortice.persistencia.conexao.FabricaConexao;

public class SegurancaPostgresSQL extends PostGreSqlDAO implements Serializable{

	public SegurancaPostgresSQL(){
		FabricaConexao fabricaConexao = new FabricaConexao();
		fabricaConexao.setTipoConexao("JDBC");
		ConexaoIf conexao = fabricaConexao.getConexao();
		conexao.setDs("java:/productoDS");
		setTipoConexao(conexao);
	}	
}