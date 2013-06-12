package com.vortice.seguranca.abstracao.cliente;

import java.rmi.RemoteException;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.vortice.abstracao.BusinessDelegateAB;
import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.ejb.facade.Seguranca;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class SegurancaDelegateFacade extends BusinessDelegateAB implements SegurancaDelegateIf{
	
	private Seguranca bean;
	
	private Logger log = Logger.getLogger(SegurancaDelegateFacade.class);
	
	public SegurancaDelegateFacade() throws AmbienteException{
		try{
			log.debug("SegurancaDelegateFacade");
			setHost("localhost");
			bean = (Seguranca)getEJBSessionRemote("Producto", "Seguranca");
			//bean = (Seguranca)getEJBSessionRemote("TPNE", "Seguranca");
			//bean = (Seguranca)getEJBSessionRemote("Sisjuf", "Seguranca");
		}catch(Exception e){
			throw new AmbienteException(e);
		}
	}
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.insert(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.update(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.remove(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByPrimaryKey(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByFilter(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.autenticar(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.insert(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.update(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.remove(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByPrimaryKey(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncaoAll() throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncaoAll();
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByFilter(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncaoByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncaoByUsuario(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncaoByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncaoByFuncionalidade(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncaoByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncaoByNFuncionalidade(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.insert(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.update(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.remove(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByPrimaryKey(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncionalidadeAll() throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncaoAll();
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByFilter(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncionalidadeByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncionalidadeByUsuario(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncionalidadeByPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncionalidadeByPerfil(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findFuncionalidadeByNPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findFuncionalidadeByNPerfil(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.insert(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void update(LinkVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.update(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.remove(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByPrimaryKey(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByFilter(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.insert(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.update(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			bean.remove(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByPrimaryKey(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException, AplicacaoException{
		try{
			return bean.findByFilter(vo);
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
	
	public Collection findAllPerfil() throws AmbienteException, AplicacaoException{
		try{
			return bean.findAllPerfil();
		}catch(RemoteException re){
			throw new AmbienteException(re);
		}
	}
}
