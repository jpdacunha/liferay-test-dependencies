package com.liferay.test.http.client.service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.mypackage.test.http.client.api.GeoIpClient;
import com.liferay.mypackage.test.http.client.api.model.GeoIpResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = GeoIpClient.class
	)
public class GeoIpClientImpl implements GeoIpClient {
	
	private static final Log _log = LogFactoryUtil.getLog(GeoIpClientImpl.class);
	
	public GeoIpResponse getResponseObject(String ip) {
		
		GeoIpResponse geoIP = new GeoIpResponse();
		String url = "http://ip-api.com/json";
		
		if (ip != null && !ip.equals("")) {
			url += "/" + ip;
		}
		
	
		try {
			
			ClientConfig cc = new DefaultClientConfig();
			cc.getClasses().add(JacksonJsonProvider.class);
			
			Client client = Client.create(cc);

			WebResource webResource = client.resource(url);

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			GeoIpResponse geoIp = response.getEntity(GeoIpResponse.class);
			
			System.out.println("--------START2--------");
			System.out.println("City    : " + geoIp.getCity());
			System.out.println("Country : " + geoIp.getCountry());
			System.out.println("-------- END2 --------");
			

		  } catch (Throwable e) {

			  _log.error(e,e);

		  }
		
		return geoIP;
		
	}
	
	public String getResponse(String ip) {
		
		String output = "";
		String url = "http://ip-api.com/json";
		
		if (ip != null && !ip.equals("")) {
			url += "/" + ip;
		}
		
	
		try {
			
			Client client = Client.create();

			WebResource webResource = client.resource(url);

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			output = response.getEntity(String.class);
			
			System.out.println("--------START--------");
			System.out.println("Output from Server ....");
			System.out.println(output);
			System.out.println("-------- END --------");
			

		  } catch (Throwable e) {

			  _log.error(e,e);

		  }
		
		return output;
		
	}

}
