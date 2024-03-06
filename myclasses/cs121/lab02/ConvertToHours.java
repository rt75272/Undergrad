/**
 *
 *This class take time in hours, minutes, and seconds, Then converts it all to hours.
 *
 *@author Ryan Thompson
 */

public class ConvertToHours 
{
  public static void main(String[] args)
  {
  int hours = 1;
  int minutes = 28;
  int seconds = 42;
  int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
  double fHours = (double) totalSeconds / 3600; //casting to a double for decimals!
  
  System.out.println(
		  "Total seconds = " + totalSeconds + "\n" +
		  "Hours: " + hours + "\n" +
		  "Minutes: " + minutes + "\n" +
		  "Seconds: " + seconds + "\n" + "\n" +
		  "Fractional Hours = " + fHours);
  }
}