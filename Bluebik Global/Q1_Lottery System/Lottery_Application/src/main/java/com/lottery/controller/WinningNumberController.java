package com.lottery.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lottery.model.WinningNumber;
import com.lottery.service.WinningNumberService;

@RestController
public class WinningNumberController {

	@Autowired
	private WinningNumberService winningNumberService;

	private boolean isServiceUp = true;

	// Schedule the job to run at 12:01 AM every day
	@Scheduled(cron = "0 1 0 * * *")
	public void triggerCalculationMicroservice() {

		// Check if the service is up before triggering the calculation microservice
		if (isServiceUp) {

			// Call the Calculation microservice to get the latest winning numbers
			List<Integer> winningNumbers = getLatestWinningNumbers();

			// Save the winning numbers in the Winner microservice
			winningNumberService.saveWinningNumbers(winningNumbers);
		}
	}

	@GetMapping("/winning-numbers/{number}")
	public ResponseEntity<Boolean> isWinningNumber(@PathVariable int number) {

		boolean isWinningNumber = winningNumberService.isWinningNumber(number);
		return ResponseEntity.ok(isWinningNumber);
	}

	@PostMapping("/winning-numbers")
	public ResponseEntity<String> postWinningNumbers(@RequestBody WinningNumber winningNumber) {

		winningNumberService.saveWinningNumbers(getLatestWinningNumbers());
		return ResponseEntity.ok("Winning number saved successfully");
	}

	// Mock implementation of the Calculation microservice
	private List<Integer> getLatestWinningNumbers() {

		// Simulate a downtime at 6 am by setting the service status to down
		if (LocalTime.now().getHour() == 6 && LocalTime.now().getMinute() == 0) {
			isServiceUp = false;
		}

		// Simulate the calculation microservice by generating a random list of numbers

		Random random = new Random();
		List<Integer> winningNumbers = new ArrayList<>();
		int numOfWinningNumbers = random.nextInt(901) + 100; // Generate a random number of winning numbers between 100
																// and 1000
		for (int i = 0; i < numOfWinningNumbers; i++) {
			winningNumbers.add(random.nextInt(10000) + 1); // Generate a winning number between 1 and 10000
		}

		// Simulate a service recovery at 6:10 am by setting the service status to up
		if (LocalTime.now().getHour() == 6 && LocalTime.now().getMinute() == 10) {
			isServiceUp = true;
		}

		return winningNumbers;
	}

}
