package com.vortice.seguranca.dao;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.UsuarioVO;

public interface FuncaoDAOIf {
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findAll() throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
}
