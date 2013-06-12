package com.vortice.seguranca.cliente.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.bean.SegurancaPageBean;
import com.vortice.seguranca.vo.FuncionalidadeVO;

public class FuncionalidadeBean extends SegurancaPageBean {
	
	private FuncionalidadeVO 							funcionalidade;
	private List 													funcoes;
	private List 													nfuncoes; 
	private Collection 										funcionalidades;
	private transient SegurancaDelegateIf	delegate;
	
	public FuncionalidadeBean(){
		try{
			delegate = new SegurancaDelegateFacade();
			funcionalidades = new ArrayList();
			funcionalidade = new FuncionalidadeVO();
			funcionalidade.setFuncoes(new ArrayList());
			Collection collAllfuncao = delegate.findFuncaoAll(); 
			nfuncoes = (collAllfuncao != null && collAllfuncao.size() > 0) ? getSelect(collAllfuncao, "codigo", "nome") : new ArrayList();
			funcoes = new ArrayList();
		}catch(Exception e){
			tratarExcecao(e);
		}
	}
	
	public String salvar(){
		try{
			Collection collFuncao = extractSelect(funcoes, "com.vortice.seguranca.vo.FuncaoVO", "codigo", "nome");
			funcionalidade.setFuncoes(collFuncao);
			if (funcionalidade.getCodigo() != null && funcionalidade.getCodigo().intValue() > 0){
				delegate.update(funcionalidade);
			}else{
				delegate.insert(funcionalidade);
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
			Collection collFuncionalidade = delegate.findByFilter(getFuncionalidade());
			setFuncionalidades(collFuncionalidade);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			delegate.remove(getFuncionalidade());
			FacesMessage msgs = new FacesMessage("Registro Removido com Sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String carregar(){
		try{
			setFuncionalidade(delegate.findByPrimaryKey(getFuncionalidade()));
			nfuncoes = getSelect(delegate.findFuncaoByNFuncionalidade(getFuncionalidade()), "codigo", "nome");
			funcoes = getSelect(delegate.findFuncaoByFuncionalidade(getFuncionalidade()), "codigo", "nome");
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public void scrollerAction(ActionEvent event){
    }

	public List getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List funcoes) {
		this.funcoes = funcoes;
	}

	public List getNfuncoes() {
		return nfuncoes;
		
	}

	public void setNfuncoes(List nfuncoes) {
		this.nfuncoes = nfuncoes;
	}

	public final FuncionalidadeVO getFuncionalidade() {
		return funcionalidade;
	}

	public final void setFuncionalidade(FuncionalidadeVO funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public void validaFuncao(FacesContext context, UIComponent component, Object value)  throws ValidatorException{
		funcoes = new ArrayList();
		String[] s = (String[])value;
		for (int i = 0; i < s.length; i++){
			funcoes.add(new SelectItem(s[i], "", null));
		}
	}

	public Collection getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(Collection funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
}