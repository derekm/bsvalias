package org.hackunix.bsvalias.api.objects;

import javax.json.bind.annotation.JsonbProperty;

public class Capabilities {

	/**
	 * http://bsvalias.org/03-public-key-infrastructure.html
	 */
	public String pki;

	/**
	 * http://bsvalias.org/04-01-basic-address-resolution.html
	 */
	public String paymentDestination;

	/**
	 * http://bsvalias.org/04-02-sender-validation.html
	 */
	@JsonbProperty("6745385c3fc0")
	public Boolean senderValidation;

	/**
	 * http://bsvalias.org/05-verify-public-key-owner.html
	 */
	@JsonbProperty("a9f510c16bde")
	public String verifyPublicKey;

}
