package com.lottery.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.model.WinningNumber;
import com.lottery.repository.WinningNumberRepository;

@Service
public class WinningNumberService {
	
    @Autowired
    private WinningNumberRepository winningNumberRepository;

//    private final WinningNumberRepository winningNumberRepository;

    public WinningNumberService(WinningNumberRepository winningNumberRepository) {
        this.winningNumberRepository = winningNumberRepository;
    }

//    public void saveWinningNumbers(List<Integer> winningNumbers) {
//    	
//        Set<WinningNumber> existingWinningNumbers = winningNumberRepository.findAll().stream()
//                .collect(Collectors.toSet());
//
//        for (Integer number : winningNumbers) {
//            WinningNumber winningNumber = new WinningNumber(number);
//            if (!existingWinningNumbers.contains(winningNumber)) {
//                existingWinningNumbers.add(winningNumber);
//                winningNumberRepository.save(winningNumber);
//            }
//        }
//    }
    
    public boolean isWinningNumber(int number) {
      WinningNumber winningNumber = winningNumberRepository.findByWinningNumber(number);
      return (winningNumber != null);
    }
    
    public void saveWinningNumbers(List<Integer> winningNumbers) {
    	
        for (Integer number : winningNumbers) {
        	
            WinningNumber winningNumber = new WinningNumber(number);
            winningNumberRepository.save(winningNumber);
        }
    }

    

    
//    public void saveWinningNumbers(List<Integer> winningNumbers) {
//    	
//        for (Integer winningNumber : winningNumbers) {
//        	
//            WinningNumber existingWinningNumber = winningNumberRepository.findByWinningNumber(winningNumber);
//            
//            if (existingWinningNumber == null) {
//            	
//                WinningNumber newWinningNumber = new WinningNumber(winningNumber);
//                winningNumberRepository.save(newWinningNumber);
//            }
//        }
//    }
//
//    public boolean isWinningNumber(int number) {
//        WinningNumber winningNumber = winningNumberRepository.findByWinningNumber(number);
//        return (winningNumber != null);
//    }
}

