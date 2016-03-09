package com.examen.portlet;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletReceptorB
 */
public class PortletReceptorB extends GenericPortlet {

	public static final String ATTR_PERSONA = "persona";

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

	@ProcessEvent(qname = "{http://evento.examen.enviar.portletB.com}Persona")
	public void procesarEvento(EventRequest request, EventResponse response) throws PortletException, IOException {
		Event event = request.getEvent();
		Serializable persona = event.getValue();
		
		request.setAttribute(ATTR_PERSONA, persona);
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(PortletReceptorB.class);

}
