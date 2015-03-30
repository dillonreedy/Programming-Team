import java.io.*;
import java.util.*;

public class RoundRobin
{
   // If anyone has an excess of turns
   //    then the person with the latest turn must be one of them.
   
   // n = 5, t = 17, minTurns = 0, excess = 0
   // minTurns = 0 + (0 + 17) / 5 => 3
   // excess = (0 + 17) % 5 => 2
   // n = n-1 => 4
   // (excess < 2) => false
   // excess = excess-1 => 1

   // n = 4, t = 17, minTurns = 3, excess = 1
   // minTurns = 
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int t = sc.nextInt();
         
         int minTurns = 0;
         int excess = 0;
         for (;;)
         {
            minTurns += (excess + t) / n;

            excess = (excess + t) % n;

            n--; // person leaving
            if (excess < 2) // at most the person leaving has excess.
            {
               System.out.println(n + " " + minTurns);
               break;
            }
            excess--; // person leaving among those with the excess turn.
         }

      }
   
   }

   public static void main(String args[])
   {
      new RoundRobin().doit();
   }
}