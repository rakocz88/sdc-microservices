package com.pilaf.sdc.core.json;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ActivationCodeJSON implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long userId;

    @NotNull
    private String activationCode;

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public String getActivationCode() {
	return activationCode;
    }

    public void setActivationCode(String activationCode) {
	this.activationCode = activationCode;
    }

}
