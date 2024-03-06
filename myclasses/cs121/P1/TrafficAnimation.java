import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a car driving down a road while an avatar fights to hover over the car. 
 *
 * @author BSU CS 121 Instructors
 * @author Ryan Thompson
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	Color myBlueSky = new Color(126, 192, 239);
	//private final Color BACKGROUND_COLOR = Color.blue;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(myBlueSky);
		g.fillRect(0, 0, width, height);
		
		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen		
		
		// This draws the car. 
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;
		int wheelSize = squareSide/2;
		g.setColor(Color.white);
		g.fillRect(xOffset, squareY+wheelSize/2, squareSide*2, squareSide);
		g.setColor(Color.black);
		//front of the car
		int frontOfCar = wheelSize;
		frontOfCar*=1.5;
		g.fillRect(xOffset + squareSide*2, squareY+frontOfCar, squareSide/2, squareSide/2);
		//head-light
		int headlightWidth = width/30;
		g.setColor(Color.yellow);
		g.fillOval(xOffset + squareSide*2 + headlightWidth/2, squareY+frontOfCar, headlightWidth, height/20);
		
		//This draws the phrase "Stay over the car"!"
		String quote = "Stay over the car!";
		g.setFont(new Font("Serif", Font.BOLD, width/10));
		g.setColor(Color.white);
		g.drawString(quote, 0, height/4);
		int quarter = height/4;
		
		//This draws the wheels
		squareSide *= 1.5;
		squareY*=1.5;
		g.setColor(Color.black);
		g.fillOval(xOffset, squareY+wheelSize/2, wheelSize, wheelSize);
		g.fillOval(xOffset+squareSide, squareY+wheelSize/2, wheelSize, wheelSize);
		
		//This draws the ground
		g.setColor(Color.black);
		g.fillRect(0, quarter*3, width, height);
		
		//This draws the sun...intentionally positioned off the screen a bit
		int sunLocation = -(width/35);
		int sunSize = height/6;
		g.setColor(Color.yellow);
		g.fillOval(sunLocation, sunLocation, sunSize, sunSize);
		
		//This draws the avatar
		g.setColor(Color.red);
		width*=0.85;
		//body
		g.drawLine(width, height/3, width, height/5);
		//arms
		g.drawLine(width, height/4, width+width/25, height/5);
		g.drawLine(width, height/4, width-width/25, height/5);
		//legs
		g.drawLine(width, height/3, width-width/35, height/3 + height/25);
		g.drawLine(width, height/3, width+width/35, height/3 + height/25);
		//head
		g.fillOval(width-width/40, height/6, width/20, height/20);

		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}