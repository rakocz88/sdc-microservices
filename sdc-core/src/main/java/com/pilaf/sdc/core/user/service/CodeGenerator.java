package com.pilaf.sdc.core.user.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public final class CodeGenerator {
	private SecureRandom random = new SecureRandom();

	public String generateCode() {
		return new BigInteger(130, random).toString(32);
	}
}
