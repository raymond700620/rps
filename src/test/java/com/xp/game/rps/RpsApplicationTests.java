package com.xp.game.rps;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RpsApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;


	@Test
	void contextLoads() {
	}

	@Test
	void rockVsScissors() {
		ResponseEntity<String> response = restTemplate.postForEntity("/play", new PlayRequest("rock", "scissors"),String.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals("Player 1 Wins",response.getBody());
	}

	@Test
	void scissorsVsRock() {
		ResponseEntity<String> response = restTemplate.postForEntity("/play", new PlayRequest("scissors", "rock"),String.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals("Player 2 Wins",response.getBody());
	}

	@Test
	void paperVsPaper() {
		ResponseEntity<String> response = restTemplate.postForEntity("/play", new PlayRequest("paper", "paper"),String.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertEquals("Draw",response.getBody());
	}

	//Testing of RPSAdminController
	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
	void givenRoundPlayed_returnTotalRounds() {


		ResponseEntity<Integer> response1 = restTemplate.getForEntity("/admin/round", Integer.class);
		assertEquals(HttpStatus.OK,response1.getStatusCode());
		assertEquals(0, response1.getBody());

		ResponseEntity<String> response = restTemplate.postForEntity("/play", new PlayRequest("paper", "paper"),String.class);

		ResponseEntity<Integer> response2= restTemplate.getForEntity("/admin/round", Integer.class);
		assertEquals(HttpStatus.OK,response2.getStatusCode());
		assertEquals(1, response2.getBody());


	}
}
