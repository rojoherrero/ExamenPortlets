<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.examen.portlet.PortletReceptorC"%>
<%@page import="com.examen.entidades.Persona"%>
<portlet:defineObjects />

<%
	Persona persona = (Persona) request.getAttribute(PortletReceptorC.ATTR_PERSONA);
%>

<div>
	<h1>Portlet Receptor C</h1>
</div>

<%
	if (persona != null) {
%>
<div>Nombre: <%=persona.getNombre()%></div>
<div>Direcci�n: <%=persona.getDireccion()%></div>
<div>N�mero de tel�fono: <%=persona.getNumeroTelefono()%></div>
<%
	} else {
%>

<div>
	<h2>No has introducido ning�n dato</h2>
</div>
<%
	}
%>