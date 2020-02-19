package org.hackunix.bsvalias.srv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class SrvClient {

	// https://html.spec.whatwg.org/multipage/input.html#e-mail-state-(type=email)
	//static final Pattern srvRegex1 = Pattern.compile("\\d+\\s+\\d+\\s+(\\d+)\\s+([a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)\\.?");
	// https://stackoverflow.com/a/18494710/2355587
	static final Pattern srvRegex2 = Pattern.compile("(\\d)+\\s+(\\d)+\\s+(\\d+)\\s+([a-zA-Z0-9](?:(?:[a-zA-Z0-9-]*|(?<!-)\\.(?![-.]))*[a-zA-Z0-9]+)?)\\.?");

	public String domain;
	public String priority;
	public String weight;
	public String port;
	public String target;

	public SrvClient(String paymailAddress) throws NamingException {
		domain = paymailAddress.split("@")[1];

		DirContext cx = new InitialDirContext();
		Attributes alias = cx.getAttributes("dns:/_bsvalias._tcp." + domain, new String[] {"SRV"});
		Attribute rr = alias.get("SRV");
		String reply = (String) rr.get();
		Matcher matcher = srvRegex2.matcher(reply);

		if (matcher.matches()) {
			priority = matcher.group(1);
			weight = matcher.group(2);
			port = matcher.group(3);
			target = matcher.group(4);
		}
	}

	public String getAuthority() {
		return target + ":" + port;
	}

}
