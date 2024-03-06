/**BoxTest.java
 *
 *@author Ryan Thompson
 *
 *Getting data from Box.java
 */
import java.util.*;
import java.util.Collections;
import java.text.DecimalFormat;

public class BoxTest {

        /**
         * @param args
         */
        public static void main(String[] args)
        {
                Random rand = new Random();
                Box smallBox = new Box(5.01, 4.5, 2.2);
                smallBox.toString1();
                smallBox.getVolume();
                smallBox.getSurfaceArea();
                DecimalFormat fmt = new DecimalFormat("0.00");
                System.out.println(smallBox.toString1() + "\n");
                System.out.println("======Change smallbox using it's setter======\n");
              
                smallBox.setDepth(1.05);
                smallBox.setHeight(3.82);
                smallBox.setWidth(2.32);
                smallBox.setFull(true);
                smallBox.getVolume();
                smallBox.getSurfaceArea();
                smallBox.toString1();
                
                System.out.println(smallBox.toString1() + "\n");
                System.out.println("======Create 5 boxes======\n");
                
                ArrayList<Box> boxes = new ArrayList<Box>();
                ArrayList<Double> order = new ArrayList<Double>();
                
                for(int i = 0; i < 5; i++)
                {
                        Box newBox = new Box(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
                        boxes.add(newBox);
                        double w = newBox.getWidth();
                        double h = newBox.getHeight();
                        double d = newBox.getDepth();
                        double v = newBox.getVolume();
                        boolean full = newBox.setFull(rand.nextBoolean());
                        String message = newBox.message();
                        order.add(v);
                       
                        System.out.println("Box " + i + ":\t" + newBox.toString() + " box."); 
                }

                System.out.println("\n======Find the largest box======\n");
                System.out.println("Largest box");
                Collections.sort(order);
                Box largest = new Box(0, 0, 0);
                for(Box x : boxes) 
                {
                	if(largest.getVolume() < x.getVolume())
                		{
                			largest = x;
                		}
            
                }
                System.out.println(largest.toString());
        }
}
