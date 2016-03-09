package com.examen.portlet;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.examen.entidades.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletEmisorA
 */
public class PortletEmisorA extends GenericPortlet {

	public static final String ATTR_PERSONA = "persona";

	public static final String ENVIAR_PERSONA_PORTLET_C = "enviarPersonaPortletC";

	public static final String ENVIAR_PERSONA_PORTLET_B = "enviarPersonaPortletB";

	public static final String NUM_TELEFONO = "numTelefono";

	public static final String DIRECCION = "direccion";

	public static final String NOMBRE = "nombre";

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		

		include(viewTemplate, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	@ProcessAction(name = ENVIAR_PERSONA_PORTLET_B)
	public void enviarPersonaPortletB(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		
		String nombre = request.getParameter(NOMBRE);
		String direccion = request.getParameter(DIRECCION);
		String numTelefono = request.getParameter(NUM_TELEFONO);
		
		Persona persona = new Persona(nombre, direccion, numTelefono);
		
		QName qname = new javax.xml.namespace.QName("http://evento.examen.enviar.portletB.com", "Persona", "x");
		response.setEvent(qname, persona);
	}
	
	@ProcessAction(name = ENVIAR_PERSONA_PORTLET_C)
	public void enviarPersonaPortletC(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		
		String nombre = request.getParameter(NOMBRE);
		String direccion = request.getParameter(DIRECCION);
		String numTelefono = request.getParameter(NUM_TELEFONO);
		
		Persona persona = new Persona(nombre, direccion, numTelefono);
		QName qname = new javax.xml.namespace.QName("http://evento.examen.enviar.portletC.com", "Persona", "x");
		
		response.setEvent(qname, persona);
	}
	
	@ProcessEvent(qname = "{http://evento.examen.enviar.portletB.com}Persona")
	public void procesarEventoPortletB(EventRequest request, EventResponse response) throws PortletException, IOException {
		Event event = request.getEvent();
		Serializable persona = event.getValue();
		
		request.setAttribute(ATTR_PERSONA, persona);
	}
	
	@ProcessEvent(name = "{http://evento.examen.enviar.portletC.com}Persona")
	public void procesarEventoPortletC(EventRequest request, EventResponse response) throws PortletException, IOException {
		Event event = request.getEvent();
		Serializable persona = event.getValue();
		
		request.setAttribute(ATTR_PERSONA, persona);
    }

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletEmisorA.class);

}
