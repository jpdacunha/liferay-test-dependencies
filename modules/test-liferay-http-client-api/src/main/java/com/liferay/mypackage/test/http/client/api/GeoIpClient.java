package com.liferay.mypackage.test.http.client.api;

import com.liferay.mypackage.test.http.client.api.model.GeoIpResponse;

/**
 * @author jpdacunha
 */
public interface GeoIpClient {

	public String getResponse(String ip);
	
	public GeoIpResponse getResponseObject(String ip);
	
}