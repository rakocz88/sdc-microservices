package com.pilaf.sdc.core.json;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MailMsg implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8762956063121045398L;

    @NotNull
    protected String msg;

    @NotNull
    protected String title;

    @NotNull
    protected String recipent;

    @NotNull
    protected Long sender;

    public MailMsg() {
	super();
    }

    public MailMsg(String msg, String title, String recipent, Long sender) {
	super();
	this.msg = msg;
	this.recipent = recipent;
	this.sender = sender;
	this.title = title;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public String getRecipent() {
	return recipent;
    }

    public void setRecipent(String recipent) {
	this.recipent = recipent;
    }

    public Long getSender() {
	return sender;
    }

    public void setSender(Long sender) {
	this.sender = sender;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	// result = prime * result + ((msg == null) ? 0 : msg.hashCode());
	result = prime * result + ((recipent == null) ? 0 : recipent.hashCode());
	result = prime * result + ((sender == null) ? 0 : sender.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MailMsg other = (MailMsg) obj;
	if (msg == null) {
	    if (other.msg != null)
		return false;
	} else if (!msg.equals(other.msg))
	    return false;
	if (recipent == null) {
	    if (other.recipent != null)
		return false;
	} else if (!recipent.equals(other.recipent))
	    return false;
	if (sender == null) {
	    if (other.sender != null)
		return false;
	} else if (!sender.equals(other.sender))
	    return false;
	if (title == null) {
	    if (other.title != null)
		return false;
	} else if (!title.equals(other.title))
	    return false;
	return true;
    }

}
