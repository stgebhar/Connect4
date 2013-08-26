package testcases;

import mo.Turn;
import junit.framework.TestCase;

public class TurnTest extends TestCase {
private Turn turn;
	
	protected void setUp(){
		turn = new Turn();
	}
	
	public void testTurn(){
		assertEquals(0, turn.getTurn());
		turn.incTurn();
		turn.incTurn();
		turn.incTurn();
		assertEquals(3, turn.getTurn());
	}

}
