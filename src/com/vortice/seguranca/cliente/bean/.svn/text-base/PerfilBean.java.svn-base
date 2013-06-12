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

import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.bean.SegurancaPageBean;
import com.vortice.seguranca.vo.PerfilVO;

public class PerfilBean extends SegurancaPageBean {
	
	private PerfilVO 											perfil;
	private transient SegurancaDelegateIf	delegate;
	private Collection 										perfis;
	private List 													funcionalidades;
	private List													nfuncionalidades; 
	
	public PerfilBean(){
		try{
			delegate = new SegurancaDelegateFacade();
			perfis = new ArrayList();
			perfil = new PerfilVO();
			funcionalidades = new ArrayList();
			nfuncionalidades = (delegate.findFuncionalidadeAll() != null && delegate.findFuncionalidadeAll().size() > 0) ? getSelect(delegate.findFuncionalidadeAll(), "codigo", "nome") : new ArrayList();
			this.consultar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String salvar(){
		try{
			
			Collection collFuncionalidade = null;
			if (funcionalidades != null && funcionalidades.size() > 0)
				collFuncionalidade = extractSelect(funcionalidades, "com.vortice.seguranca.vo.FuncionalidadeVO", "codigo", "nome");
			perfil.setFuncionalidades(collFuncionalidade);
			if (getPerfil().getCodigo() != null && getPerfil().getCodigo().intValue() > 0){
				delegate.update(getPerfil());
			}else{
				delegate.insert(getPerfil());
			}
			FacesMessage msgs = new FacesMessage("Registro Salvo com sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String consultar(){
		try{
			setPerfis(delegate.findByFilter(getPerfil())); 
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			delegate.remove(getPerfil());
			FacesMessage msgs = new FacesMessage("Registro Removido com Sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String carregar(){
		try{
			setPerfil(delegate.findByPrimaryKey(getPerfil()));
			funcionalidades = getSelect(delegate.findFuncionalidadeByPerfil(getPerfil()), "codigo", "nome");
			nfuncionalidades = getSelect(delegate.findFuncionalidadeByNPerfil(getPerfil()), "codigo", "nome");
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public void scrollerAction(ActionEvent event){
    }

	public final PerfilVO getPerfil() {
		return perfil;
	}

	public final void setPerfil(PerfilVO perfil) {
		this.perfil = perfil;
	}

	public List getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public List getNfuncionalidades() {
		return nfuncionalidades;
	}

	public void setNfuncionalidades(List nfuncionalidades) {
		this.nfuncionalidades = nfuncionalidades;
	}
	
	public void validaFuncao(FacesContext context, UIComponent component, Object value)  throws ValidatorException{
		funcionalidades = new ArrayList();
		String[] s = (String[])value;
		for (int i = 0; i < s.length; i++){
			funcionalidades.add(new SelectItem(s[i], "", null));
		}
	}

	public Collection getPerfis() {
		return perfis;
	}

	public void setPerfis(Collection perfis) {
		this.perfis = perfis;
	}
	
}