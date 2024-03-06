import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * @author Ryan Thompson
 *
 * Main panel class
 */
public class MineWalkerPanel 
{
	private int DELAY;
	private JPanel panel;
	private JButton button;
	private boolean off;
	private int count;
	int[] dx, dy;
	int clicks;
	int[] xo, yo;
	int mineClicks;
	int numMinesNearby;
	int go;
	
	//Constructor
	public MineWalkerPanel(JFrame frame)
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		count = 0;
		dx = new int[20];
		dy = new int[20];
		xo = new int[4];
		yo = new int[4];
		
		///// Top Panel START 
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		JLabel title = new JLabel("Minewalker");
		topPanel.add(title);
		panel.add(topPanel, BorderLayout.NORTH);
		///// Top Panel END
		
		
		///// Right Panel START
		///// The Right Panel contains the KEY
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		JLabel key = new JLabel("Key");
		rightPanel.add(key);
	
		JLabel zeroMines = new JLabel("0 Nearby Mines");
		zeroMines.setOpaque(true);
		zeroMines.setBackground(Color.GREEN);
		zeroMines.setHorizontalAlignment(JLabel.CENTER);
		zeroMines.setBorder(new EmptyBorder(25,25, 25, 27));
		
		JLabel oneMine = new JLabel("1 Nearby Mines");
		oneMine.setOpaque(true);
		oneMine.setBackground(Color.YELLOW);
		oneMine.setHorizontalAlignment(JLabel.CENTER);
		oneMine.setBorder(new EmptyBorder(25,25, 25, 27));
		
		JLabel twoMines = new JLabel("2 Nearby Mines");
		twoMines.setOpaque(true);
		twoMines.setBackground(Color.ORANGE);
		twoMines.setHorizontalAlignment(JLabel.CENTER);
		twoMines.setBorder(new EmptyBorder(25,25, 25, 27));
		
		JLabel threeMines = new JLabel("3 Nearby Mines");
		threeMines.setOpaque(true);
		threeMines.setBackground(Color.RED);
		threeMines.setHorizontalAlignment(JLabel.CENTER);
		threeMines.setBorder(new EmptyBorder(25,25, 25, 27));
		
		JLabel explodedMines = new JLabel("Exploded Mines");
		explodedMines.setOpaque(true);
		explodedMines.setForeground(Color.WHITE);
		explodedMines.setBackground(Color.BLACK);
		explodedMines.setHorizontalAlignment(JLabel.CENTER);
		explodedMines.setBorder(new EmptyBorder(25,25, 25, 25));
		
		JLabel destination = new JLabel("Destination");
		destination.setOpaque(true);
		destination.setBackground(new Color(240,137,207));
		destination.setHorizontalAlignment(JLabel.CENTER);
		destination.setBorder(new EmptyBorder(25,25, 25, 50));
		
		JLabel start = new JLabel("Start");
		start.setOpaque(true);
		start.setBackground(new Color(137, 207, 240));
		start.setHorizontalAlignment(JLabel.CENTER);
		start.setBorder(new EmptyBorder(25,25, 25, 86));
				
