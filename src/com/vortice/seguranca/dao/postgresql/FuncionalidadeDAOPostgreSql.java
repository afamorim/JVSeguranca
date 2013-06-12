package com.vortice.seguranca.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.persistencia.PostGreSqlDAO;
import com.vortice.seguranca.abstracao.persistencia.SegurancaPostgresSQL;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class FuncionalidadeDAOPostgreSql extends SegurancaPostgresSQL implements FuncionalidadeDAOIf {

	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO FUNCIONALIDADE (SEQ_FUNCIONALIDADE, NOME, DESCRICAO) VALUES (?, ?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			vo.setCodigo(new Integer(getSequence("SEQ_FUNCIONALIDADE").intValue()));
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
	
	public void insertFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("INSERT INTO FUNCAO_FUNCIONALIDADE (SEQ_FUNCAO, SEQ_FUNCIONALIDADE) VALUES (?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcao.getCodigo().intValue());
			stmt.setInt(2, funcionalidadeVO.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("DELETE FROM FUNCAO_FUNCIONALIDADE WHERE SEQ_FUNCAO=? AND SEQ_FUNCIONALIDADE=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcao.getCodigo().intValue());
			stmt.setInt(2, funcionalidadeVO.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("DELETE FROM FUNCAO_FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcionalidadeVO.getCodigo().intValue());
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE FUNCIONALIDADE SET NOME=?, DESCRICAO=? WHERE SEQ_FUNCIONALIDADE=?").toString();
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

	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("DELETE FROM FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?").toString();
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

	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE WHERE SEQ_FUNCIONALIDADE=?").toString();
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}

	public Collection findAll() throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE ORDER BY NOME").toString();
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT SEQ_FUNCIONALIDADE, NOME, DESCRICAO FROM FUNCIONALIDADE WHERE ")
		.append("(? IS NULL OR UPPER(NOME) LIKE '%' || UPPER(?) || '%') AND (? IS NULL OR UPPER(DESCRICAO) LIKE '%' || UPPER(?) || '%') ")
		.append("ORDER BY NOME").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncionalidade = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getNome());
			stmt.setString(2, vo.getNome());
			stmt.setString(3, vo.getDescricao());
			stmt.setString(4, vo.getDescricao());
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException {
		String sql = new StringBuffer("SELECT F.SEQ_FUNCIONALIDADE, F.NOME, F.DESCRICAO FROM FUNCIONALIDADE AS F ")
		.append("JOIN USUARIO_FUNCIONALIDADE AS UF ON F.SEQ_FUNCIONALIDADE=UF.SEQ_FUNCIONALIDADE ")
		.append("WHERE UF.SEQ_USUARIO=? ORDER BY F.NOME").toString();
		
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByPerfil(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT F.SEQ_FUNCIONALIDADE, F.NOME, F.DESCRICAO, FUNC.SEQ_FUNCAO, FUNC.NOME AS FUNCAO, ")
		.append("FUNC.DESCRICAO AS FUNC_DESCR, L.URL, L.SEQ_LINK FROM FUNCIONALIDADE AS F ")
		.append("JOIN PERFIL_FUNCIONALIDADE AS PF ON F.SEQ_FUNCIONALIDADE=PF.SEQ_FUNCIONALIDADE ")
		.append("JOIN FUNCAO_FUNCIONALIDADE AS FF ON F.SEQ_FUNCIONALIDADE=FF.SEQ_FUNCIONALIDADE ")
		.append("JOIN FUNCAO AS FUNC ON FF.SEQ_FUNCAO=FUNC.SEQ_FUNCAO ")
		.append("LEFT JOIN LINK_FUNCAO AS L ON FUNC.SEQ_LINK=L.SEQ_LINK WHERE PF.SEQ_PERFIL=? ORDER BY F.SEQ_FUNCIONALIDADE, F.NOME").toString();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection collFuncionalidade = new ArrayList();
		try{
			conn = this.getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			int testSeqFunc = 0;
			//int test
			FuncionalidadeVO funcionalidade = null;
			while (rs.next()){
				if (testSeqFunc != rs.getInt("SEQ_FUNCIONALIDADE")){
					funcionalidade = new FuncionalidadeVO(new Integer(rs.getInt("SEQ_FUNCIONALIDADE")));
					funcionalidade.setNome(rs.getString("NOME"));
					funcionalidade.setDescricao(rs.getString("DESCRICAO"));
					collFuncionalidade.add(funcionalidade);
				}
				if (rs.getInt("SEQ_FUNCAO") > 0){
					FuncaoVO funcao = new FuncaoVO(new Integer(rs.getInt("SEQ_FUNCAO")));
					funcao.setNome(rs.getString("FUNCAO"));
					funcao.setDescricao(rs.getString("FUNC_DESCR"));
					if (rs.getInt("SEQ_LINK") > 0){
						funcao.setLink(new LinkVO(new Integer(rs.getInt("SEQ_LINK"))));
						funcao.getLink().setUrl(rs.getString("URL"));
					}
					funcionalidade.getFuncoes().add(funcao);
				}
				testSeqFunc = rs.getInt("SEQ_FUNCIONALIDADE");
			}
			return collFuncionalidade;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByNPerfil(PerfilVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT DISTINCT F.SEQ_FUNCIONALIDADE, F.NOME, F.DESCRICAO FROM FUNCIONALIDADE AS F LEFT ")
		.append("JOIN PERFIL_FUNCIONALIDADE AS PF ON F.SEQ_FUNCIONALIDADE=PF.SEQ_FUNCIONALIDADE WHERE F.SEQ_FUNCIONALIDADE NOT IN ")
		.append("(SELECT SEQ_FUNCIONALIDADE FROM PERFIL_FUNCIONALIDADE WHERE SEQ_PERFIL=?) ORDER BY F.NOME").toString();
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
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
}
