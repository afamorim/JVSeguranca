package com.vortice.seguranca.abstracao.cliente;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public interface SegurancaDelegateIf extends Serializable{
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncaoAll() throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncaoByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncaoByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncaoByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncionalidadeAll() throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncionalidadeByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncionalidadeByPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findFuncionalidadeByNPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(LinkVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException;
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException, AplicacaoException;
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException, AplicacaoException;
	
	public Collection findAllPerfil() throws AmbienteException, AplicacaoException;
	
}
