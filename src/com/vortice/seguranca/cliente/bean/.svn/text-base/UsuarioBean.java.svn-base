package com.vortice.seguranca.cliente.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateFacade;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.bean.SegurancaPageBean;
import com.vortice.seguranca.vo.PerfilVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class UsuarioBean extends SegurancaPageBean {
	
	private UsuarioVO 												usuario;
	private List<PerfilVO>										perfis;
    private transient SegurancaDelegateIf 			delegate;
    private Collection 												usuarios;
    private String 														rsenha;
    private String 														nsenha;
    private transient static Logger							log = Logger.getLogger(UsuarioBean.class); 
    
	
	public UsuarioBean(){
		try{
			delegate =  new SegurancaDelegateFacade();
			usuario = new UsuarioVO();
			usuario.setPerfil(new PerfilVO());
			usuarios = new ArrayList();
			//Collection collPerfil =delegate.findAllPerfil(); 
			//perfis = (collPerfil != null) ? getSelect(collPerfil, "codigo", "nome") : new ArrayList();
			perfis = new ArrayList<PerfilVO>();
			log.debug(delegate);
			perfis.addAll(delegate.findAllPerfil());
			log.debug("Pegou " + perfis.size());
		}catch(Exception e){
			tratarExcecao(e);
		}
	}
	
	public String salvar(){
		try{
			if (getUsuario().getSenha().equals(rsenha)){
				if (getUsuario().getCodigo() != null && getUsuario().getCodigo().intValue() > 0){
					delegate.update(getUsuario());
				}else{
					delegate.insert(getUsuario());
				}
				FacesMessage msgs = new FacesMessage("Registro Salvo com Sucesso.");
				FacesContext.getCurrentInstance().addMessage(null, msgs);
				return this.getSucesso();
			}else{
				String msg = "As senha não podem ser diferentes.";
				FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				FacesContext.getCurrentInstance().addMessage(null, msgs);
				return this.getFalha();
			}
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String consultar(){
		try{
			//getUsuarios().setWrappedData(delegate.findByFilter(getUsuario()));
			setUsuarios(delegate.findByFilter(getUsuario()));
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			delegate.remove(getUsuario());
			this.consultar();
			FacesMessage msgs = new FacesMessage("Registro Removido com Sucesso.");
			FacesContext.getCurrentInstance().addMessage(null, msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}

	public String carregar(){
		try{
			setUsuario(delegate.findByPrimaryKey(getUsuario()));
			setRsenha(getUsuario().getSenha());
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String logar(){
		try{
			
			log.debug("Logins: " + getUsuario().getLogin());
			log.debug("Senhas: " + getUsuario().getSenha());
			UsuarioVO vo = delegate.autenticar(getUsuario());
			log.debug("usuario " + vo);
			setUsuario(vo);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
			session.setAttribute("usuario", getUsuario());
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public String mudarSenha(){
		try{
			UsuarioVO vo = delegate.autenticar(getUsuario());
			setUsuario(vo);
			if (nsenha.equals(rsenha)){
				usuario.setSenha(nsenha);
				delegate.update(usuario);
			}else{
				String msg = "A foram digitadas senhas diferentes";
				FacesMessage msgs = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
				FacesContext.getCurrentInstance().addMessage("mLogin", msgs);
				return getFalha();
			}
			FacesMessage msgs = new FacesMessage("A senha foi modificada com sucesso.");
			FacesContext.getCurrentInstance().addMessage("mLogin", msgs);
			return getSucesso();
		}catch(Exception e){
			return tratarExcecao(e);
		}
	}
	
	public void scrollerAction(ActionEvent event){
    }
	
	public final UsuarioVO getUsuario() {
		return usuario;
	}

	public final void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public String getRsenha() {
		return rsenha;
	}

	public void setRsenha(String rsenha) {
		this.rsenha = rsenha;
	}

	public String getNsenha() {
		return nsenha;
	}

	public void setNsenha(String nsenha) {
		this.nsenha = nsenha;
	}

	public Collection getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection usuarios) {
		this.usuarios = usuarios;
	}

	public List<PerfilVO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilVO> perfis) {
		this.perfis = perfis;
	}

	
	
}