import java.util.Random;
import java.util.ArrayList;

/**
 * Use an ArrayList to store a collection of objects and use a for-each loop to process the objects.
 * 
 * @author amit
 *
 */
public class ArrayListExercise {

    public static void main(String[] args)
    {
        Random rand = new Random();
        final int RADIUS_MAX = 100;
        //TODO: declare a constant for the number of spheres NUM_SPHERES and 
        //      initialize it appropriately
        int NUM_SPHERES = 100;

        //TODO: Declare the ArrayList to hold the Sphere objects
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        
        //TODO: Create the spheres using a normal for loop and add them to an ArrayList<Sphere> 
        for(int x = 0; x < NUM_SPHERES; x++)
        {
        	Sphere s = new Sphere(rand.nextInt(RADIUS_MAX));
        	spheres.add(s);
        //	System.out.println("Sphere " + x);
        }
      
      //TODO: Convert to a for-each loop to print out the spheres
       
        double volume;
        double area;
        double radius;
        for(Sphere s : spheres)
        {
        	System.out.println(s.toString());
        	/*volume = index.getVolume();
        	area = index.getSurfaceArea();
        	radius = index.getRadius();
        	System.out.println("Sphere " + index + "\t radius: " + volume + " \t area: " + area + "\t volume: " + volume + "\n");
        	*/
        }
        //TODO: Convert to a for-each loop to find the volume of the smallest sphere
        /*
        double min1 = Math.min(s1.getVolume(), s2.getVolume());
        double min2 = Math.min(s3.getVolume(), s4.getVolume());
        double min = Math.min(min1, min2);
        
        System.out.printf("Volume of the smallest sphere: %.2f\n", min);
    	*/
    }
}