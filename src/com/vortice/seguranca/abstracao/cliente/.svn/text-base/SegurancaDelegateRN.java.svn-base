package com.vortice.seguranca.abstracao.cliente;

import java.util.Collection;

import org.apache.log4j.Logger;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.rn.FuncaoRN;
import com.vortice.seguranca.rn.FuncionalidadeRN;
import com.vortice.seguranca.rn.LinkRN;
import com.vortice.seguranca.rn.PerfilRN;
import com.vortice.seguranca.rn.UsuarioRN;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class SegurancaDelegateRN implements SegurancaDelegateIf{
	
	private UsuarioRN usuarioRN;
	
	private FuncaoRN funcaoRN;
	
	private PerfilRN perfilRN;
	
	private FuncionalidadeRN funcionalidadeRN;
	
	private LinkRN linkRN;
	
	private Logger log = Logger.getLogger(SegurancaDelegateRN.class);
	
	public SegurancaDelegateRN() throws AmbienteException{
		usuarioRN = new UsuarioRN();
		funcaoRN = new FuncaoRN();
		perfilRN = new PerfilRN();
		funcionalidadeRN = new FuncionalidadeRN();
		linkRN = new LinkRN();
	}
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return usuarioRN.insert(vo);
	}
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		usuarioRN.update(vo);
	}
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		usuarioRN.remove(vo);
	}
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return usuarioRN.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return usuarioRN.findByFilter(vo);
	}
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return usuarioRN.autenticar(vo);
	}
	
	public FuncaoVO insert(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.insert(vo);
	}
	
	public void update(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		funcaoRN.update(vo);
	}
	
	public void remove(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		funcaoRN.remove(vo);
	}
	
	public FuncaoVO findByPrimaryKey(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.findByPrimaryKey(vo);
	}
	
	public Collection findFuncaoAll() throws AmbienteException, AplicacaoException{
		return funcaoRN.findAll();
	}
	
	public Collection findByFilter(FuncaoVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.findByFilter(vo);
	}
	
	public Collection findFuncaoByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.findByUsuario(vo);
	}
	
	public Collection findFuncaoByFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.findByFuncionalidade(vo);
	}
	
	public Collection findFuncaoByNFuncionalidade(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return funcaoRN.findByNFuncionalidade(vo);
	}
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.insert(vo);
	}
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		funcionalidadeRN.update(vo);
	}
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		funcionalidadeRN.remove(vo);
	}
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findByPrimaryKey(vo);
	}
	
	public Collection findFuncionalidadeAll() throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findAll();
	}
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findByFilter(vo);
	}
	
	public Collection findFuncionalidadeByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findByUsuario(vo);
	}
	
	public Collection findFuncionalidadeByPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findByPerfil(vo);
	}
	
	public Collection findFuncionalidadeByNPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return funcionalidadeRN.findByNPerfil(vo);
	}
	
	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException{
		return linkRN.insert(vo);
	}
	
	public void update(LinkVO vo) throws AmbienteException, AplicacaoException{
		linkRN.update(vo);
	}
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException{
		linkRN.remove(vo);
	}
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException, AplicacaoException{
		return linkRN.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException, AplicacaoException{
		return linkRN.findByFilter(vo);
	}
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return perfilRN.insert(vo);
	}
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException{
		perfilRN.update(vo);
	}
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException{
		perfilRN.remove(vo);
	}
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return perfilRN.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return perfilRN.findByFilter(vo);
	}
	
	public Collection findAllPerfil() throws AmbienteException, AplicacaoException{
		return perfilRN.findAll();
	}
}
