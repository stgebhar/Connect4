package model;

import model.Grid;
import junit.framework.TestCase;

/**
 * not finished yet
 * @author stgebhar
 *
 */
public class GridTest extends TestCase {
	private Grid grid;
	private static final String newLine = "\n";
	private static final String sepLine = "|---+---+---+---+---+---+---|";
	private static final String NumberLine = "|   |   |   |   |   |   |   | ";
	
	@Override
	protected void setUp(){
		grid = new Grid();
	}
	
	public void testToString() {
		grid.reset();
		assertEquals(sepLine + newLine + NumberLine + newLine + sepLine + newLine + NumberLine + newLine +sepLine + newLine + NumberLine + newLine +sepLine + newLine + NumberLine + newLine +sepLine + newLine + NumberLine + newLine +sepLine + newLine + NumberLine + newLine + sepLine + newLine, grid.toString());
	}
	
	public void testgetHeight(){
		assertEquals(0 ,grid.getHeight(2));
	}
	
	public void testWinCheck(){
		assertFalse(grid.winCheck());
	}
}
