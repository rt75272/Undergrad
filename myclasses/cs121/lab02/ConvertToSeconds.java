/**
 *
 *This class take time in hours, minutes, and seconds, Then converts it all to seconds.
 *
 *@author Ryan Thompson
 */

public class convertToSeconds 
{
  public static void main(String[] args)
  {
  int hours = 1;
  int minutes = 30;
  int seconds = 3;
  int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
  
  System.out.println(
		  "Hours: " + hours + "\n" +
		  "Minutes: " + minutes + "\n" +
		  "Seconds: " + seconds + "\n" +
		  "Total seconds = " + totalSeconds);
  }
}