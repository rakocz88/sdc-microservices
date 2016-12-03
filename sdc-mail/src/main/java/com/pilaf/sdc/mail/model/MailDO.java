	
	package com.pilaf.sdc.mail.model;

	import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	@Entity
	@Table(name = "MailDO")
	public class MailDO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -9057454444230924105L;

		@Id
		@SequenceGenerator(name = "SDCUserSeq", sequenceName = "SDCUserSeq", allocationSize = 1)
		@GeneratedValue(generator = "SDCUserSeq", strategy = GenerationType.SEQUENCE)
		private Long id;

		private String login;

		private String password;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

