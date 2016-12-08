package com.pilaf.sdc.auth.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRest {

	@RequestMapping("/dupa")
	@ResponseBody
	public String getTest() {
		return "tets1";
	}

}
