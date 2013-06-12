<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
    
<f:view>
	<f:loadBundle basename="seguranca" var="properties" />
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title><h:outputText value="#{properties['lb_perfilForm']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function voltar(){
					window.location.href="<c:url value="/seguranca/perfilConsulta.jsf"/>";
					return false;
				}
				
				function salva(){
					funcionalidades = document.forms[0].elements['perfilForm:funcionalidades'];
					for (i = 0; i < funcionalidades.options.length; i++){
						funcionalidades.options[i].selected = true;
					}
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
				
				function transfere(origem, destino){
					for(i = 0; i < origem.options.length; i++){
						if (origem.options[i].selected){
							//alert("transfere " + origem.options[i].text + " com o valor " + origem.options[i].value);
							destino.options[destino.options.length] = new Option(origem.options[i].text, origem.options[i].value);
							origem.options[i] = null;
						}
					}
				}
			</script>
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="perfilForm">
				<table width="100%">
					<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
					<tr>
						<td valign="top">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<table class="box">
								<tr><td class="tituloBox" colspan="2" align="center"><h:outputText value="#{properties['lb_perfilForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td><h:outputText value="#{properties['lb_nome']}" styleClass="texto"/></td>
									<td>
										<h:inputText id="nome" value="#{PerfilBean.perfil.nome}" required="true" size="50"/>
									</td>
								</tr>
								<tr>
									<td><h:outputText value="#{properties['lb_descricao']}" styleClass="texto"/></td>
									<td>
										<h:inputText id="descricao" value="#{PerfilBean.perfil.descricao}" required="true" size="50"/>
									</td>
								</tr>
								<tr >
									<td colspan="2">
										<table border="0" align="left" width="70%">
											<tr><td colspan="3" align="center"><h:outputText value="#{properties['lb_funcionalidades']}" styleClass="texto"/></td></tr>
											<tr>
												<td width="45%" align="center">
													<t:selectManyListbox size="5" id="nfuncionalidades" styleClass="texto" value="">
														<f:selectItems id="sel_nfuncionalidades" value="#{PerfilBean.nfuncionalidades}"/>
													</t:selectManyListbox>
												</td>
												<td width="10%" align="center">
													<h:commandButton value=">>" type="button" onclick="transfere(document.forms[0].elements['perfilForm:nfuncionalidades'], document.forms[0].elements['perfilForm:funcionalidades']);"/><br><br>
													<h:commandButton value="<<" type="button" onclick="transfere(document.forms[0].elements['perfilForm:funcionalidades'], document.forms[0].elements['perfilForm:nfuncionalidades']);"/>
												</td>
												<td width="45%" align="center">
													<t:selectManyListbox size="5" id="funcionalidades"  styleClass="texto" value="" validator="#{PerfilBean.validaFuncao}">
														<f:selectItems id="sel_funcionalidades" value="#{PerfilBean.funcionalidades}"/>
													</t:selectManyListbox>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="2" >
										<h:commandButton value="Salvar" onclick="setAcao(document.forms[0], 'Salva_Perfil'); salva();" action="#{PerfilBean.salvar}" />
										&nbsp;
										<h:commandButton value="#{properties['lb_voltar']}" type="button" onclick="voltar();"/>
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
				<h:inputHidden id="codigo" value="#{PerfilBean.perfil.codigo}"/>
				<input type="hidden" name="acaoSeguranca" value=""/>
			</h:form>
		</body>
	</html>
</f:view>