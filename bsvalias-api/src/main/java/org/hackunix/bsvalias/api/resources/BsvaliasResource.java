package org.hackunix.bsvalias.api.resources;

import javax.ws.rs.Path;

public interface BsvaliasResource {

	@Path(".well-known")
	WellKnownResource wellKnown();

}