		rightPanel.add(zeroMines);
		rightPanel.add(oneMine);
		rightPanel.add(twoMines);
		rightPanel.add(threeMines);
		rightPanel.add(explodedMines);
		rightPanel.add(destination);
		rightPanel.add(start);	
		panel.add(rightPanel, BorderLayout.EAST);
		///// Right Panel END
		
		
		///// Center Panel START
		///// The center panel contains the mines and path
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(5,5));
		
		JButton[][] button = new JButton[5][5];
		
		for(int i = 0; i < 5; i++)
			for(int y = 0; y < 5; y++)
			{
				button[i][y] = new JButton();
				button[i][y].setBackground(Color.WHITE);
				button[i][y].setForeground(Color.WHITE);
				button[i][y].setHorizontalAlignment(JButton.CENTER);
				button[i][y].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
				
				centerPanel.add(button[i][y]);	
			}
		
		button[0][4].setBackground(new Color(240,137,207));
		button[4][0].setBackground(new Color(137, 207, 240));
		
		int row = 4; 
		int column = 0;
		int counter = 0;
		button[row][column].setForeground(Color.BLUE);
		button[row][column].setText("");
		
		Random rand = new Random();
		while(row > 0 || column < 4)
		{
			boolean up = rand.nextBoolean();		
			dx[counter] = row;
			dy[counter] = column;
			counter++;
			
			if(up == true && row > 0)
			{
				row--;
				button[row][column].setText("");
				button[row][column].setForeground(Color.BLUE);	
			}
			else if(column < 4)
			{
				column++;
				button[row][column].setText("");
				button[row][column].setForeground(Color.BLUE);
			}
		}

		int mines = 0;
		Color maybeMine;
		Color open = Color.WHITE;
		
		while(mines < 4)
		{
			xo[mines] = rand.nextInt(5);
			yo[mines] = rand.nextInt(5);
			maybeMine = button[xo[mines]][yo[mines]].getForeground(); 
			if(maybeMine == open)
			{
				button[xo[mines]][yo[mines]].setText("");
				button[xo[mines]][yo[mines]].setForeground(Color.BLACK);
				mines++;
			}
		}
		
		panel.add(centerPanel);
		///// Center Panel END
		
		
		///// Bottom Panel START
		///// The bottom panel contains the controls.
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		JButton showMines = new JButton("Show/Hide Mines");
		JButton showPath = new JButton("Show/Hides Path");
		
		clicks = 0;
		count = 0;
		mineClicks = 0;
		numMinesNearby = 0;
		button[0][4].setForeground(Color.PINK);
		go = 0;
		
		ActionListener tog = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for(int dxx = 0; dxx <= 4; dxx++)
				{
					for(int dyy = 0; dyy <= 4; dyy++)
					{
						
						if(e.getSource() == button[dxx][dyy])
						{
							if(button[dxx][dyy].getForeground() == Color.BLACK)
							{
								if(go == 0)
								{
									for(int doneX = 0; doneX <= 4; doneX++)
									{
										for(int doneY = 0; doneY <= 4; doneY++)
										{
											button[doneX][doneY].setBackground(Color.RED);
											button[doneX][doneY].setForeground(Color.BLACK);
											button[doneX][doneY].setText("GAME OVER!");
											button[2][2].setBackground(Color.WHITE);
											button[2][2].setText("Click to exit");
										}
									}go = 1;
								}
								else if(go == 1) 
								{
									try {
										Thread.sleep(1);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
									System.exit(1);
								}
	
							}
							else if(button[dxx][dyy].getForeground() == Color.PINK)
							{
								for(int winX = 0; winX <= 4; winX++)
								{
									for(int winY = 0; winY <= 4; winY++)
									{
										
										button[winX][winY].setBackground(Color.GREEN);
										button[winX][winY].setForeground(Color.WHITE);
										button[winX][winY].setText("YOU WIN!");
										button[2][2].setForeground(Color.BLACK);
										button[2][2].setBackground(Color.WHITE);
										button[2][2].setText("Click to exit");
									}
								}go = 1;
							}
							else if(go == 1) 
							{
								try {
									Thread.sleep(1);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								System.exit(1);
							}
							
							numMinesNearby = 0;
							if(dxx == 0 && dyy == 0)
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if(dxx == 4 && dyy == 0)
							{
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if(dxx == 0 && dyy == 4)
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if(dxx == 0 && (dyy == 1 || dyy == 2 || dyy == 3))
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if((dxx == 1 || dxx == 2 || dxx == 3 ) && dyy == 0)
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if(dxx == 4 && (dyy == 1 || dyy == 2 || dyy == 3))
							{
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if((dxx == 1 || dxx == 2 || dxx ==3) && dyy == 4)
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else if(dxx == 4 && dyy == 4)
							{
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							else 
							{
								if(button[dxx+1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx-1][dyy].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy+1].getForeground() == Color.BLACK)
									numMinesNearby++;
								if(button[dxx][dyy-1].getForeground() == Color.BLACK)
									numMinesNearby++;
							}
							if(numMinesNearby == 0)
								button[dxx][dyy].setBackground(Color.GREEN);
							else if(numMinesNearby == 1)
								button[dxx][dyy].setBackground(Color.YELLOW);
							else if(numMinesNearby == 2)
								button[dxx][dyy].setBackground(Color.ORANGE);
							else if(numMinesNearby == 3)
								button[dxx][dyy].setBackground(Color.RED);
						}
					}
				}
		
				if(e.getSource() == showMines)
				{
					mineClicks++;
					
					for(int h = 0; h <= 4; h++)
					{
						for(int d = 0; d <= 4; d++)
						{
							Color findMines = button[h][d].getForeground();
							if(findMines == Color.BLACK)
							{
								if(mineClicks % 2 == 0) 
								{
									button[h][d].setBackground(Color.WHITE);
								}
								else
								{
									button[h][d].setBackground(Color.BLACK);
								}
								
							}
						}
					}
				}
				if(e.getSource() == showPath)
				{
					clicks++;
					
						for(int t = 0; t <= 4; t++)
						{
							for(int a = 0; a <= 4; a++)
							{
								Color findPath = button[t][a].getForeground();
								if(findPath == Color.BLUE)
								{
									if(clicks % 2 == 0) 
									{
										button[t][a].setBackground(Color.WHITE);
									}
									else
									{
										button[t][a].setBackground(Color.BLUE);
									}
									
								}
							}
						}
				}
			}
		};
		
		showPath.addActionListener(tog);
		showMines.addActionListener(tog);
			
		for(int u = 0; u <= 4; u++)
		{
			for(int gh = 0; gh <= 4; gh++)
			{
				button[u][gh].addActionListener(tog);
			}
		}			
		bottomPanel.add(showMines);
		bottomPanel.add(showPath);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		///// Bottom Panel END	
	}
	
	/**
	 * @return panel
	 * panel contains all of the display for the GUI.
	 */
	public JPanel getPanel()
	{
		return panel;
	}
}
