import java.awt.Dimension;
import javax.swing.JFrame;
/**
 * @author Ryan Thompson
 *
 * This class is the driver for the 
 * MineWalkerPanel class.
 */
public class MineWalker 
{
		public static void main(String[] args)
		{
			JFrame frame = new JFrame("Minewalker");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setMinimumSize(new Dimension(1500, 1000));
			MineWalkerPanel go = new MineWalkerPanel(frame);
			frame.getContentPane().add(go.getPanel());
			frame.pack();
			frame.setVisible(true);
		}
}
