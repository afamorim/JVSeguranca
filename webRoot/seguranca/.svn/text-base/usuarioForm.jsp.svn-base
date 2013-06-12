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
			<title><h:outputText value="#{properties['lb_usuarioForm']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function voltar(){
					window.location.href="<c:url value="/seguranca/usuarioConsulta.jsf"/>";
					return false;
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
			</script>
			<script src="<c:url value="/nucleo/js/seguranca.js" />" language="javascript"></script>
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="usuarioForm">
				<table width="100%">
					<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
					<tr>
						<td valign="top">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<table class="box">
								<tr><td class="titulobox" colspan="2" align="center"><h:outputText value="#{properties['lb_usuarioForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<t:panelGrid columns="2" width="80%" >
											
											<h:outputLabel for="nome" value="#{properties['lb_nome']}" styleClass="texto"/>
											<h:inputText id="nome" value="#{UsuarioBean.usuario.nome}" required="true" size="50"/>
											
											<h:outputLabel for="login" value="#{properties['lb_login']}" styleClass="texto"/>
											<h:inputText id="login" value="#{UsuarioBean.usuario.login}" required="true" size="50"/>
								
											<h:outputLabel for="senha" value="#{properties['lb_senha']}" styleClass="texto"/>
											<t:inputSecret id="senha" value="#{UsuarioBean.usuario.senha}" required="true" size="50"/>
											
											<h:outputLabel for="rsenha" value="#{properties['lb_rsenha']}" styleClass="texto"/>
											<t:inputSecret id="rsenha" value="#{UsuarioBean.rsenha}" required="true" size="50" />
								
											<h:outputLabel for="perfis" value="#{properties['lb_perfil']}" styleClass="texto"/>
											<h:selectOneMenu id="perfis" value="#{UsuarioBean.usuario.perfil.codigo}" style="width:290" required="true">
												<f:selectItem itemLabel="#{properties['lb_selecione']}" itemValue=""/>
												<f:selectItems id="sel_perfis" value="#{UsuarioBean.perfis}"/>
											</h:selectOneMenu>
											
											<h:outputLabel for="ativo" value="#{properties['lb_ativo']}" styleClass="texto"/>
											<t:selectBooleanCheckbox value="#{UsuarioBean.usuario.ativo}" id="ativo"></t:selectBooleanCheckbox>
										</t:panelGrid>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<h:commandButton value="Salvar" action="#{UsuarioBean.salvar}" onclick="setAcao(document.forms[0], 'Salva_Usuario');"/>
										&nbsp;
										<h:commandButton value="#{properties['lb_voltar']}" onclick="voltar();" type="button"/>
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
				<h:inputHidden id="codigo" value="#{UsuarioBean.usuario.codigo}"/>
			</h:form>
		</body>
	</html>
</f:view>