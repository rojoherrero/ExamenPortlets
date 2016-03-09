<%@page import="com.examen.portlet.PortletEmisorA"%>
<%@page import="com.examen.entidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<portlet:actionURL name="<%=PortletEmisorA.ENVIAR_PERSONA_PORTLET_B%>" var="urlEnviarEventoPortletB" />
<portlet:actionURL name="<%=PortletEmisorA.ENVIAR_PERSONA_PORTLET_C%>" var="urlEnviarEventoPortletC" />

<div>
	<h1>Portlet Emisor A</h1>
</div>


<form method="post">
	<div>
		Tu nombre:<input type="text" name='<%=PortletEmisorA.NOMBRE%>' placeholder="Nombre" />
	</div>
	<div>
		Tu dirección postal:<input type="text" name='<%=PortletEmisorA.DIRECCION%>' placeholder="Direccion" />
	</div>
	<div>
		Tu número de teléfono:<input type="text" name='<%=PortletEmisorA.NUM_TELEFONO%>' placeholder="Telefono" />
	</div>
	<div>
		<input type="submit" formaction="<%=urlEnviarEventoPortletB%>" value="Enviar al Portlet B" />
	</div>
	<div>
		<input type="submit" formaction="<%=urlEnviarEventoPortletC%>" value="Enviar al Portlet C" />
	</div>

</form>