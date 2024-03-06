import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Draws gradients across the width of the panel
 * @author ?
 */
@SuppressWarnings("serial")
public class GradientLooperFourColors extends JPanel {
	/* This method draws on the Graphics context.
	 * This is where your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//ready to paint
		super.paintComponent(canvas);
		
		//account for changes to window size
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		final int GRADIENT_DIVISIONS = 256;
		final int NUM_GRADIENT_BARS = 1;

		//TODO: Your code goes here
		int i = 0;
		int newWidth =(int) Math.ceil(width/GRADIENT_DIVISIONS);
		int y = height/4;
		for(int x = 1; x < width; x+=newWidth) 
		{
				Color gray = new Color(i, i, i);
				canvas.setColor(gray);
				canvas.fillRect(x, y-y, newWidth, y);
				
				Color red = new Color(i, 0, 0);
				canvas.setColor(red);
				canvas.fillRect(x, y, newWidth, y);
				
				Color green = new Color(0, i, 0);
				canvas.setColor(green);
				canvas.fillRect(x, y*2, newWidth, y);
				
				Color blue = new Color(0, 0, i);
				canvas.setColor(blue);
				canvas.fillRect(x, y*3, newWidth, y);
				i++;
		}
		
	}
	/**
	 * DO NOT MODIFY
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 */
	public GradientLooperFourColors() 
	{
		setBackground(Color.black);
		int initWidth = 768;
		int initHeight = 512;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);
	}

	/**
	 * DO NOT MODIFY
	 * Starting point for the program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("GradientLooperGrayscale");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GradientLooperFourColors());
		frame.pack();
		frame.setVisible(true);
	}
}