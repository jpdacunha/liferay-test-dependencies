package com.liferay.test.conseileurope.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.test.conseileurope.portlet.constants.ConseilEuropePortletKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.osgi.service.component.annotations.Component;

/**
 * @author dev
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=test-liferay-conseileurope-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ConseilEuropePortletKeys.ConseilEurope,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ConseilEuropePortlet extends MVCPortlet {
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
		
		System.out.println("ProcessAction starts..");
		

		String contentString = "{\"title\": \"Person\",\"type\": \"object\"}";
		JSONTokener content = new JSONTokener(contentString);
		JSONObject jsonObject = new org.json.JSONObject(content);
		System.out.println("jsonObject: " + jsonObject.toString());
		
		System.out.println("ProcessAction ends..");
		
	}
	
}