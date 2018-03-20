package com.liferay.test.http.client.shell;

import com.liferay.mypackage.test.http.client.api.GeoIpClient;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		  immediate=true,
		  service = Object.class,
		  property = {
		    "osgi.command.function=ipinfos",
		    "osgi.command.scope=test"
		  }
		)
public class IpInfos {
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	protected GeoIpClient service;
	
	public void ipinfos(String ip) {
		service.getResponse(ip);
	}

}