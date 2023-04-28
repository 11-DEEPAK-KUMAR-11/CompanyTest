package com.lottery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "winning_numbers")
public class WinningNumber {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "winning_number")
    private Integer winningNumber;

	public WinningNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WinningNumber( Integer winningNumber) {
		super();
		
		this.winningNumber = winningNumber;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(Integer winningNumber) {
		this.winningNumber = winningNumber;
	}
    
    

    
}

