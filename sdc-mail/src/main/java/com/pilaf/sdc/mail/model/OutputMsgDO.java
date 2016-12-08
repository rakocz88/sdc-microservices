package com.pilaf.sdc.mail.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pilaf.sdc.mail.json.MailMsg;

@Entity
@Table(name = "OutputMsg")
public class OutputMsgDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5804169974084961649L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String recipentMail;

	private Long senderID;

	private LocalDate sendDate;

	private String msg;

	private MessageType messageType;

	public OutputMsgDO(MailMsg mailMsg) {
		super();
		this.recipentMail = mailMsg.getRecipent();
		this.sendDate = LocalDate.now();
		this.msg = mailMsg.getMsg();
		this.senderID = mailMsg.getSender();
		this.messageType = MessageType.MAIL;
	}

	public OutputMsgDO() {
		super();
	}

	public OutputMsgDO(String recipentMail, LocalDate sendDate, String msg) {
		super();
		this.recipentMail = recipentMail;
		this.sendDate = sendDate;
		this.msg = msg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecipentMail() {
		return recipentMail;
	}

	public void setRecipentMail(String recipentMail) {
		this.recipentMail = recipentMail;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getSenderID() {
		return senderID;
	}

	public void setSenderID(Long senderID) {
		this.senderID = senderID;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

}
