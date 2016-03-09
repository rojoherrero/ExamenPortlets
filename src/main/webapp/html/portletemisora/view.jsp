<%@page import="com.examen.portlet.PortletEmisorA"%>
<%@page import="com.examen.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<portlet:actionURL name="<%=PortletEmisorA.ENVIAR_PERSONA_PORTLET_B%>"
	var="urlEnviarEventoPortletB" />
<portlet:actionURL name="<%=PortletEmisorA.ENVIAR_PERSONA_PORTLET_C%>"
	var="urlEnviarEventoPortletC" />

<%
	Persona persona = (Persona) request.getAttribute(PortletEmisorA.ATTR_PERSONA);
%>

<div>
	<h1>Portlet Emisor A</h1>
</div>


<form method="post">

	<%
		if (persona != null) {
	%>

	<div>
		Tu nombre:<input type="text" name='<%=PortletEmisorA.NOMBRE%>'
			placeholder=<%=persona.getNombre()%> value="<%=persona.getNombre()%>" />
	</div>
	<div>
		Tu dirección postal:<input type="text"
			name='<%=PortletEmisorA.DIRECCION%>'
			placeholder="<%=persona.getDireccion()%>"
			value="<%=persona.getDireccion()%>" />
	</div>
	<div>
		Tu número de teléfono:<input type="text"
			name='<%=PortletEmisorA.NUM_TELEFONO%>'
			placeholder="<%=persona.getNumeroTelefono()%>"
			value="<%=persona.getNumeroTelefono()%>" />
	</div>
	<%
		} else {
	%>
	<div>
		Tu nombre:<input type="text" name='<%=PortletEmisorA.NOMBRE%>'
			placeholder="Nombre" />
	</div>
	<div>
		Tu dirección postal:<input type="text"
			name='<%=PortletEmisorA.DIRECCION%>' placeholder="Dirección" />
	</div>
	<div>
		Tu número de teléfono:<input type="text"
			name='<%=PortletEmisorA.NUM_TELEFONO%>'
			placeholder="Número de teléfono" />
	</div>
	<%
		}
	%>
	<div>
		<input type="submit" formaction="<%=urlEnviarEventoPortletB%>"
			value="Enviar al Portlet B" />
	</div>
	<div>
		<input type="submit" formaction="<%=urlEnviarEventoPortletC%>"
			value="Enviar al Portlet C" />
	</div>
</form>

