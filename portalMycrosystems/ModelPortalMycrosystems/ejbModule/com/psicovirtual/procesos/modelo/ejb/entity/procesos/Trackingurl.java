package com.psicovirtual.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trackingurl database table.
 * 
 */
@Entity
@NamedQuery(name="Trackingurl.findAll", query="SELECT t FROM Trackingurl t")
public class Trackingurl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String domain;

	@Column(name="MESSAGE_ID")
	private String messageId;

	@Column(name="NOTIFICATION_TYPE")
	private String notificationType;

	private String recipient;

	@Column(name="SEND_DATE_TIME")
	private String sendDateTime;

	private String url;

	public Trackingurl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getNotificationType() {
		return this.notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getRecipient() {
		return this.recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSendDateTime() {
		return this.sendDateTime;
	}

	public void setSendDateTime(String sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}