package org.hackunix.bsvalias.api.resources;

import javax.ws.rs.GET;

import org.hackunix.bsvalias.api.objects.CapabilityDiscovery;

public interface WellKnownBsvaliasResource {

	@GET
	CapabilityDiscovery get();

}
