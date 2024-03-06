/**Box.java
 *
 *@author Ryan Thompson
 *
 *Builds and fills boxes
 */
import java.text.DecimalFormat;

public class Box {
        private double width;
        private double height;
        private double depth;
        private double volume;
        private double area;
        private boolean full;

        DecimalFormat fmt = new DecimalFormat("0.00");

        public Box(double widthInput, double heightInput, double depthInput)
        {
                width = widthInput;
                height = heightInput;
                depth = depthInput;
                full = false;
        }
        /**
         * 
         * @returns if the box is full or not
         */
        public boolean getFull()
        {
        	return full;
        }
        /**
         * 
         * @param fullInput
         * @returns if the box is full or empty
         */
        public boolean setFull(boolean fullInput)
        {
        	full = fullInput;
        	return full;
        }
        /**
         * 
         * @return a message stating if it is "A full" box or "An empty" box
         */
        public String message()
        {
           	String fullOrNot;
            if(full == true) 
            {
            	fullOrNot = " A full";
            }
            else 
            {
            	fullOrNot = " An empty";
            }
            return fullOrNot;
        }
        /** 
         * @returns the depth of the box
         */
        public double getDepth()
        {
                return depth;
        }
        /**
         * @sets the depth of the box
         */
        public void setDepth(double depthInput)
        {
                depth = depthInput;
        }
        /**
         * @returns the height of the box
         */
        public double getHeight()
        {
                return height;
        }
        /**
         * 
         * @sets the height of the box
         */
        public void setHeight(double heightInput)
        {
                height = heightInput;
        }
        /**
         * 
         * @returns the width of the box
         */
        public double getWidth()
        {
                return width;
        }
        /**
         * 
         * @sets the width of box
         */
        public void setWidth(double widthInput)
        {
                width = widthInput;
        }
        /**
         * 
         * @returns calculates and returns the volume of the box
         */
        public double getVolume()
        {
                volume = width * height * depth;
                return volume;
        }
        /**
         * 
         * @returns the surface area of the box
         */
        public double getSurfaceArea()
        {
                area = 2*(width*height) + 2*(height*depth) + 2*(width*depth);
                return area;
        }
        /**
         * 
         * @returns the width, height, and depth of the box in String format.
         */
        public String toString()
        {
        	return message() + " " + fmt.format(width) + " x " + fmt.format(height) + " x " + fmt.format(depth);
        }
        public String toString1()
        {
        	String fullOrNot;
            if(full == true) 
            {
            	fullOrNot = "full";
            }
            else 
            {
            	fullOrNot = "empty";
            }
           // System.out.println(fullOrNot);
                return "A " + fullOrNot  + " " + fmt.format(width) + " x " + fmt.format(height) + 
                				" x " + fmt.format(depth) + " box" +
                                "\nsmallbox's witdh = " + fmt.format(width) +
                                "\nsmallbox's height = " + fmt.format(height) +
                                "\nsmallbox's depth = " + fmt.format(depth) +
                                "\nThe volume is: " + fmt.format(volume) +
                                "\nThe area is: " + fmt.format(area) +
                                "\nThe box is full: " + full;

        }
}
