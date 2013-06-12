package com.vortice.seguranca.dao;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.UsuarioVO;

public interface UsuarioDAOIf {
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public void updateSenha(UsuarioVO vo)throws AmbienteException, AplicacaoException;
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException;
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException;
	
	/**
	 * Metpodo que autentica o usuario pelo seus atributos, login e senha.
	 * @param vo
	 * @return
	 * @throws AmbienteException
	 * @throws AplicacaoException
	 */
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	/**
	 * Metodo que retorna o usuario pelo seu login, caso não seja encontrado retorna null.
	 * @param vo
	 * @return
	 * @throws AmbienteException
	 */
	public UsuarioVO findByLogin(UsuarioVO vo) throws AmbienteException;
	
	/**
	 * Metodo ue retornará todos os usuarios que não forem clientes da empresa em questão, ou seja, funcionarios.
	 * @param perfilCliente
	 * @return
	 * @throws AmbienteException
	 */
	public Collection<UsuarioVO> findOnlyUsuario(Integer perfilCliente) throws AmbienteException;
}
