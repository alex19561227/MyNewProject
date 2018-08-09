package bdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class QuestionaryBddTest {
	
	@Before
	void setup() {
		
	}

	@Test
	void testViewListQuizz() {
		
		if (QuestionaryBdd.viewListQuizz((long)2)==null)
		fail("Not work");
	}

}
