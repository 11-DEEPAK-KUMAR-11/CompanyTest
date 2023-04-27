package com.bankApp.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Account {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
	    private BigDecimal balance;
	    
	    @OneToMany(mappedBy = "account")
	    private List<User> users;
	    
	 // constructors, getters and setters
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Account(Long id, BigDecimal balance, List<User> users) {
			super();
			this.id = id;
			this.balance = balance;
			this.users = users;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public BigDecimal getBalance() {
			return balance;
		}
		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
	    
	    
	    
}