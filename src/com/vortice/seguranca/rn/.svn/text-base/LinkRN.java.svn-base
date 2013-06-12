package com.vortice.seguranca.rn;

import java.util.Collection;

import com.vortice.exception.AmbienteException;
import com.vortice.exception.AplicacaoException;
import com.vortice.seguranca.abstracao.rn.MensAplicacao;
import com.vortice.seguranca.abstracao.rn.SegurancaRegraNegocio;
import com.vortice.seguranca.dao.LinkDAOIf;
import com.vortice.seguranca.vo.LinkVO;

public class LinkRN extends SegurancaRegraNegocio {
	
	private LinkDAOIf dao;
	
	public LinkRN() throws AmbienteException{
		dao = getFabrica().getLinkDAOIf();
	}
	
	public void regra(LinkVO vo) throws AplicacaoException{
		if (vo.getUrl() == null) throw new AplicacaoException(MensAplicacao.URL_NULL);
		if (vo.getTipo() == null){
			vo.setTipo(new Character('l'));
		}
	}
	
	public void regraInsert(LinkVO vo) throws AplicacaoException{
		regra(vo);
	}
	
	public void regraUpdate(LinkVO vo) throws AplicacaoException{
		regra(vo);
	}
	
	public LinkVO insert(LinkVO vo) throws AmbienteException, AplicacaoException{
		regraInsert(vo);
		return dao.insert(vo);
	}
	
	public void update(LinkVO vo) throws AmbienteException, AplicacaoException{
		regraUpdate(vo);
		dao.update(vo);
	}
	
	public void remove(LinkVO vo) throws AmbienteException, AplicacaoException{
		dao.remove(vo);
	}
	
	public LinkVO findByPrimaryKey(LinkVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByPrimaryKey(vo);
	}
	
	public Collection findByFilter(LinkVO vo) throws AmbienteException, AplicacaoException{
		return dao.findByFilter(vo);
	}
}
