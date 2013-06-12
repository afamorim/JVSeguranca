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
			<title><h:outputText value="#{properties['lb_funcionalidadeConsulta']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function novo(){
					window.location.href="<c:url value="/seguranca/funcionalidadeForm.jsf"/>";
					return false;
				}
				
				function limpar(){
					document.forms[0].elements['funcionalidadeForm:Nome'].value = "";
					document.forms[0].elements['funcionalidadeForm:Descricao'].value = "";
					document.forms[0].elements['funcionalidadeForm:Funcoes'].value = "";
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
			</script>
			<script src="<c:url value="/nucleo/js/seguranca.js" />" language="javascript"></script>
		</head>
		<body bgcolor="#FFFFFF">
			<table width="100%">
				<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
				<tr>
					<td valign="top">
						<%@ include file="/nucleo/includes/inc_menu.html" %>
					</td>
					<td valign="top">
						<h:form id="funcionalidadeForm">
							<table class="box">
								<tr><td class="titulobox" colspan="2"><h:outputText value="#{properties['lb_funcionalidadeForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<t:panelGrid columns="2" width="50%" >
											<h:outputText value="#{properties['lb_nome']}" styleClass="texto"/>
											<h:inputText id="Nome" value="#{FuncionalidadeBean.funcionalidade.nome}" size="50"/>
											
											<h:outputText value="#{properties['lb_descricao']}" styleClass="texto"/>
											<h:inputText id="Descricao" value="#{FuncionalidadeBean.funcionalidade.descricao}" size="50"/>
											
											<h:outputText value="#{properties['lb_funcao']}" styleClass="texto"/>
											<h:selectOneMenu id="Funcoes" value="" style="width:290" >
												<f:selectItem itemLabel="#{properties['lb_selecione']}" itemValue=""/>
												<f:selectItems id="sel_nfuncoes" value="#{FuncionalidadeBean.nfuncoes}"/>
											</h:selectOneMenu>
										</t:panelGrid>
										
										<t:panelGroup>
											<h:commandButton value="#{properties['lb_consultar']}" action="#{FuncionalidadeBean.consultar}" onclick="setAcao(document.forms[0], 'Consulta_Funcionalidade');"/>
											<h:outputText value="  " />
											<h:commandButton value="#{properties['lb_novo']}" type="button" onclick="novo();"/>
											<h:outputText value="  " />
											<h:commandButton value="#{properties['lb_reset']}" type="button" onclick="limpar();"/>
										</t:panelGroup>
									</td>
								</tr>
							</table><br><br>
							<input type="hidden" name="acaoSeguranca" value=""/>
						</h:form>
						<h:form id="funcionalidadeConsulta">
							<table class="box">
								<tr>
									<td colspan="2" class="tituloBox"><h:outputText value="#{properties['lb_resultPesqFuncionalidades']}"/></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<t:saveState value="#{FuncionalidadeBean.funcionalidades}" />
										<t:saveState value="#{FuncionalidadeBean.funcionalidade}" />
										<div style="overflow:auto; width:100%; height:200px">
										<t:dataTable id="data" headerClass="titulo" footerClass="rodape" width="100%"
							                rowClasses="texto, texto, texto, texto" cellspacing="1" cellpadding="0" 
							                columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
											var="funcionalidades" value="#{FuncionalidadeBean.funcionalidades}" 
											preserveDataModel="false" rows="10" rowId="#{funcionalidades.codigo}">
	
											<h:column>
												<f:facet name="header">
													<h:outputText value="#{properties['lb_nome']}" />
												</f:facet>
												<h:outputText value="#{funcionalidades.nome}" />
											</h:column>
								
											<h:column>
												<f:facet name="header">
													<h:outputText value="#{properties['lb_descricao']}" />
												</f:facet>
												<h:outputText value="#{funcionalidades.descricao}" />
											</h:column>
								
											<h:column>
												<f:facet name="header">
													<h:outputText value="#{properties['lb_editar']}" />
												</f:facet>
												
												<t:commandLink action="#{FuncionalidadeBean.carregar}" title="#{properties['lb_editar']}" id="editar" immediate="true" onclick="setAcao(document.forms[0], 'Carrega_Funcionalidade');">
													<t:updateActionListener property="#{FuncionalidadeBean.funcionalidade.codigo}" value="#{funcionalidades.codigo}" />
													<t:graphicImage align="center" value="/nucleo/images/editar.gif" border="0"/>
												</t:commandLink>
											</h:column>
												
											<h:column>
												<f:facet name="header">
													<h:outputText value="#{properties['lb_excluir']}" />
												</f:facet>
												
												<t:commandLink action="#{FuncionalidadeBean.remover}" title="#{properties['lb_remover']}" immediate="true" id="remover" onclick="setAcao(document.forms[0], 'Remove_Funcionalidade');">
													<t:updateActionListener property="#{FuncionalidadeBean.funcionalidade.codigo}" value="#{funcionalidades.codigo}" />
													<t:graphicImage align="center" value="/nucleo/images/delete.gif" border="0"/>
												</t:commandLink>
											</h:column>
										</t:dataTable>
										</div>
										
										<h:panelGrid columns="1" columnClasses="conteudoCentralizado" align="center">
								            <t:dataScroller id="scroll_1" for="data" fastStep="10"
								                    pageCountVar="pageCount" pageIndexVar="pageIndex"
								                    styleClass="scroller" paginator="true"
								                    paginatorMaxPages="9" paginatorTableClass="paginator"
								                    paginatorActiveColumnStyle="font-weight:bold;" actionListener="#{FuncionalidadeBean.scrollerAction}">
								                <f:facet name="first" >
								                    <t:graphicImage url="/nucleo/images/arrow-first.gif" border="1" />
								                </f:facet>
								                <f:facet name="last">
								                    <t:graphicImage url="/nucleo/images/arrow-last.gif" border="1" />
								                </f:facet>
								                <f:facet name="previous">
								                    <t:graphicImage url="/nucleo/images/arrow-previous.gif" border="1" />
								                </f:facet>
								                <f:facet name="next">
								                    <t:graphicImage url="/nucleo/images/arrow-next.gif" border="1" />
								                </f:facet>
								                <f:facet name="fastforward">
								                    <t:graphicImage url="/nucleo/images/arrow-ff.gif" border="1" />
								                </f:facet>
								                <f:facet name="fastrewind">
								                    <t:graphicImage url="/nucleo/images/arrow-fr.gif" border="1" />
								                </f:facet>
								            </t:dataScroller>
								        </h:panelGrid>
									</td>
								</tr>
							</table>
						</h:form>
					</td>
				</tr>
			</table>
		</body>
	</html>
</f:view>