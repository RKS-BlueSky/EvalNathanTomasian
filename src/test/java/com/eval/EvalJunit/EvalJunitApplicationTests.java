package com.eval.EvalJunit;

import com.eval.EvalJunit.Controller.ChifoumiController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvalJunitApplicationTests {

	private ChifoumiController chifoumiController;

	@BeforeEach
	void setUp() {
		chifoumiController = new ChifoumiController();
	}

	@Test
	void testPlay() {
		String action = "rock";
		String response = chifoumiController.play(action);

		Assertions.assertTrue(response.contains("vous avez joué " + action + ", l'ordinateur a joué "));
	}

	@Test
	void testScoreRestart() {

		chifoumiController.restart();
		String response = chifoumiController.score();

		Assertions.assertEquals("{\"wins\":" + 0 + ",\"losses\":" + 0 + ",\"ties\":" + 0 + "}", response);
	}

	@Test
	void testUpdateScore() {
		int wins = 1;
		int losses = 2;
		int ties = 3;

		chifoumiController.setScore(wins, losses, ties);

		Assertions.assertEquals("{\"wins\":" + wins + ",\"losses\":" + losses + ",\"ties\":" + ties + "}", chifoumiController.score());
	}
}
