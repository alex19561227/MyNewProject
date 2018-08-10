package bdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MyParcours;
import model.MyQuestionary;
import model.MySubject;
import model.MyUser;

class ParcoursBddTest {

	@Test
	void testInsertParcours() {
		boolean test=false;
		//test=ParcoursBdd.insertParcours(new MyParcours(-1L, new MyQuestionary(true,1L,new MySubject(2L),"Hibernate") , 5, 3000L, new MyUser(1L,"Martin","Bernard", null, null, null, null, true, null)));
		
		if (!test) fail("Not yet implemented");
	}

}
