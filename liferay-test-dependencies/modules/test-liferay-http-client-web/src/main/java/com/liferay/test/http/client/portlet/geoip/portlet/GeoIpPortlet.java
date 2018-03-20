package com.liferay.test.http.client.portlet.geoip.portlet;

import com.liferay.mypackage.test.http.client.api.GeoIpClient;
import com.liferay.mypackage.test.http.client.api.model.GeoIpResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.test.http.client.portlet.geoip.constants.GeoIpPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * @author dev
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=test-liferay-http-client-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GeoIpPortletKeys.GeoIp,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GeoIpPortlet extends MVCPortlet {
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	protected GeoIpClient service;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		super.doView(renderRequest, renderResponse);
		
		GeoIpResponse response = service.getResponseObject("89.133.44.2");
		
	}
	
	
	
}