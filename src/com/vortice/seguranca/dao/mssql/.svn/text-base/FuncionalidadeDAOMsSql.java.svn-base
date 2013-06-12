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
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class FuncionalidadeDAOMsSql extends MsSqlDAO implements FuncionalidadeDAOIf{

	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO FUNCIONALIDADE (NOME, DESCRICAO) VALUES ")
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
	
	public void insertFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException{
		
	}
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException{
	}
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO) throws AmbienteException, AplicacaoException{}
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE FUNCIONALIDADE SET NOME=?, DESCRICAO=? WHERE SEQ_FUNCIONALIDADE=?")
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

	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("DELETE FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?").toString();
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

	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE WHERE ")
		.append("SEQ_FUNCIONALIDADE=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			if (rs.next()){
				FuncionalidadeVO funcionalidadeVO = new FuncionalidadeVO();
				funcionalidadeVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCIONALIDADE")));
				funcionalidadeVO.setNome(rs.getString("NOME"));
				funcionalidadeVO.setDescricao(rs.getString("DESCRICAO"));
				return funcionalidadeVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}

	public Collection findAll() throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE ").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncionalidade = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncionalidadeVO funcionalidadeVO = new FuncionalidadeVO();
				funcionalidadeVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCIONALIDADE")));
				funcionalidadeVO.setNome(rs.getString("NOME"));
				funcionalidadeVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncionalidade.add(funcionalidadeVO);
			}
			return collFuncionalidade;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE WHERE ")
		.append("(? IS NUL OR UPPER(NOME) LIKE '%' || UPPER(?) || '%')").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncionalidade = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getNome());
			stmt.setString(2, vo.getNome());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncionalidadeVO funcionalidadeVO = new FuncionalidadeVO();
				funcionalidadeVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCIONALIDADE")));
				funcionalidadeVO.setNome(rs.getString("NOME"));
				funcionalidadeVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncionalidade.add(funcionalidadeVO);
			}
			return collFuncionalidade;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCIONALIDADE, F.NOME, F.DESCRICAO FROM FUNCIONALIDADE AS F ")
		.append("JOIN USUARIO_FUNCIONALIDADE AS UF ON F.SEQ_FUNCIONALIDADE=UF.SEQ_FUNCIONALIDADE ")
		.append("WHERE UF.SEQ_USUARIO=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncionalidade = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncionalidadeVO funcionalidadeVO = new FuncionalidadeVO();
				funcionalidadeVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCIONALIDADE")));
				funcionalidadeVO.setNome(rs.getString("NOME"));
				funcionalidadeVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncionalidade.add(funcionalidadeVO);
			}
			return collFuncionalidade;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByPerfil(PerfilVO vo) throws AmbienteException{
		return null;
	}
	
	public Collection findByNPerfil(PerfilVO vo) throws AmbienteException{
		return null;
	}
}
