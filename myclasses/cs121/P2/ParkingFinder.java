import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
import java.text.NumberFormat;

public class ParkingFinder
{
        public static void main(String[] args)
        {
        	
        		//General setup
                Scanner scan = new Scanner(System.in);
                Random randomGenerator = new Random();
                System.out.print("Enter random seed: ");
                int userInput = scan.nextInt();
                NumberFormat nf = NumberFormat.getCurrencyInstance();

                
                //Cost interval
                ParkingSpot parkingData = new ParkingSpot(" ", 1, 1);
                System.out.print("Enter parking time (minutes): ");
                double parkingMinutes = scan.nextDouble();
                double costInterval = parkingData.getCostPerInterval();
                int conversion = (int)(parkingMinutes/10);
                double totalCost = conversion * costInterval;
 
                
                //Automobile
                int carX = randomGenerator.nextInt(userInput);
                int carY = randomGenerator.nextInt(userInput);
                System.out.println("\nPosition of automobile: x = " + carX + " y = " + carY);
                
                
                //Parking spot 1
                int xCoord = randomGenerator.nextInt(userInput);
                int yCoord = randomGenerator.nextInt(userInput);
                ParkingSpot spot0 = new ParkingSpot("1st Street", xCoord, yCoord);
                int distance = (carX - xCoord) + (carY - yCoord);
                if(distance < 0)
                {
                	distance = distance * (-1);
                }
                int distance0 = distance;
                System.out.println("\nSpot 1: " + spot0);
                System.out.println("\tDistance: " + distance);
                System.out.println("\tCost: " + nf.format(totalCost) + "\n");
                
                
                //Parking spot 2
                xCoord = randomGenerator.nextInt(userInput);
                yCoord = randomGenerator.nextInt(userInput);
                ParkingSpot spot1 = new ParkingSpot("2nd Street", xCoord, yCoord);
                distance = (carX - xCoord) + (carY - yCoord);
                if(distance < 0)
                {
                	distance = distance * (-1);
                }
                int distance1 = distance;
                System.out.println("\nSpot 2: " + spot1);
                System.out.println("\tDistance: " + distance);
                System.out.println("\tCost: " + nf.format(totalCost) + "\n");
               
                
                //Parking spot 3
                xCoord = randomGenerator.nextInt(userInput);
                yCoord = randomGenerator.nextInt(userInput);
                ParkingSpot spot2 = new ParkingSpot("3rd Street", xCoord, yCoord);
                spot2.setCostPerInterval(0.30);
                costInterval = spot2.getCostPerInterval();
                totalCost = conversion * costInterval;
                totalCost = Math.round(totalCost * 100.0) / 100.0;
                if(distance < 0)
                {
                	distance = distance * (-1);
                }
                int distance2 = distance;
                System.out.println("\nSpot 2: " + spot2);
                System.out.println("\tDistance: " + distance);
                System.out.println("\tCost: " + nf.format(totalCost)  + "\n");
                
               
                //Parking spot 4
                xCoord = randomGenerator.nextInt(userInput);
                yCoord = randomGenerator.nextInt(userInput);
                ParkingSpot spot3 = new ParkingSpot("4th Street", xCoord, yCoord);
                spot3.setCostPerInterval(0.30);
                costInterval = spot3.getCostPerInterval();
                totalCost = conversion * costInterval;
                totalCost = Math.round(totalCost * 100.0) / 100.0;
                distance = (carX - xCoord) + (carY - yCoord);
                if(distance < 0)
                {
                	distance = distance * (-1);
                }
                int distance3 = distance;
                System.out.println("\nSpot 4: " + spot3);
                System.out.println("\tDistance: " + distance);
                System.out.println("\tCost: " + nf.format(totalCost)  + "\n");
                
                
                //Finding the closest spot
                int distanceOrder[] = {distance0, distance1, distance2, distance3};
                Arrays.sort(distanceOrder);
                System.out.println("Distance to closest spot: " + distanceOrder[0]);
                
                if(distance0 == distanceOrder[0])
                {
                	System.out.print("Closest spot: " + spot0);
                }
                else if(distance1 == distanceOrder[0])
                {
                	System.out.print("Closest spot: " + spot1);
                }
                else if(distance2 == distanceOrder[0])
                {
                	System.out.print("Closest spot: " + spot2);
                }
                else
                {
                	System.out.print("Closest spot: " + spot3);
                }
                
                scan.close();
        }
}
