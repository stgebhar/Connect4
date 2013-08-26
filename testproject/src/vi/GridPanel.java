package vi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.Controller;

import mo.Grid;
import mo.Player;


public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int MAX_TURNS = 42;

	/**
	 * constructor
	 * @param grid
	 * @param controller
	 */
	public GridPanel( final Grid grid, final Controller controller, final Player player) {
		setLayout(new GridLayout(6, 7, 2, 2));
		setBorder(BorderFactory.createLoweredBevelBorder());
		BlockPanel[] block = new BlockPanel[MAX_TURNS];

		for (int index = 0; index < MAX_TURNS; index++) {
			block[index] = new BlockPanel(1);
			add(block[index]);
		}
		int i = 0;
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				CellPanel cellPanel = new CellPanel(grid.getCell(row, column), player);
				block[i].add(cellPanel);
				i++;
			}
		}

		// Mouse Listener
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int clicked = e.getX();
				int width = (int) getSize().getWidth();
				int split = (int) (7 * ((double) clicked / (double) width));
				System.out.println(split);
				if (grid.getHeight(split) != -1){
					controller.setValue(grid.getCell(grid.getHeight(split), split));
				}
			}
		});
	}
	
	/**
	 * repaint for grid
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
