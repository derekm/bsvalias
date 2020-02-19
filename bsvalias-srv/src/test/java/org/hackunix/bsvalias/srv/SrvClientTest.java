package org.hackunix.bsvalias.srv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.bitcoinj.core.Base58;
import org.junit.Test;

public class SrvClientTest {

	@Test
	public void lookupPaymailSrvRecord() throws NamingException {
		SrvClient client = new SrvClient("derekm@moneybutton.com");
//		SrvClient client = new SrvClient("derekm@example.com");
		System.out.println(client.target);
		System.out.println(client.getAuthority());
	}

	@Test
	public void extractPubKeyHash() throws NoSuchAlgorithmException, IOException {
		String output = "76a9145ef2bcdeb545b080b019501d80b7e88bf7808e0e88ac";
		Matcher matcher = Pattern.compile("76a914([0-9a-f]+)88ac").matcher(output);
		if (matcher.matches()) {
			String pkh = matcher.group(1);
			byte[] hex = new HexBinaryAdapter().unmarshal(pkh);
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byteStream.write(0x00);
			byteStream.write(hex);
			hex = byteStream.toByteArray();
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] checksum = md.digest(md.digest(hex));
			ByteArrayOutputStream addrStream = new ByteArrayOutputStream();
			addrStream.write(hex);
			addrStream.write(checksum, 0, 4);
			byte[] addr = addrStream.toByteArray();
			String bitcoinAddr = Base58.encode(addr);
			System.out.println(bitcoinAddr);
		}
	}
}
