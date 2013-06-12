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
import com.vortice.seguranca.dao.LinkDAOIf;
import com.vortice.seguranca.vo.LinkVO;

public class LinkDAOPostgreSql extends SegurancaPostgresSQL implements LinkDAOIf {

	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = new StringBuffer("INSERT INTO LINK_FUNCAO (SEQ_LINK, URL, DESCRICAO, TIPO) VALUES ")
		.append("(?, ?, ?, ?)").toString();
		try{
			conn = getConexao();
			vo.setCodigo(new Integer(getSequence("SEQ_LINK").intValue()));
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, vo.getCodigo().intValue());
			stmt.setString(2, vo.getUrl());
			stmt.setString(3, vo.getDescricao());
			stmt.setString(4, vo.getTipo().toString());
			
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
		finally{
			this.fechar(conn, stmt, null);
		}
	}

	public void update(LinkVO vo) throws AmbienteException, AplicacaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = new StringBuffer("UPDATE LINK_FUNCAO SET URL=?, DESCRICAO=?, TIPO=? WHERE SEQ_LINK=?")
		.toString();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUrl());
			stmt.setString(2, vo.getDescricao());
			stmt.setString(3, vo.getTipo().toString());
			stmt.setInt(4, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
		
	}
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = new StringBuffer("DELETE FROM LINK_FUNCAO WHERE SEQ_LINK=?").toString();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
		
	}
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new StringBuffer("SELECT SEQ_LINK, URL, DESCRICAO, TIPO FROM LINK_FUNCAO WHERE SEQ_LINK=?")
		.toString();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			if (rs.next()){
				vo.setUrl(rs.getString("URL"));
				vo.setDescricao(rs.getString("DESCRICAO"));
				vo.setTipo(new Character(rs.getString("TIPO").charAt(0)));
				return vo;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = new StringBuffer("SELECT SEQ_LINK, URL, DESCRICAO, TIPO FROM LINK_FUNCAO ")
		.append("WHERE (? IS NULL OR UPPER(URL) LIKE '%' || UPPER(?) || '%') AND ")
		.append("(? IS NULL OR UPPER(DESCRICAO) LIKE '%' || UPPER(?) || '%') ORDER BY URL").toString();
		Collection collLink = new ArrayList();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getUrl());
			stmt.setString(2, vo.getUrl());
			stmt.setString(3, vo.getDescricao());
			stmt.setString(4, vo.getDescricao());
			rs = stmt.executeQuery();
			while (rs.next()){
				LinkVO linkVO = new LinkVO();
				linkVO.setCodigo(new Integer(rs.getInt("SEQ_LINK")));
				linkVO.setUrl(rs.getString("URL"));
				linkVO.setDescricao(rs.getString("DESCRICAO"));
				collLink.add(linkVO);
			}
			return collLink;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
}
