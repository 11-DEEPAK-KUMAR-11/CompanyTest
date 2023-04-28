package com.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lottery.model.WinningNumber;

@Repository
public interface WinningNumberRepository extends JpaRepository<WinningNumber, Long> {
	
    WinningNumber findByWinningNumber(Integer winningNumber);
}
