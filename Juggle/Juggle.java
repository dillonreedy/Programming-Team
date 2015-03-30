import java.io.*;
import java.util.*;

public class Juggle
{

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
            
         ArrayList<Integer> sequence = new ArrayList<Integer>(20);
         for (int i = 0; i < n; i++)
            sequence.add(sc.nextInt());
      
         int k = n;
         while (sequence.size() != 20)
         {
            sequence.add(sequence.get((k%n)));
            k++;
         }
         
         char pattern[] = new char[21];
         Arrays.fill(pattern, ' ');
         int numBalls = 0;
         boolean isCrash = false;
         
         for (int i = 1; i < 21; i++)
         {
            int j = sequence.get(i-1)+i; // The next location the ball is supposed to land.

            if (pattern[i] == ' ') // Here we have to add a new ball, since the space is empty.
            {
               char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(numBalls);
               numBalls++;
               pattern[i] = c;
               
               if (j < 21) // If the next pattern spot is within range.
               {
                  if  (pattern[j] != ' ') // If the next spot is not empty, then we have crashed.
                  {
                     isCrash = true;
                     break;
                  }
                  else pattern[j] = c;
               }
            }
            else // Here we do not have to add a new ball.
            {
               char c = pattern[i];
               if (j < 21) // We test whether the next jump location is within bounds.
               {
                  if (pattern[j] != ' ') // Here we test to see if the next jump location is already taken, thus meaning a crash.
                  {  
                     isCrash = true;
                     break;
                  }
                  else pattern[j] = c; // If the 
               }
            }
         }
         
         if (!isCrash) System.out.println((String.valueOf(pattern)).substring(1, 21));
         else System.out.println("CRASH");
      }
   }

   public static void main(String args[])
   {
      new Juggle().doit();
   }
}