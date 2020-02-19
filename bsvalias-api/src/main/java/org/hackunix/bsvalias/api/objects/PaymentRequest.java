package org.hackunix.bsvalias.api.objects;

import java.time.Instant;

public class PaymentRequest {

	public String senderName;
	public String senderHandle;
	public String senderPaymail;
	public Instant dt;
	public Float amount;
	public String purpose;
	public String signature;

}
