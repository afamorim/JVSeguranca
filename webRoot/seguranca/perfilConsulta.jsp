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
			<title><h:outputText value="#{properties['lb_perfilConsulta']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function novo(){
					window.location.href="<c:url value="/seguranca/perfilForm.jsf"/>";
					return false;
				}
				
				function limpar(){
					document.forms[0].elements['PerfilConsulta:nome'].value = "";
					document.forms[0].elements['PerfilConsulta:descricao'].value = "";
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
				}
			</script>
		</head>
		<body bgcolor="#FFFFFF">
				<table width="100%" >
					<tr><td colspan="2" class="titulo"><h:outputText value="#{properties['lb_titulo']}"/></td></tr>
					<tr>
						<td valign="top" width="100">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<h:form id="PerfilConsulta">
								<table class="box">
									<tr><td class="titulobox" colspan="2"><h:outputText value="#{properties['lb_perfilConsulta']}"/></td></tr>
									<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
									<tr>
										<td colspan="2" width="100%">
											<t:panelGrid columns="2" width="50%" >
												<t:outputLabel value="#{properties['lb_nome']}:" styleClass="texto" for="nome"/>
												<h:inputText id="nome" value="#{PerfilBean.perfil.nome}" size="50"/>
												
												<t:outputLabel value="#{properties['lb_descricao']}:" styleClass="texto" for="descricao"/>
												<h:inputText id="descricao" value="#{PerfilBean.perfil.descricao}" size="50"/>
											</t:panelGrid>
											
											<t:panelGroup>
												<h:commandButton value="#{properties['lb_consultar']}" action="#{PerfilBean.consultar}" onclick="setAcao(document.forms[0], 'Consulta_Perfil');"/>
												<h:outputText value="  " />
												<h:commandButton value="#{properties['lb_novo']}" onclick="novo();" type="button"/>
												<h:outputText value="  " />
												<h:commandButton value="#{properties['lb_reset']}" type="button" onclick="limpar();"/>
											</t:panelGroup>
										</td>
									</tr>
								</table><br><br>
								<input type="hidden" name="acaoSeguranca" value=""/>
							</h:form>
							<h:form id="PerfilResultado">
								<table class="box">
									<tr><td class="tituloBox"><h:outputText value="#{properties['lb_resultPesqPerfil']}"/></td></tr>
									<tr>
										<td colspan="2">
											<t:saveState value="#{PerfilBean.perfis}" />
											<t:saveState value="#{PerfilBean.perfil}" />
											<div style="overflow:auto; width:100%; height:200px">
											<t:dataTable id="data" styleClass="standardTable" headerClass="titulo"
								                footerClass="titulo"
								                rowClasses="texto, texto, texto, texto"
								                columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
								                var="perfis" cellspacing="1" cellpadding="2" width="100%"
								                value="#{PerfilBean.perfis}"
								                preserveDataModel="false" rows="10" rowId="#{perfis.codigo}">
								                
												<h:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_nome']}" />
													</f:facet>
													<h:outputText value="#{perfis.nome}" />
												</h:column>
									
												<h:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_descricao']}" />
													</f:facet>
													<h:outputText value="#{perfis.descricao}" />
												</h:column>
												
												<h:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_editar']}" />
													</f:facet>
													
													<t:commandLink action="#{PerfilBean.carregar}" title="#{properties['lb_editar']}" id="editar" immediate="true" onclick="setAcao(document.forms[0], 'Carrega_Perfil');">
														<t:updateActionListener property="#{PerfilBean.perfil.codigo}" value="#{perfis.codigo}" />
														<t:graphicImage align="center" value="/nucleo/images/editar.gif" border="0"/>
													</t:commandLink>
													
												</h:column>
												
												<h:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_excluir']}" />
													</f:facet>
													
													<t:commandLink action="#{PerfilBean.remover}" title="#{properties['lb_remover']}" immediate="true" onclick="setAcao(document.forms[0], 'Remove_Perfil');">
														<t:updateActionListener property="#{PerfilBean.perfil.codigo}" value="#{perfis.codigo}" />
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
									                    paginatorActiveColumnStyle="font-weight:bold;" actionListener="#{PerfilBean.scrollerAction}">
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