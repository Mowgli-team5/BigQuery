package com.management.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class ManagementServer 
{
	
	@GET
	@Path("/LoginAuthentication")
	public String LoginAuthentication()
	{
		return "working all good";
		
	}

}
