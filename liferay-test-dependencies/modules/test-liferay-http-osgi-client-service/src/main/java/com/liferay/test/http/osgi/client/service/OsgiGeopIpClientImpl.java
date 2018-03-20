package com.liferay.test.http.osgi.client.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.dependency.test.http.osgi.client.api.OsgiGeoIpClient;
import com.liferay.dependency.test.http.osgi.client.api.model.Position;
import com.liferay.test.http.osgi.client.service.model.json.IpInfos;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.osgi.service.component.annotations.Component;

/**
 * @author dev
 */
@Component(
	immediate = true
)
public class OsgiGeopIpClientImpl implements OsgiGeoIpClient {

    //private volatile OsgiGeopIpClientConfiguration _configuration;

	@Override
	public Position getGeoPosition(String address) {
		
		WebClient client = getClient();
		client.path(address).accept(MediaType.APPLICATION_JSON_TYPE);
		IpInfos message = client.get(IpInfos.class);
		System.out.println(">> : Message recieved : " + message);
		
		if (message != null) {
			return new Position(message.getLat(), message.getLon(), message.getCity());
		}
		
		return null;
		
	}

	private WebClient getClient() {
		List<JacksonJsonProvider> singletonList = Collections.singletonList(new JacksonJsonProvider());
		String serviceUrl = "http://ip-api.com/json/";
		WebClient client = WebClient.create(serviceUrl, singletonList);
		return client;
	}

}