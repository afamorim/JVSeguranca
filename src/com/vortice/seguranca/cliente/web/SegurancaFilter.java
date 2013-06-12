package com.vortice.seguranca.cliente.web;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vortice.seguranca.SegurancaIf;
import com.vortice.seguranca.abstracao.cliente.SegurancaDelegateIf;
import com.vortice.seguranca.abstracao.cliente.bean.SegurancaPageBean;
import com.vortice.seguranca.vo.FuncaoVO;
import com.vortice.seguranca.vo.FuncionalidadeVO;
import com.vortice.seguranca.vo.LinkVO;
import com.vortice.seguranca.vo.UsuarioVO;

public class SegurancaFilter implements Filter {

	private String 				loginPage;
	private String 				indexPage;
	private String 				desenv;
	private String				urlLivre;
    private ServletContext 		context = null;
    private SegurancaDelegateIf delegate;
    
    private static Logger log = Logger.getLogger(SegurancaFilter.class);
	
	public void destroy() {}
	
	public void init(FilterConfig config) throws ServletException {
		loginPage = config.getServletContext().getInitParameter("LOGIN_PAGE");
		indexPage = config.getServletContext().getInitParameter("INDEX_PAGE");
		desenv = config.getServletContext().getInitParameter("DESENV");
		urlLivre = config.getServletContext().getInitParameter("URLS_LIVRES");
		this.context = config.getServletContext();
		SegurancaPageBean pageBean = new SegurancaPageBean();
		try{
			delegate = pageBean.getDelegate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession sessao = httpRequest.getSession();
		httpRequest.setCharacterEncoding("ISO-8859-1");
		//System.out.println("httpRequest.getServletPath() " + httpRequest.getServletPath());
		//System.out.println("httpRequest.getRequestURL() " + httpRequest.getRequestURL());
		String servletPath = httpRequest.getServletPath();
		if (servletPath.indexOf("?") > 0) servletPath = servletPath.substring(0, servletPath.indexOf("?"));
		
		boolean isUrlLivre = false;
		if (urlLivre != null && !"".equals(urlLivre)){
			String[] urlsLivres = urlLivre.split(";");
			for (int i = 0; i < urlsLivres.length; i++){
				if ((servletPath.indexOf(urlsLivres[i]) >= 0) || servletPath.equals(urlsLivres[i])) isUrlLivre = true; 
			}
		}
		
		String ext = (servletPath.length() >= 3) ? servletPath.substring(servletPath.length()-3, servletPath.length()) : "";
		String login = (servletPath.length() >= 9) ? servletPath.substring(servletPath.length()-9, servletPath.length()) : "";
		String mudarSenha = (servletPath.length() >=14) ? servletPath.substring(servletPath.length()-14, servletPath.length()) : "";
		
		if (!isUrlLivre){
			if (!ext.equals("css") && !ext.equals("gif") && !ext.equals("jpg") && !ext.equals("png") && !ext.equals(".js")){
				if (!login.equals("login.jsf") && !login.equals("login.jsp")){
					if (!mudarSenha.equals("mudarSenha.jsp") && !mudarSenha.equals("mudarSenha.jsf")){
						if (servletPath.indexOf("applet") < 0){//Só filtra se o diretorio passado nao tiver applet
							if(desenv.equals("0")){
								//log.debug("Veio no Filtro de Segurança");
								UsuarioVO usuario = (UsuarioVO)sessao.getAttribute(SegurancaIf.USUARIO_SESSAO);
								
								if (usuario == null)
								{//TESTO SE O USUÁRIO NÃO EXISTE NA SESSÃO
									sessao.setAttribute(SegurancaIf.URL_ACESSADA, servletPath);
					                log.debug("Usuário não esta logado, envia para a pagina de login");
					                log.debug(">>>> sessao.getAttribute(SegurancaIf.URL_ACESSADA) " + sessao.getAttribute(SegurancaIf.URL_ACESSADA));
					                String script = "";
					                script += "<script> \n";
					                script += "  alert('Se logue com seu usuário antes de tentar acessar essa funcionalidade.'); \n";
					                script += "</script> ";
					                request.setAttribute("msgP", script);
					                request.getRequestDispatcher(loginPage).forward(request, response);
					                
								}else{//CASO EXISTA
									if (sessao.getAttribute(SegurancaIf.URL_ACESSADA) != null){
										log.debug(">>>> sessao.getAttribute(SegurancaIf.URL_ACESSADA) " + sessao.getAttribute(SegurancaIf.URL_ACESSADA));
										String urlAcessada = (String)sessao.getAttribute(SegurancaIf.URL_ACESSADA);
										sessao.setAttribute(SegurancaIf.URL_ACESSADA, null);
										request.getRequestDispatcher(urlAcessada).forward(request, response);
									}
									
					                //log.debug("Usuario " + usuario);
					                String acaoSeguranca = request.getParameter("acaoSeguranca");
					                boolean permitiContinuar = false;
					                Collection collFuncionalidadesUsuario = usuario.getFuncionalidades();
				                	Collection collFuncionalidadesPerfil = usuario.getPerfil().getFuncionalidades();
				                	
					                if (acaoSeguranca != null){//SE A ACAO QUE VAI EXECUTAR ESTA NUMA VARIAVEL
					                	log.debug(">> acaoSeguranca Verificada: " + acaoSeguranca);
					                	permitiContinuar = testaFuncionalidadesDescricaoFuncao(collFuncionalidadesPerfil, acaoSeguranca);
					                	if (!permitiContinuar){
					                		permitiContinuar = testaFuncionalidadesDescricaoFuncao(collFuncionalidadesUsuario, acaoSeguranca);
					                		if (!permitiContinuar) proibeContiuacao(request, response);	
					                	}
					                }else{//SE A ACAO QUE VAI EXECUTAR NÃO ESTA NUMA VARIAVEL SETA O LINK COMO A AÇÃO
					                	acaoSeguranca = httpRequest.getServletPath();
					                	log.debug(">> acaoSeguranca Verificada: " + acaoSeguranca);
					                	permitiContinuar = testaFuncionalidadesLinkFuncao(collFuncionalidadesPerfil, acaoSeguranca);
					                	if (!permitiContinuar){
					                		permitiContinuar = testaFuncionalidadesLinkFuncao(collFuncionalidadesUsuario, acaoSeguranca);
					                		if (!permitiContinuar) proibeContiuacao(request, response);			                		
					                	}
					                }
					                
					                if (permitiContinuar) chain.doFilter(request, response);
								}
							} else if (desenv.equals("2")){//O proprio filtro vai salvar o link caso o mesmo não exista na base.
								LinkVO linkVO = new LinkVO(servletPath);
								Collection collLink = null;
								try{
									collLink = delegate.findByFilter(linkVO);
									if (collLink == null || collLink.size() <= 0){
										delegate.insert(linkVO);
									}
								}catch(Exception e){
									e.printStackTrace();
								}
								chain.doFilter(request, response);
							}else{
								UsuarioVO usuario = (UsuarioVO)sessao.getAttribute("usuario");
								if (usuario == null){
									usuario = new UsuarioVO(new Integer(1));
									sessao.setAttribute("usuario", usuario);
								}
								chain.doFilter(request, response);
							}
						}else{
							chain.doFilter(request, response);
						}
					}else{
						chain.doFilter(request, response);
					}
				}else{
					chain.doFilter(request, response);
				}
			}else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}
	
	private boolean testaFuncionalidadesDescricaoFuncao(Collection collFuncionalidades, String acaoSeguranca){
		boolean retorno = false;
		if (collFuncionalidades != null){
			Iterator iteratorFuncionalidades = collFuncionalidades.iterator();
			while (iteratorFuncionalidades.hasNext()){
				FuncionalidadeVO funcionalidade = (FuncionalidadeVO)iteratorFuncionalidades.next();
				retorno =  testaDescricaoFuncao(funcionalidade.getFuncoes(), acaoSeguranca); 
				if (retorno) return retorno;
			}
		}
		return false;
	}
	
	private boolean testaFuncionalidadesLinkFuncao(Collection collFuncionalidades, String acaoSeguranca){
		boolean retorno = false;
		if (collFuncionalidades != null){
			Iterator iteratorFuncionalidades = collFuncionalidades.iterator();
			while (iteratorFuncionalidades.hasNext()){
				FuncionalidadeVO funcionalidade = (FuncionalidadeVO)iteratorFuncionalidades.next();
				retorno = testaLinkFuncao(funcionalidade.getFuncoes(), acaoSeguranca);
				if (retorno) return retorno;
			}
		}
		return false;
	}
	
	private boolean testaDescricaoFuncao(Collection collFuncoes, String acaoSeguranca){
		if (collFuncoes != null){
			Iterator iteratorFuncoes = collFuncoes.iterator();
			while(iteratorFuncoes.hasNext()){
				FuncaoVO funcao = (FuncaoVO)iteratorFuncoes.next();
				if (funcao.getDescricao() != null && funcao.getDescricao().equals(acaoSeguranca)) return true;			
			}
		}
		return false;
	}
	
	private boolean testaLinkFuncao(Collection collFuncoes, String acaoSeguranca){
		if (collFuncoes != null){
			Iterator iteratorFuncoes = collFuncoes.iterator();
			while(iteratorFuncoes.hasNext()){
				FuncaoVO funcao = (FuncaoVO)iteratorFuncoes.next();
				
				if (funcao.getLink() != null && funcao.getLink().getUrl() != null)
					if (funcao.getLink().getUrl().equals(acaoSeguranca)) return true;
			}
		}
		return false;
	}
	
	private void proibeContiuacao(ServletRequest request, ServletResponse response) throws ServletException, IOException{
		StringBuffer script = new StringBuffer();
        script.append("<script> \n");
        script.append("  alert('Voce nao tem permissao para executar esta funcao.'); \n");
        script.append("</script> ");
        request.setAttribute("msgP", script.toString());
        request.getRequestDispatcher(indexPage).forward(request, response);
	}
}