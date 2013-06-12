package com.vortice.seguranca.ejb.facade;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.EJBObject;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public interface Seguranca extends EJBObject{
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncaoAll() throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncaoByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncaoByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncaoByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncionalidadeAll() throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncionalidadeByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void update(LinkVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findAllPerfil() throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncionalidadeByPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
	public Collection findFuncionalidadeByNPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException, RemoteException;
	
}
