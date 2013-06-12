package com.vortice.seguranca.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.persistencia.SegurancaPostgresSQL;
import com.vortice.seguranca.dao.UsuarioDAOIf;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class UsuarioDAOPostgreSql extends SegurancaPostgresSQL implements UsuarioDAOIf{

	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO USUARIO (SEQ_USUARIO, SEQ_PERFIL, LOGIN, SENHA, NOME, ATIVO) VALUES ").append("(?, ?, ?, ?, ?, ?)")
		.toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			
			vo.setCodigo(new Integer(getSequence("SEQ_USUARIO").intValue()));
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, vo.getCodigo().intValue());
			stmt.setInt(2, vo.getPerfil().getCodigo().intValue());
			stmt.setString(3, vo.getLogin());
			stmt.setString(4, vo.getSenha());
			stmt.setString(5, vo.getNome());
			stmt.setBoolean(6, vo.getAtivo());

			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			tratarExcessaoUnique(sqlEx);
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}

	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE usuario SET seq_perfil=?, login=?, senha=?, nome=?, ativo=? WHERE seq_usuario=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, vo.getPerfil().getCodigo().intValue());
			stmt.setString(2, vo.getLogin());
			stmt.setString(3, vo.getSenha());
			stmt.setString(4, vo.getNome());
			stmt.setBoolean(5, vo.getAtivo());
			stmt.setInt(6, vo.getCodigo().intValue());
			
			stmt.execute();
		}catch(SQLException sqlEx){
			tratarExcessaoUnique(sqlEx);
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void updateSenha(UsuarioVO vo)throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE USUARIO SET SENHA=? WHERE SEQ_USUARIO=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			this.setParameterValueStatement(stmt, vo, new String[]{"senha", "codigo"});
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("DELETE FROM USUARIO WHERE SEQ_USUARIO=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			this.setParameterValueStatement(stmt, vo, new String[]{"codigo"});
			stmt.execute();
		}catch(SQLException sqlEx){
			tratarExcessaoRemove(sqlEx);
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, null);
		}
	}
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT seq_usuario, nome, seq_perfil, login, senha, ativo FROM usuario WHERE seq_usuario=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getCodigo().intValue());
			rs = stmt.executeQuery();
			if (rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("seq_usuario")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("seq_perfil"))));
				usuarioVO.setLogin(rs.getString("login"));
				usuarioVO.setSenha(rs.getString("senha"));
				usuarioVO.setAtivo(rs.getBoolean("ativo"));
				usuarioVO.setNome(rs.getString("nome"));
				return usuarioVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT u.seq_usuario, u.seq_perfil, u.login, u.senha, p.nome AS perfil, u.ativo FROM usuario AS u  ")
		.append("JOIN perfil AS p ON u.seq_perfil=p.seq_perfil WHERE (? IS NULL OR UPPER(u.login) LIKE '%' || UPPER(?) || '%') AND ")
		.append("(? IS NULL OR p.seq_perfil=?) ORDER BY u.login").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		Collection collUsuario = new ArrayList();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			if (vo.getLogin() != null){
				stmt.setString(1, vo.getLogin());
				stmt.setString(2, vo.getLogin());
			}else{
				stmt.setNull(1, Types.VARCHAR);
				stmt.setNull(2, Types.VARCHAR);
			}
			if (vo.getPerfil() != null && vo.getPerfil().getCodigo() != null){
				stmt.setInt(3, vo.getPerfil().getCodigo().intValue());
				stmt.setInt(4, vo.getPerfil().getCodigo().intValue());
			}else{
				stmt.setNull(3, Types.INTEGER);
				stmt.setNull(4, Types.INTEGER);
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("seq_usuario")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("seq_perfil"))));
				usuarioVO.setLogin(rs.getString("login"));
				usuarioVO.setSenha(rs.getString("senha"));
				usuarioVO.getPerfil().setNome(rs.getString("perfil"));
				usuarioVO.setAtivo(rs.getBoolean("ativo"));
				collUsuario.add(usuarioVO);
			}
			return collUsuario;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		String sql = new StringBuffer("SELECT u.seq_usuario, u.seq_perfil, u.login, u.senha, p.nome AS perfil, u.ativo FROM usuario AS u ")
		.append("JOIN perfil AS p ON u.seq_perfil=p.seq_perfil WHERE u.login=? AND u.senha=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getLogin());
			stmt.setString(2, vo.getSenha());
			rs = stmt.executeQuery();
			if(rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("seq_usuario")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("seq_perfil"))));
				usuarioVO.setLogin(rs.getString("login"));
				usuarioVO.setSenha(rs.getString("senha"));
				usuarioVO.getPerfil().setNome(rs.getString("perfil"));
				usuarioVO.setAtivo(rs.getBoolean("ativo"));
				return usuarioVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public UsuarioVO findByLogin(UsuarioVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT U.SEQ_USUARIO, U.SEQ_PERFIL, U.LOGIN, U.SENHA, P.NOME AS PERFIL FROM USUARIO AS U  ")
		.append("JOIN PERFIL AS P ON U.SEQ_PERFIL=P.SEQ_PERFIL WHERE U.LOGIN=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getLogin());
			rs = stmt.executeQuery();
			if(rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("SEQ_USUARIO")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("SEQ_PERFIL"))));
				usuarioVO.setLogin(rs.getString("LOGIN"));
				usuarioVO.setSenha(rs.getString("SENHA"));
				usuarioVO.getPerfil().setNome(rs.getString("PERFIL"));
				return usuarioVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
	
	public Collection<UsuarioVO> findOnlyUsuario(Integer perfilCliente) throws AmbienteException{
		String sql = "SELECT seq_usuario, login, seq_perfil, ativo FROM usuario WHERE seq_perfil<>?";
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		Collection<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, perfilCliente);
			rs = stmt.executeQuery();
			while(rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("seq_usuario")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("seq_perfil"))));
				usuarioVO.setLogin(rs.getString("login"));
				usuarioVO.setAtivo(rs.getBoolean("ativo"));
				usuarios.add(usuarioVO);
			}
			return usuarios;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}finally{
			this.fechar(conn, stmt, rs);
		}
	}
}