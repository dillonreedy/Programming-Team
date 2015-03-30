import java.io.*;
import java.util.*;

public class Speed_Cost
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int distance = sc.nextInt();
         double s1 = sc.nextInt();
         double s2 = sc.nextInt();
         
         if (distance==0 && s1 == 0.0 && s2==0.0) 
            break;
         
         // s1/3600 converts MPH to MPsecs
         // d / (s1 / 3600) is [miles]/[miles/secs])
         // Time, in seconds, to travel the given distance at the given speed.
            // distance/s1 and distance/s2 give the times in hours, since speed is in MPH
            // So, we've got to multiply by 60*60 to convert hours to seconds
         double t1 = distance * 60.0 * 60.0 / s1;
         double t2 = distance * 60.0 * 60.0 / s2;
            
            // Difference in seconds, rounded
         int dt = (int)Math.round( t1-t2 );
            
            // Break out hours, minutes, seconds
         int seconds = dt % 60;
         int minutes = (dt / 60) % 60;
         int hours = dt / 60 / 60;
            
         System.out.printf( "%d:%02d:%02d", hours, minutes, seconds );
         System.out.println();
      }
   }

   public static void main(String args[])
   {
      new Speed_Cost().doit();
   }
}