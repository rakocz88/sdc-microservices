package com.pilaf.sdc.mail.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pilaf.sdc.mail.json.MailMsg;

@Entity
@Table(name = "OutputMsg")
public class OutputMsgDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0l;

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

	public OutputMsgDO(long id, String recipentMail, Long senderID, LocalDate sendDate, String msg,
			MessageType messageType) {
		super();
		this.id = id;
		this.recipentMail = recipentMail;
		this.senderID = senderID;
		this.sendDate = sendDate;
		this.msg = msg;
		this.messageType = messageType;
	}

	public Long getId() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + ((recipentMail == null) ? 0 : recipentMail.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((senderID == null) ? 0 : senderID.hashCode());
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
		OutputMsgDO other = (OutputMsgDO) obj;
		if (id != other.id)
			return false;
		if (messageType != other.messageType)
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (recipentMail == null) {
			if (other.recipentMail != null)
				return false;
		} else if (!recipentMail.equals(other.recipentMail))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (senderID == null) {
			if (other.senderID != null)
				return false;
		} else if (!senderID.equals(other.senderID))
			return false;
		return true;
	}

	public void fillObject(MailMsg mailMsg) {
		this.recipentMail = mailMsg.getRecipent();
		this.sendDate = LocalDate.now();
		this.msg = mailMsg.getMsg();
		this.senderID = mailMsg.getSender();
		this.messageType = MessageType.MAIL;
	}

}
