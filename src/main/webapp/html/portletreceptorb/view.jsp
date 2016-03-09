<%@page import="com.examen.entidades.Persona"%>
<%@page import="com.examen.portlet.PortletReceptorB"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<%
	Persona persona = (Persona) request.getAttribute(PortletReceptorB.ATTR_PERSONA);
%>

<div>
	<h1>Portlet Receptor B</h1>
</div>

<%
	if (persona != null) {
%>
<div><%=persona.getNombre()%></div>
<div><%=persona.getDireccion()%></div>
<div><%=persona.getNumeroTelefono()%></div>
<%
	}
%>

<div>
	<h2>No has introducido ningún dato</h2>
</div>