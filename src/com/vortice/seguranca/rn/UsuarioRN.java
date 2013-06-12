package com.vortice.seguranca.rn;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.rn.SegurancaRegraNegocio;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.dao.UsuarioDAOIf;
import com.vortice.seguranca.vo.UsuarioVO;

public class UsuarioRN extends SegurancaRegraNegocio {
	
	private UsuarioDAOIf dao;
	
	private FuncionalidadeDAOIf funcionalidadeDAO;
	
	public UsuarioRN() throws AmbienteException{
		dao = this.getFabrica().getUsuarioDAOIf();
		funcionalidadeDAO = this.getFabrica().getFuncionalidadeDAOIf();
	}
	
	public UsuarioVO insert(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return dao.insert(vo);
	}
	
	public void update(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		dao.update(vo);
		if (vo.getSenha() != null && !vo.getSenha().equals("")) dao.updateSenha(vo);
	}
	
	public void remove(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		dao.remove(vo);
	}
	
	public UsuarioVO findByPrimaryKey(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByFilter(vo);
	}
	
	public UsuarioVO autenticar(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		UsuarioVO usuarioVO = dao.autenticar(vo);
		if (usuarioVO != null && usuarioVO.isAtivo()){
			vo = usuarioVO;
			vo.setFuncionalidades(funcionalidadeDAO.findByUsuario(vo));
			vo.getPerfil().setFuncionalidades(funcionalidadeDAO.findByPerfil(vo.getPerfil()));
			return vo;
		}if (usuarioVO != null && !usuarioVO.isAtivo()){
			throw new AplicacaoException("Seu usuário não esta ativo.");
		}else{
			throw new AplicacaoException("Login ou senha invalidos.");
		}
	}
	
	public Collection<UsuarioVO> findOnlyUsuario(Integer perfilCliente) throws AmbienteException, AplicacaoException{
		return dao.findOnlyUsuario(perfilCliente);
	}
}
