package com.vortice.seguranca.dao;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;

public interface PerfilDAOIf {
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException;
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException;
	
	public Collection findAll() throws AmbienteException;
	
	public void insertFuncionalidade(PerfilVO perfil, FuncionalidadeVO funcionalidade) throws AmbienteException, AplicacaoException;
	
	public void removeFuncionalidade(PerfilVO perfil) throws AmbienteException, AplicacaoException;
}
