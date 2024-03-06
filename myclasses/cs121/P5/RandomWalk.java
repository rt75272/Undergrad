/**Random Walk
 * 
 * @author Ryan Thompson
 * 
 * Initiates the methods to be used for the creation of a random walk
 */

import java.awt.*;
import java.util.*;

/** 
 * Initialization
 */
public class RandomWalk 
{
	private boolean done;
	private Random rand;
	private int size;
	private ArrayList<Point> path;
	private int xCoordinate;
	private int yCoordinate;
	int dx, dy;
		/**
		 * @param gridSize
		 * Uses gridSize to start a new path
		 */
		public RandomWalk(int gridSize) 
		{		
			size = gridSize;
			rand = new Random();
			path = new ArrayList<Point>();
			Point start = new Point(1, size);
			xCoordinate = start.x;
			yCoordinate = start.y;
		}
		/** 
		 * @param gridSize, seed
		 * Uses gridSize to create a new path, and seed to give the random number a range.
		 */
		public RandomWalk(int gridSize, long seed)
		{
			size = gridSize;
			rand = new Random(seed);
			path = new ArrayList<Point>();
			Point start = new Point(-1, size-1);
			xCoordinate = start.x;
			yCoordinate = start.y;
		}
		/** 
		 * Decides to move North or East, then moves the point.
		 * If the point has reached the top right of the screen, the variable done is 
		 *   set to true and the point no longer moves.
		 */
		public void step()
		{
			Point p1;
			int randomNum = rand.nextInt();
			if(randomNum < randomNum/2 && xCoordinate < size-1) 
			{
				p1 = new Point(xCoordinate += 1, yCoordinate);
				path.add(p1);
				dx = xCoordinate;
			}
			else if(randomNum > randomNum/2 && yCoordinate > 0)
			{
				p1 = new Point(xCoordinate, yCoordinate -= 1);
				path.add(p1);
				dy = yCoordinate;
			}
			if(dx == size-1 && dy == 0)
			{
				done = true;
			}
		}
		/** 
		 * @return dx
		 * Returns the x coordinate of the point which is used in step() 
		 *  to find if the point has moved all the way to the East.
		 */
		public int xDone()
		{
			return dx;
		}
		/** 
		 * @return dy
		 * Returns the y coordinate of the point which is used in step()
		 *   to find if the point has moved all the way to the North.
		 */
		public int yDone()
		{
			return dy;
		}
		/**
		 * Calls the step() method which moves the point has moved all the 
		 *  way North and East
		 */
		public void createWalk()
		{
			step();
		}
		/**
		 * @return done
		 * done turns true once the point has moved all the way North and East, 
		 *   which makes the point stop moving.
		 */
		public boolean isDone()
		{
			return done;
		}
		/**
		 * @return path
		 * path is a array list that contains all of the moves the points makes
		 */
		public ArrayList<Point> getPath()
		{
			return path;
		}
		/**
		 * @return an empty string to keep eclipse happy.
		 * Uses a for-each loop to go over all of the paths that the point makes
		 * Prints the x coordinate and the y coordinate of each path.
		 */
		public String toString()
		{
			for(Point p : path)
			{
				System.out.print("[" + p.x + "," + p.y + "] ");
			}
			return "";
		}
}
