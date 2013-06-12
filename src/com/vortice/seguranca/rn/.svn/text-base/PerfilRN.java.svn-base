package com.vortice.seguranca.rn;

import java.util.Collection;
import java.util.Iterator;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.rn.SegurancaRegraNegocio;
import com.vortice.seguranca.dao.PerfilDAOIf;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.PerfilVO;

public class PerfilRN extends SegurancaRegraNegocio {
	
	private PerfilDAOIf dao;
	
	public PerfilRN() throws AmbienteException{
		dao = getFabrica().getPerfilDAOIf();
	}
	
	public PerfilVO insert(PerfilVO vo) throws AmbienteException, AplicacaoException{
		vo = dao.insert(vo);
		insertFuncao(vo);
		insertFuncionalidade(vo);
		return vo;
	}
	
	public void update(PerfilVO vo) throws AmbienteException, AplicacaoException{
		dao.update(vo);
		removeFuncao(vo);
		removeFuncionalidade(vo);
		insertFuncao(vo);
		insertFuncionalidade(vo);
	}
	
	public void remove(PerfilVO vo) throws AmbienteException, AplicacaoException{
		removeFuncao(vo);
		removeFuncionalidade(vo);
		dao.remove(vo);
	}
	
	public PerfilVO findByPrimaryKey(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(PerfilVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByFilter(vo);
	}
	
	public Collection findAll() throws AmbienteException, AplicacaoException{
		return dao.findAll();
	}
	
	public void insertFuncao(PerfilVO vo) throws AmbienteException, AplicacaoException{
		Collection collFuncao = vo.getFuncoes();
		if (collFuncao != null){
			Iterator iterator = collFuncao.iterator();
			while(iterator.hasNext()){
				FuncaoVO funcao = (FuncaoVO)iterator.next();
				
			}
		}
	}
	
	public void insertFuncionalidade(PerfilVO vo) throws AmbienteException, AplicacaoException{
		Collection collFuncionalidade = vo.getFuncionalidades();
		if (collFuncionalidade != null && collFuncionalidade.size() > 0){
			Iterator iterator = collFuncionalidade.iterator();
			while(iterator.hasNext()){
				FuncionalidadeVO funcionalidade = (FuncionalidadeVO)iterator.next();
				dao.insertFuncionalidade(vo, funcionalidade);
			}
		}
	}
	
	public void removeFuncao(PerfilVO vo) throws AmbienteException, AplicacaoException{
		Collection collFuncao = vo.getFuncoes();
		if (collFuncao != null){
			Iterator iterator = collFuncao.iterator();
			while(iterator.hasNext()){
				FuncaoVO funcao = (FuncaoVO)iterator.next();
				
			}
		}
	}
	
	public void removeFuncionalidade(PerfilVO vo) throws AmbienteException, AplicacaoException{
		dao.removeFuncionalidade(vo);
	}
}
