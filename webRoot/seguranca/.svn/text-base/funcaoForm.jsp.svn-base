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
			<title><h:outputText value="#{properties['lb_funcaoForm']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function voltar(){
					window.location.href="<c:url value="/seguranca/funcaoConsulta.jsf"/>";
					return false;
				}
				
				function setLink(url, codigo){
					document.forms[0].elements['FuncaoForm:linkUrl'].value = url;
					document.forms[0].elements['FuncaoForm:linkCodigo'].value = codigo;
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
				
				function popup(url, width, height){
					window.open(url, 'popupSeguranca', 'width=' + width + ',height=' + height + ', resizable=yes,scrollbars=yes');
				}
			</script>
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="FuncaoForm">
				<table>
					<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
					<tr>
						<td valign="top">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<table class="box">
								<tr><td class="tituloBox" colspan="2" align="center"><h:outputText value="#{properties['lb_funcaoForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<table>
											<tr>
												<td>
													<h:outputText value="#{properties['lb_nome']}" styleClass="texto"/>
												</td>
												<td>
													<h:inputText id="nome" value="#{FuncaoBean.funcao.nome}" required="true" size="50"/>
												</td>
											</tr>
											<tr>
												<td>
													<h:outputText value="#{properties['lb_descricao']}" styleClass="texto" />
												</td>
												<td>
													<h:inputText id="descricao" value="#{FuncaoBean.funcao.descricao}" required="true" size="50"/>
												</td>
											</tr>
											<tr>
												<td>
													<h:outputText value="#{properties['lb_link']}" styleClass="texto" />
												</td>
												<td>
													<t:inputText id="linkUrl" value="#{FuncaoBean.funcao.link.url}" size="50" readonly="true"/>&nbsp;
													<h:outputLink value="#" onclick="popup('linkPopup.jsf', '600', '500')" >
														<h:graphicImage value="../nucleo/images/lupa.gif"/>
													</h:outputLink>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<h:commandButton value="#{properties['lb_salvar']}" action="#{FuncaoBean.salvar}" onclick="setAcao(document.forms[0], 'Salva_Funcao');"/>
													&nbsp;
													<h:commandButton value="#{properties['lb_voltar']}" type="button" onclick="voltar();"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<h:inputHidden id="codigo" value="#{FuncaoBean.funcao.codigo}"/>
				<h:inputHidden id="linkCodigo" value="#{FuncaoBean.funcao.link.codigo}"/>
				<input type="hidden" name="acaoSeguranca" value=""/>
			</h:form>
		</body>
	</html>
</f:view>