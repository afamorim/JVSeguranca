<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
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
			<title><h:outputText value="#{properties['lb_loginForm']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<c:if test="${not empty requestScope.msg}">
				${requestScope.msg}
			</c:if>
			${sessionScope.script}
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="usuarioForm">
				<table width="100%">
					<tr>
						<td valign="top" align="center">
							<table class="box">
								<tr><td class="titulobox" colspan="2" align="center"><h:outputText value="#{properties['lb_loginForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<t:panelGrid columns="2" width="80%" >
											
											<h:outputText value="#{properties['lb_login']}" styleClass="texto"/>
											<h:inputText id="login" value="#{UsuarioBean.usuario.login}" required="true" />
								
											<h:outputText value="#{properties['lb_senha']}" styleClass="texto"/>
											<t:inputSecret id="senha" value="#{UsuarioBean.usuario.senha}" required="true" />

										</t:panelGrid>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<h:commandButton value="#{properties['lb_logar']}" action="#{UsuarioBean.logar}"/>
										&nbsp;
										<h:commandButton value="#{properties['lb_reset']}" type="reset" />
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
			</h:form>
		</body>
	</html>
</f:view>