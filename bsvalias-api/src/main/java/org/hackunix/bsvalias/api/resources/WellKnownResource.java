package org.hackunix.bsvalias.api.resources;

import javax.ws.rs.Path;

public interface WellKnownResource {

	@Path("bsvalias")
	WellKnownBsvaliasResource bsvalias();

}
