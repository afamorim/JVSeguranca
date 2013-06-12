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
				function novo(){
					window.location.href="<c:url value="/seguranca/funcaoForm.jsf"/>";
					return false;
				}
				
				function setLink(url, codigo){
					document.forms[0].elements[2].value = url;
					document.forms[0].elements[3].value = codigo;
				}
				
				function limpar(){
					document.forms[0].elements['FuncaoConsulta:nome'].value = "";
					document.forms[0].elements['FuncaoConsulta:descricao'].value = "";
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
			</script>
			
		</head>
		<body bgcolor="#FFFFFF">
			<table width="100%">
				<tr><td colspan="2" class="titulo">Sistema de Seguranca</td></tr>
				<tr>
					<td valign="top">
						<%@ include file="/nucleo/includes/inc_menu.html" %>
					</td>
					<td valign="top">
						<h:form id="FuncaoConsulta">
							<table class="box">
								<tr><td class="tituloBox" colspan="2" align="center"><h:outputText value="#{properties['lb_funcaoForm']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2">
										<table>
											<tr>
												<td>
													<t:outputLabel value="#{properties['lb_nome']}" styleClass="texto" for="nome"/>
												</td>
												<td>
													<h:inputText id="nome" value="#{FuncaoBean.funcao.nome}" size="50"/>
												</td>
											</tr>
											<tr>
												<td>
													<t:outputLabel value="#{properties['lb_descricao']}" styleClass="texto" for="descricao"/>
												</td>
												<td>
													<h:inputText id="descricao" value="#{FuncaoBean.funcao.descricao}" size="50"/>
												</td>
											</tr>
											
											<tr>
												<td colspan="2">
													<h:commandButton value="#{properties['lb_consultar']}" action="#{FuncaoBean.consultar}" onclick="setAcao(document.forms[0], 'Consulta_Funcao');"/>
													&nbsp;
													<h:commandButton value="#{properties['lb_novo']}" type="button" onclick="novo();"/>
													&nbsp;
													<h:commandButton value="#{properties['lb_reset']}" type="button" onclick="limpar();"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table><br><br>
							<input type="hidden" name="acaoSeguranca" value=""/>
						</h:form>
						<h:form id="FuncaoREsultado">
						<table class="box">
							<tr>
								<td colspan="2" class="tituloBox"><h:outputText value="#{properties['lb_resultPesqFuncoes']}"/></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<t:saveState value="#{FuncaoBean.funcoes}" />
									<t:saveState value="#{FuncaoBean.funcao}" />
									<div style="overflow:auto; width:100%; height:200px">
									<t:dataTable id="data" headerClass="titulo" footerClass="rodape" 
										var="funcoes" value="#{FuncaoBean.funcoes}"
										rowClasses="texto, texto, texto, texto"
										cellspacing="1" cellpadding="0" width="100%"
										preserveDataModel="false" rows="10" rowId="#{funcoes.codigo}">

										<h:column>
											<f:facet name="header">
												<h:outputText value="#{properties['lb_nome']}" />
											</f:facet>
											<h:outputText value="#{funcoes.nome}" />
										</h:column>
							
										<h:column>
											<f:facet name="header">
												<h:outputText value="#{properties['lb_descricao']}" />
											</f:facet>
											<h:outputText value="#{funcoes.descricao}" />
										</h:column>
							
										<h:column>
											<f:facet name="header">
												<h:outputText value="#{properties['lb_editar']}" />
											</f:facet>
											
											<t:commandLink action="#{FuncaoBean.carregar}" title="#{properties['lb_editar']}" id="editar" immediate="true" onclick="setAcao(document.forms[0], 'Carrega_Funcao');">
												<t:updateActionListener property="#{FuncaoBean.funcao.codigo}" value="#{funcoes.codigo}" />
												<t:graphicImage align="center" value="/nucleo/images/editar.gif" border="0"/>
											</t:commandLink>
										</h:column>
											
										<h:column>
											<f:facet name="header">
												<h:outputText value="#{properties['lb_excluir']}" />
											</f:facet>
											
											<t:commandLink action="#{FuncaoBean.remover}" title="#{properties['lb_remover']}" immediate="true" id="remover" onclick="setAcao(document.forms[0], 'Remove_Funcao');">
												<t:updateActionListener property="#{FuncaoBean.funcao.codigo}" value="#{funcoes.codigo}" />
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
							                    paginatorActiveColumnStyle="font-weight:bold;" actionListener="#{FuncaoBean.scrollerAction}">
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