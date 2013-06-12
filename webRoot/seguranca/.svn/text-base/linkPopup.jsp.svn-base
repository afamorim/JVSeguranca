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
			<title><h:outputText value="#{properties['lb_linkForm']}"/></title>
			<link href="<c:url value="/nucleo/style/seguranca.css"/>" type=text/css rel=StyleSheet>
			<script>
				function setLink(url, codigo){
					window.opener.setLink(url, codigo);
					window.close();
				}
			</script>
		</head>
		<body bgcolor="#FFFFFF">
			<h:form id="LinkConsulta">
				<table class="boxPopup" height="200">
					<tr>
						<td class="titulobox" colspan="2">
							<h:outputText value="#{properties['lb_linkForm']}"/>
						</td>
					</tr>
					<tr>
						<td  colspan="2">
							<t:panelGrid columns="2" width="50%" >
								<t:outputLabel value="#{properties['lb_url']}:" styleClass="texto" for="url"/>
								<h:inputText id="url" value="#{LinkBean.link.url}" size="50" />
								
								<t:outputLabel value="#{properties['lb_descricao']}:" styleClass="texto" for="descricao"/>
								<h:inputText id="descricao" value="#{LinkBean.link.descricao}" size="50" />
								
								<t:outputLabel value="#{properties['lb_tipo']}:" styleClass="texto" for="tipo"/>
								<h:selectOneRadio value="#{LinkBean.link.tipo}" styleClass="texto" id="tipo">
									<f:selectItem itemValue="i" itemLabel="#{properties['lb_interno']}" />
									<f:selectItem itemValue="e" itemLabel="#{properties['lb_externo']}" />
								</h:selectOneRadio>
							</t:panelGrid>
							
							<t:panelGroup>
								<h:commandButton value="#{properties['lb_consultar']}" action="#{LinkBean.consultar}"/>
								<h:outputText value="  " />
								<h:commandButton value="#{properties['lb_novo']}" action="#{LinkBean.salvar}"/>
							</t:panelGroup>
						</td>
					</tr>
				</table><br><br>
			</h:form>
			<h:form id="LinkResultado">
				<table class="boxPopup">
					<tr><td colspan="2" class="tituloBox"><h:outputText value="#{properties['lb_resultPesqLink']}"/></td></tr>
					<tr>
						<td colspan="2">
							<t:saveState value="#{LinkBean.links}" />
							<t:saveState value="#{LinkBean.link}" />
							<div style="overflow:auto; width:100%; height:200px">
							<t:dataTable id="dataPopup"
				                headerClass="titulo" footerClass="rodape" 
				                rowClasses="texto, texto, texto, texto"
				                columnClasses="standardTable_Column,standardTable_ColumnCentered,standardTable_Column"
				                var="links" cellspacing="1" cellpadding="0" width="100%"
				                value="#{LinkBean.links}" preserveDataModel="false" rows="10" rowId="#{links.codigo}">
								<h:column>
									<f:facet name="header">
										<h:outputText value="#{properties['lb_url']}" />
									</f:facet>
									<h:outputLink value="#" onclick="setLink('#{links.url}', '#{links.codigo}');">
										<h:outputText value="#{links.url}" />
									</h:outputLink>
								</h:column>
					
								<h:column>
									<f:facet name="header">
										<h:outputText value="#{properties['lb_descricao']}" />
									</f:facet>
									<h:outputText value="#{links.descricao}" />
								</h:column>

							</t:dataTable>
							</div>
							<h:panelGrid columns="1" columnClasses="conteudoCentralizado" align="center">
					            <t:dataScroller id="scroll_1" for="dataPopup" fastStep="10"
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
						</td>
					</tr>
				</table>				
				<h:inputHidden id="codigo" value="#{LinkBean.link.codigo}"/>
			</h:form>
		</body>
	</html>
</f:view>