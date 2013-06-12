package com.vortice.seguranca.dao;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public interface FuncionalidadeDAOIf {
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public void insertFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException;
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO, FuncaoVO funcao) throws AmbienteException, AplicacaoException;
	
	public void removeFuncao(FuncionalidadeVO funcionalidadeVO) throws AmbienteException, AplicacaoException;
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException;
	
	public Collection findAll() throws AmbienteException;
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException;
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException;
	
	public Collection findByPerfil(PerfilVO vo) throws AmbienteException;
	
	public Collection findByNPerfil(PerfilVO vo) throws AmbienteException;
}
