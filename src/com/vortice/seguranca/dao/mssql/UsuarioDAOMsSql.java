package com.vortice.seguranca.dao.mssql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.persistencia.MsSqlDAO;
import com.vortice.seguranca.dao.UsuarioDAOIf;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class UsuarioDAOMsSql extends MsSqlDAO implements UsuarioDAOIf {

	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("INSERT INTO USUARIO (SEQ_USUARIO, SEQ_PERFIL, LOGIN, SENHA) VALUES (?, ?, ?, ?, ?)").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			this.setParameterValueStatement(stmt, vo, new String[]{"perfil.codigo", "login", "senha"});
			stmt.execute();
			return vo;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}

	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException {
		String sql = new StringBuffer("UPDATE USUARIO SEQ_PERFIL=?, LOGIN=?, SENHA=? WHERE SEQ_USUARIO=?").toString();
		Connection conn = null;
		PreparedStatement stmt= null;
		try{
			conn = getConexao();
			stmt = conn.prepareStatement(sql);
			this.setParameterValueStatement(stmt, vo, new String[]{"perfil.codigo", "login", "senha", "codigo"});
			stmt.execute();
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public void updateSenha(UsuarioVO vo)throws AmbienteException, AplicacaoException{
		
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
			throw new AmbienteException(sqlEx);
		}
	}
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_USUARIO, SEQ_PERFIL, LOGIN, SENHA FROM USUARIO WHERE SEQ_USUARIO=?").toString();
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
				usuarioVO.setCodigo(new Integer(rs.getInt("SEQ_USUARIO")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("SEQ_PERFIL"))));
				usuarioVO.setLogin(rs.getString("LOGIN"));
				usuarioVO.setSenha(rs.getString("SENHA"));
				return usuarioVO;
			}else{
				return null;
			}
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException{
		String sql = new StringBuffer("SELECT SEQ_USUARIO, SEQ_PERFIL, LOGIN, SENHA FROM USUARIO WHERE ")
		.append("(? IS NULL OR UPPER(LOGIN) LIKE '%' || UPPER(?) || '%') AND (? IS NULL OR SEQ_PERFIL LIKE '%' || ? || '%')").toString();
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
			if (vo.getPerfil() != null && vo.getPerfil().getCodigo()  != null){
				stmt.setInt(3, vo.getPerfil().getCodigo().intValue());
				stmt.setInt(4, vo.getPerfil().getCodigo().intValue());
			}else{
				stmt.setNull(3, Types.INTEGER);
				stmt.setNull(4, Types.INTEGER);
			}
			rs = stmt.executeQuery();
			while(rs.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setCodigo(new Integer(rs.getInt("SEQ_USUARIO")));
				usuarioVO.setPerfil(new PerfilVO(new Integer(rs.getInt("SEQ_PERFIL"))));
				usuarioVO.setLogin(rs.getString("LOGIN"));
				usuarioVO.setSenha(rs.getString("SENHA"));
				collUsuario.add(usuarioVO);
			}
			return collUsuario;
		}catch(SQLException sqlEx){
			throw new AmbienteException(sqlEx);
		}
	}
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return null;
	}
	
	public UsuarioVO findByLogin(UsuarioVO vo) throws AmbienteException{
		return null;
	}

	public Collection<UsuarioVO> findOnlyUsuario(Integer perfilCliente) throws AmbienteException {
		return null;
	}
	
}