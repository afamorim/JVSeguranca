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
import com.vortice.seguranca.dao.FuncaoDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class FuncaoDAOMsSql extends MsSqlDAO implements FuncaoDAOIf {

	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO FUNCAO (SEQ_LINK, NOME, DESCRICAO) VALUES ")
		.append("(?, ?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getLink().getCodigo().intValue());
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}

	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE FUNCAO SET SEQ_LINK=?, NOME=?, DESCRICAO=? WHERE SEQ_FUNCAO=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getLink().getCodigo().intValue());
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.setInt(4, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}

	}

	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("DELETE FROM FUNCAO WHERE SEQ_FUNCAO=?").toString();
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

	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO WHERE SEQ_FUNCAO=?")
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
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				return funcaoVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findAll() throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}

	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO WHERE SEQ_FUNCAO=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCAO, F.SEQ_LINK, F.NOME, F.DESCRICAO FROM FUNCAO AS F ")
		.append("JOIN USUARIO_FUNCAO AS UF ON F.SEQ_FUNCAO=UF.SEQ_FUNCAO WHERE UF.SEQ_USUARIO=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCAO, F.SEQ_LINK, F.NOME, F.DESCRICAO FROM FUNCAO AS F ")
		.append("JOIN FUNCAO_FUNCIONALIDADE AS FF ON F.SEQ_FUNCAO=FF.SEQ_FUNCAO WHERE FF.SEQ_FUNCIONALIDADE=?")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCAO, F.SEQ_LINK, F.NOME, F.DESCRICAO FROM FUNCAO AS F ")
		.append("JOIN FUNCAO_FUNCIONALIDADE AS FF ON F.SEQ_FUNCAO=FF.SEQ_FUNCAO WHERE FF.SEQ_FUNCAO NOT IN ")
		.append("(SELECT SEQ_FUNC FROM FUNCAO_FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			while (rs.next()){
				FuncaoVO funcaoVO = new FuncaoVO();
				funcaoVO.setCodigo(new Integer(rs.getInt("SEQ_FUNCAO")));
				funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
}
