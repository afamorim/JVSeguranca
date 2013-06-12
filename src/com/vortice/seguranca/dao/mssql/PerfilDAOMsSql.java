package com.vortice.seguranca.dao.mssql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.persistencia.MsSqlDAO;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;

public class PerfilDAOMsSql extends MsSqlDAO implements PerfilDAOIf {

	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("INSERT INTO PERFIL (NOME, DESCRICAO) VALUES ")
		.append("(?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getNome());
			stmt.setString(2, vo.getDescricao());
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("UPDATE PERFIL SET NOME=?, DESCRICAO=? WHERE SEQ_PERFIL=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getNome());
			stmt.setString(2, vo.getDescricao());
			stmt.setInt(3, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("DELETE FROM PERFIL WHERE SEQ_PERFIL=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_PERFIL, NOME, DESCRICAO FROM PERIL WHERE SEQ_PERFIL=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			if (rs.next()){
				PerfilVO perfilVO = new PerfilVO();
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				return perfilVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO WHERE SEQ_FUNCAO=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collPerfil = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				PerfilVO perfilVO = new PerfilVO();
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				collPerfil.add(perfilVO);
			}
			return collPerfil;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findAll() throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO WHERE SEQ_FUNCAO=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collPerfil = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				PerfilVO perfilVO = new PerfilVO();
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				collPerfil.add(perfilVO);
			}
			return collPerfil;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public void insertFuncionalidade(PerfilVO perfil, FuncionalidadeVO funcionalidade) throws AmbienteException, AplicacaoException{
		
	}
	
	public void removeFuncionalidade(PerfilVO perfil) throws AmbienteException, AplicacaoException{
		
	}
}
