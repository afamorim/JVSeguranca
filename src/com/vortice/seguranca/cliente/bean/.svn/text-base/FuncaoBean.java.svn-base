package com.vortice.seguranca.cliente.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.bean.SegurancaPageBean;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.LinkVO;

public class FuncaoBean extends SegurancaPageBean {
	
	private transient SegurancaDelegateIf	delegate;
	private Collection 										funcoes;
	private FuncaoVO 										funcao;
	private transient static final Logger 		log = Logger.getLogger(FuncaoBean.class);
	
	public FuncaoBean(){
		try{
			funcoes = new ArrayList();
			delegate = new SegurancaDelegateFacade();
			funcao = new FuncaoVO();
			funcao.setLink(new LinkVO());
		}catch(Exception e){
			tratarExcecao(e);
		}
	}
	
	public String salvar(){
		try{
			if (getFuncao().getCodigo() != null && getFuncao().getCodigo().intValue() > 0){
				delegate.update(getFuncao());
			}else{
				delegate.insert(getFuncao());
			}
			FacesMessage msgs = new FacesMessage("Registro Salvo com Sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String consultar(){
		try{
			Collection collFuncao = delegate.findByFilter(getFuncao());
			log.debug("collFuncao " +collFuncao.size());
			setFuncoes(collFuncao);
			
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			delegate.remove(getFuncao());
			FacesMessage msgs = new FacesMessage("Registro Removido com Sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String carregar(){
		try{
			setFuncao(delegate.findByPrimaryKey(getFuncao()));
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public void scrollerAction(ActionEvent event){
    }

	public final FuncaoVO getFuncao() {
		return funcao;
	}

	public final void setFuncao(FuncaoVO funcao) {
		this.funcao = funcao;
	}

	public Collection getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Collection funcoes) {
		this.funcoes = funcoes;
	}

}