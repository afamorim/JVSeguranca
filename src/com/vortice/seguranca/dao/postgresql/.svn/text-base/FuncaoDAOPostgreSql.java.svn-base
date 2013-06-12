package com.vortice.seguranca.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.persistencia.SegurancaPostgresSQL;
import com.vortice.seguranca.dao.FuncaoDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class FuncaoDAOPostgreSql extends SegurancaPostgresSQL implements FuncaoDAOIf {
	
	private Logger LOG = Logger.getLogger(FuncaoDAOPostgreSql.class);
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO FUNCAO (SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO) VALUES ")
		.append("(?, ?, ?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConexao();
			vo.setCodigo(new Integer(getSequence("SEQ_FUNCAO").intValue()));
			LOG.debug("Funcao.getCodigo> " + vo.getCodigo());
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			if (vo.getLink() != null && vo.getLink().getCodigo() != null){
				stmt.setInt(2, vo.getLink().getCodigo().intValue());
			}else{
				stmt.setNull(2, Types.INTEGER);
			}
			LOG.debug("Funcao.getLink().getCodigo()> " + vo.getLink().getCodigo());
			stmt.setString(3, vo.getNome());
			stmt.setString(4, vo.getDescricao());
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
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
			System.out.println("Link " + vo.getLink().getCodigo() + " -0");
			if (vo.getLink() != null && vo.getLink().getCodigo() != null && vo.getLink().getCodigo().intValue() != 0){
				stmt.setInt(1, vo.getLink().getCodigo().intValue());
				System.out.println("AQUI 1");
			}else{
				stmt.setNull(1, Types.INTEGER);
				System.out.println("AQUI 2");
			}
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.setInt(4, vo.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
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
		}finally{
			this.fechar(conn, stmt, null);
		}

	}

	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCAO, F.NOME, F.DESCRICAO, L.SEQ_LINK, L.URL  FROM FUNCAO ")
		.append("AS F LEFT JOIN LINK_FUNCAO AS L ON F.SEQ_LINK=L.SEQ_LINK WHERE F.SEQ_FUNCAO=?").toString();
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
				funcaoVO.getLink().setUrl(rs.getString("URL"));
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				return funcaoVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findAll() throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO ORDER BY NOME").toString();
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}

	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT SEQ_FUNCAO, SEQ_LINK, NOME, DESCRICAO FROM FUNCAO WHERE ")
		.append("(? IS NULL OR SEQ_LINK=?) AND (? IS NULL OR UPPER(NOME) LIKE '%' || UPPER(?) || '%') ")
		.append("AND (? IS NULL OR UPPER(DESCRICAO) LIKE '%' || UPPER(?) || '%') ORDER BY NOME")
		.toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncao = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			if (vo.getLink() != null && vo.getLink().getCodigo() != null){
				stmt.setInt(1, vo.getCodigo().intValue());
				stmt.setInt(2, vo.getCodigo().intValue());
			}else{
				stmt.setNull(1, Types.INTEGER);
				stmt.setNull(2, Types.INTEGER);
			}
			stmt.setString(3, vo.getNome());
			stmt.setString(4, vo.getNome());
			stmt.setString(5, vo.getDescricao());
			stmt.setString(6, vo.getDescricao());
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = "SELECT DISTINCT f.seq_funcao, f.seq_link, f.nome, f.descricao, l.url " +
			"FROM usuario AS u JOIN perfil AS p ON u.seq_perfil=p.seq_perfil " +
			"JOIN perfil_funcionalidade AS pf ON p.seq_perfil=pf.seq_perfil " +
			"LEFT JOIN usuario_funcionalidade AS uf ON u.seq_usuario=uf.seq_usuario " +
			"LEFT JOIN usuario_funcao AS uf2 ON u.seq_usuario=uf2.seq_usuario " +
			"LEFT JOIN funcao_funcionalidade AS ff ON pf.seq_funcionalidade=ff.seq_funcionalidade OR uf.seq_funcionalidade=ff.seq_funcionalidade " +
			"LEFT JOIN funcao AS f ON f.seq_funcao=ff.seq_funcao OR uf2.seq_funcao=f.seq_funcao " +
			"LEFT JOIN link_funcao AS l ON f.seq_link=l.seq_link " +
			"WHERE u.seq_usuario=?";
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
				funcaoVO.setCodigo(new Integer(rs.getInt("seq_funcao")));
				funcaoVO.setNome(rs.getString("nome"));
				funcaoVO.setDescricao(rs.getString("descricao"));
				if (rs.getInt("seq_link") > 0){
					funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("seq_link"))));
					funcaoVO.getLink().setUrl(rs.getString("url"));
				}
					
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCAO, F.SEQ_LINK, F.NOME, F.DESCRICAO, L.URL FROM FUNCAO AS F ")
		.append("JOIN FUNCAO_FUNCIONALIDADE AS FF ON F.SEQ_FUNCAO=FF.SEQ_FUNCAO ")
		.append("LEFT JOIN LINK_FUNCAO AS L ON F.SEQ_LINK=L.SEQ_LINK WHERE FF.SEQ_FUNCIONALIDADE=? ORDER BY F.NOME")
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
				funcaoVO.setNome(rs.getString("NOME"));
				funcaoVO.setDescricao(rs.getString("DESCRICAO"));
				if (rs.getInt("SEQ_LINK") > 0){
					funcaoVO.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
					funcaoVO.getLink().setUrl(rs.getString("URL"));
				}
				collFuncao.add(funcaoVO);
			}
			return collFuncao;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("SELECT DISTINCT F.SEQ_FUNCAO, F.SEQ_LINK, F.NOME, F.DESCRICAO FROM FUNCAO AS F LEFT ")
		.append("JOIN FUNCAO_FUNCIONALIDADE AS FF ON F.SEQ_FUNCAO=FF.SEQ_FUNCAO WHERE F.SEQ_FUNCAO NOT IN ")
		.append("(SELECT SEQ_FUNCAO FROM FUNCAO_FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?) ORDER BY F.NOME").toString();
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
}
