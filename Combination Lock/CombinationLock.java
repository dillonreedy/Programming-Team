import java.io.*;
import java.util.*;

public class CombinationLock
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int t1 = sc.nextInt();
         int t2 = sc.nextInt();
         int t3 = sc.nextInt();
      
         int totalTicks = (3*n)+(n-1); // This is for the 3 revolutions, and the worst case scenario turning at the beginning.
         
         // Turn counter clockwise towards t2
         // Thus the numbers are increasing
         // and so if t1 is less than t2, then the number is ahead of us and so we can just make a subtraction
         // if t1 is greater than t2, then the number is behind us on the number line so we need to add a full n to it. 
         if (t1 < t2) totalTicks += t2-t1;
         else totalTicks += (t2+n)-t1;
         
         // Turn clockwise towards t3 from t2
         // Thus the numbers are decreasing on the number line.
         // If t2 is greater than t3, then the number is ahead of us and so we can just make a subtraction of t2 from t3.
         // If t3 is greater than t2, then the number is behind us on the number line and we have to add an n to t2.
         if (t2 > t3) totalTicks += t2 - t3;
         else totalTicks += (t2+n) - t3;
         
         System.out.println(totalTicks);
      }
   }

   public static void main(String args[])
   {
      new CombinationLock().doit();
   }
}