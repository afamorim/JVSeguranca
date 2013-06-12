package com.vortice.seguranca.rn;

import java.util.Collection;
import java.util.Iterator;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.rn.SegurancaRegraNegocio;
import com.vortice.seguranca.dao.FuncionalidadeDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class FuncionalidadeRN extends SegurancaRegraNegocio {
	
	private FuncionalidadeDAOIf dao;
	
	public FuncionalidadeRN() throws AmbienteException{
		dao = getFabrica().getFuncionalidadeDAOIf();
	}
	
	public FuncionalidadeVO insert(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		dao.insert(vo);
		salvaFuncoes(vo);
		return vo;
	}
	
	public void update(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		dao.update(vo);
		removeFuncoes(vo);
		salvaFuncoes(vo);
	}
	
	public void remove(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		removeFuncoes(vo);
		dao.remove(vo);
	}
	
	public FuncionalidadeVO findByPrimaryKey(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByPrimaryKey(vo);
	}
	
	public Collection findAll() throws AmbienteException, AplicacaoException{
		return dao.findAll();
	}
	
	public Collection findByFilter(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByFilter(vo);
	}
	
	public Collection findByUsuario(UsuarioVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByUsuario(vo);
	}
	
	private void salvaFuncoes(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		Collection funcoes = vo.getFuncoes();
		if (funcoes != null && funcoes.size() > 0){
			Iterator iterator = funcoes.iterator();
			while(iterator.hasNext()){
				FuncaoVO funcao = (FuncaoVO)iterator.next();
				dao.insertFuncao(vo, funcao);
			}
		}
	}
	
	private void removeFuncoes(FuncionalidadeVO vo) throws AmbienteException, AplicacaoException{
		dao.removeFuncao(vo);
	}
	
	public Collection findByPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByPerfil(vo);
	}
	
	public Collection findByNPerfil(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByNPerfil(vo);
	}
}
