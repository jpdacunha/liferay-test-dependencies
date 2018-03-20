package com.liferay.test.http.client.shell;

import com.liferay.dependency.test.http.osgi.client.api.OsgiGeoIpClient;
import com.liferay.dependency.test.http.osgi.client.api.model.Position;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		  immediate=true,
		  service = Object.class,
		  property = {
		    "osgi.command.function=osgiipinfos",
		    "osgi.command.scope=test"
		  }
		)
public class OsgiIpInfos {
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	protected OsgiGeoIpClient service;
	
	public void osgiipinfos(String ip) {
		Position position = service.getGeoPosition(ip);
		
		System.out.println(">>> position : lat=" + position.getLatitude() + " long=" + position.getLongitude() + " city=" + position.getCity());
		
		
	}

}