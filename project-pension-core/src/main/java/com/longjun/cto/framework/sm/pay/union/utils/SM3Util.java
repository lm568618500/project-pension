package com.longjun.cto.framework.sm.pay.union.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

/**
 * SM3 工具
 * 
 */
public class SM3Util {

	static {
		try {
			Security.addProvider(new BouncyCastleProvider());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private SM3Util() {
	}

	/**
	 * SM3 摘要结果
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static final String sm3(String input)
			throws NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException {
		MessageDigest digest = null;
		digest = MessageDigest.getInstance("SM3", "BC");
		byte[] result = digest.digest(input.getBytes("UTF-8"));
		//return Hex.toHexString(result);
		return ByteUtils.toHexString(result);

	}

}
