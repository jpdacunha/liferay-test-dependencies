package com.liferay.dependency.test.http.osgi.client.api;

import com.liferay.dependency.test.http.osgi.client.api.model.Position;

/**
 * @author dev
 */
public interface OsgiGeoIpClient {
	public Position getGeoPosition(String address);
}