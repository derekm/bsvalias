package org.hackunix.bsvalias.client;

import javax.enterprise.context.ApplicationScoped;

import org.hackunix.bsvalias.api.resources.BsvaliasResource;
import org.hackunix.jersey.client.JerseyClient;

@ApplicationScoped
public class BsvaliasClient extends JerseyClient<BsvaliasResource> {

	@Override
	protected Class<BsvaliasResource> getRootClass() {
		return BsvaliasResource.class;
	}

	@Override
	protected String getConfigPrefix() {
		return BsvaliasClient.class.getSimpleName();
	}

	/**
	 * Instantiate by loading configuration using MP Config.
	 */
	public BsvaliasClient() {
		super();
	}

	/**
	 * Instantiate with provided baseUrl.
	 * @param baseUrl Base URL for reaching service instance
	 * @param loggingEnabled enable HTTP request/response logging
	 */
	public BsvaliasClient(String baseUrl, boolean loggingEnabled) {
		super(baseUrl, null, null, loggingEnabled);
	}

	@Override
	protected void initializeClient() {}

}
