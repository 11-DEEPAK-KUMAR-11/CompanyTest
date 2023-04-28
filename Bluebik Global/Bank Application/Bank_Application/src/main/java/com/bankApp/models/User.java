package com.bankApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class User {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    private String name;
	    
	    @ManyToOne
	    @JsonIgnore
	    private Account account;
	    
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(Long id, String name, Account account) {
			super();
			this.id = id;
			this.name = name;
			this.account = account;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
	    
	    
}
