<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/tags/c" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<f:view>
	<f:loadBundle basename="seguranca" var="properties" />
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title><h:outputText value="#{properties['lb_linkConsulta']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function voltar(){
					window.location.href="<c:url value="/seguranca/linkConsulta.jsf"/>";
					return false;
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
			</script>
			<script src="<c:url value="/nucleo/js/seguranca.js" />" language="javascript"></script>
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="LinkForm">
				<table width="100%">
					<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
					<tr>
						<td valign="top">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<table class="box" cellpadding="1" cellspacing="1" border="0">
								<tr><td class="titulo" colspan="2" background="<c:url value="/nucleo/images/box-header-bg.gif"/>"><h:outputText value="#{properties['lb_linkForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<t:panelGrid columns="2" width="50%" >
											<t:outputLabel value="#{properties['lb_url']}" styleClass="texto" for="url"/>: 
											<h:inputText id="url" value="#{LinkBean.link.url}" size="50"/>
								
											<t:outputLabel value="#{properties['lb_descricao']}" styleClass="texto" for="descricao"/>: 
											<h:inputText id="descricao" value="#{LinkBean.link.descricao}" size="50"/>
											
											<t:outputLabel value="#{properties['lb_tipo']}" styleClass="texto" for="tipo"/>: 
											<h:selectOneRadio value="#{LinkBean.link.tipo}" styleClass="texto">
												<f:selectItem itemValue="i" itemLabel="#{properties['lb_interno']}" />
												<f:selectItem itemValue="e" itemLabel="#{properties['lb_externo']}" />
											</h:selectOneRadio>
										</t:panelGrid>
										<br>
										<t:panelGroup>
											<h:commandButton value="#{properties['lb_salvar']}" action="#{LinkBean.salvar}" onclick="setAcao(document.forms[0], 'Salva_Link');"/>
											<h:outputText value="  " />
											<h:commandButton value="#{properties['lb_voltar']}" type="button" onclick="voltar();"/>
										</t:panelGroup>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<h:inputHidden id="codigo" value="#{LinkBean.link.codigo}"/>
			</h:form>
		</body>
	</html>
</f:view>