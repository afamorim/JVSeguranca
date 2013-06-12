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
			<title><h:outputText value="#{properties['lb_linkConsulta']}"/></title>
			<link href="../nucleo/style/seguranca.css" type=text/css rel=StyleSheet>
			<script>
				function novo(){
					window.location.href="<c:url value="/seguranca/linkForm.jsf"/>";
					return false;
				}
				
				function limpar(){
					document.forms[0].elements['LinkConsulta:url'].value="";
					document.forms[0].elements['LinkConsulta:descricao'].value="";
				}
				
				function setAcao(form, acao){
					form.acaoSeguranca.value = acao;
					alert
				}
				function teste(codigo){
					alert('veio com o codigo ' + codigo);
					document.forms[1].elements['LinkResultado:codigo'].value = codigo;
				}
			</script>
			
		</head>
		<body bgcolor="#FFFFFF">
				<table width="100%" >
					<tr><td colspan="2" class="titulo">Sistema de Seguranca<br><br></td></tr>
					<tr>
						<td valign="top" width="100">
							<%@ include file="/nucleo/includes/inc_menu.html" %>
						</td>
						<td valign="top">
							<table class="box">
								<tr><td class="tituloBox" colspan="2"><h:outputText value="#{properties['lb_linkConsulta']}"/></td></tr>
								<tr><td colspan="2" align="center"><t:messages id="msgs" showDetail="true" showSummary="false" errorClass="textoMsgErro" infoClass="textoMsgInfo"/></td></tr>
								<tr>
									<td colspan="2" width="100%">
										<h:form id="LinkConsulta">
											<t:panelGrid columns="2" width="50%" >
												<t:outputLabel value="#{properties['lb_url']}:" styleClass="texto" for="url"/>
												<h:inputText id="url" value="#{LinkBean.link.url}" size="50" />
												
												<t:outputLabel value="#{properties['lb_descricao']}:" styleClass="texto" for="descricao"/>
												<h:inputText id="descricao" value="#{LinkBean.link.descricao}" size="50" />
											</t:panelGrid>
											
											<t:panelGroup>
												<h:commandButton value="#{properties['lb_consultar']}" action="#{LinkBean.consultar}" onclick="setAcao(this.form, 'Consulta_Links');"/>
												<h:outputText value="  " />
												<h:commandButton value="#{properties['lb_novo']}" onclick="novo();" type="button"/>
												<h:outputText value="  " />
												<h:commandButton value="#{properties['lb_reset']}" type="button" onclick="limpar();"/>
											</t:panelGroup>
											
											<input type="hidden" name="acaoSeguranca" value=""/>
											
										
									</td>
								</tr>
							</table><br><br>
							<table class="box">
								<tr><td colspan="2" class="tituloBox"><h:outputText value="#{properties['lb_resultPesqLink']}"/></td></tr>
								<tr>
									<td colspan="2">
										
											<t:saveState value="#{LinkBean.links}" />
											<t:saveState value="#{LinkBean.link}" />
											<div style="overflow:auto; width:100%; height:200px">
											<t:dataTable id="data" headerClass="titulo" footerClass="rodape" 
								                rowClasses="texto, texto, texto, texto"
								                columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
								                var="links" cellspacing="1" cellpadding="0" width="100%"
								                value="#{LinkBean.links}" preserveDataModel="false" rows="10" rowId="#{links.codigo}">

												<t:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_url']}" />
													</f:facet>
													<h:outputText value="#{links.url}" />
												</t:column>
									
												<t:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_descricao']}" />
													</f:facet>
													<h:outputText value="#{links.descricao}" />
												</t:column>
												
												<t:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_editar']}" />
													</f:facet>
													
													<t:commandLink action="#{LinkBean.carregar}" title="#{properties['lb_editar']}" id="editar" immediate="true" onclick="setAcao(document.forms[0], 'Carrega_Links');">
														<t:updateActionListener property="#{LinkBean.link.codigo}" value="#{links.codigo}" />
														<t:graphicImage align="center" value="/nucleo/images/editar.gif" border="0"/>
													</t:commandLink>
													
												</t:column>
												
												<t:column>
													<f:facet name="header">
														<h:outputText value="#{properties['lb_excluir']}" />
													</f:facet>
													
													<t:commandLink action="#{LinkBean.remover}" title="#{properties['lb_remover']}" id="remover" immediate="true" onclick="setAcao(document.forms[0], 'Remove_Links');">
														<t:updateActionListener property="#{LinkBean.link.codigo}" value="#{links.codigo}" />
														<t:graphicImage align="center" value="/nucleo/images/delete.gif" border="0"/>
													</t:commandLink>
												</t:column>	
											</t:dataTable>
											</div>
											
											<h:panelGrid columns="1" columnClasses="conteudoCentralizado" align="center">
									            <t:dataScroller id="scroll_1" for="data" fastStep="10"
									                    pageCountVar="pageCount" pageIndexVar="pageIndex"
									                    styleClass="scroller" paginator="true"
									                    paginatorMaxPages="9" paginatorTableClass="paginator"
									                    paginatorActiveColumnStyle="font-weight:bold;" actionListener="#{LinkBean.scrollerAction}">
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
									        
										</h:form>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
		</body>
	</html>
</f:view>