package com.vortice.seguranca.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.persistencia.SegurancaPostgresSQL;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;

public class PerfilDAOPostgreSql extends SegurancaPostgresSQL implements PerfilDAOIf {
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("INSERT INTO PERFIL (SEQ_PERFIL, NOME, DESCRICAO) VALUES (?, ?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			vo.setCodigo(new Integer(getSequence("SEQ_PERFIL").intValue()));
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
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
		}finally{
			this.fechar(conn, stmt, null);
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
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_PERFIL, NOME, DESCRICAO FROM PERFIL WHERE SEQ_PERFIL=?")
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
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_PERFIL")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				return perfilVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_PERFIL, NOME, DESCRICAO FROM PERFIL WHERE ")
		.append("(? IS NULL OR UPPER(NOME) LIKE '%' || UPPER(?) || '%') AND ")
		.append("(? IS NULL OR UPPER(DESCRICAO) LIKE '%' || UPPER(?) || '%') ORDER BY NOME")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collPerfil = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getNome());
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.setString(4, vo.getDescricao());
			rs = stmt.executeQuery();
			while (rs.next()){
				PerfilVO perfilVO = new PerfilVO();
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_PERFIL")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				collPerfil.add(perfilVO);
			}
			return collPerfil;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findAll() throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_PERFIL, NOME, DESCRICAO FROM PERFIL ORDER BY NOME").toString();
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
				perfilVO.setCodigo(new Integer(rs.getInt("SEQ_PERFIL")));
				perfilVO.setNome(rs.getString("NOME"));
				perfilVO.setDescricao(rs.getString("DESCRICAO"));
				collPerfil.add(perfilVO);
			}
			return collPerfil;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public void insertFuncionalidade(PerfilVO perfil, FuncionalidadeVO funcionalidade) throws AmbienteException, AplicacaoException{
		String sql = "INSERT INTO PERFIL_FUNCIONALIDADE (SEQ_FUNCIONALIDADE, SEQ_PERFIL) VALUES (?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcionalidade.getCodigo().intValue());
			stmt.setInt(2, perfil.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void removeFuncionalidade(PerfilVO perfil) throws AmbienteException, AplicacaoException{
		String sql = "DELETE FROM PERFIL_FUNCIONALIDADE WHERE SEQ_PERFIL=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, perfil.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
}