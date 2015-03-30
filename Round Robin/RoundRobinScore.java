import java.io.*;
import java.util.*;

public class RoundRobinScore
{
   // [1,2,3,4,5]
   // [0,0,0,0,0]
   
   // 0 - 1
   // 1 - 2
   // 2 - 3
   // 3 - 4
   // 4 - 5
   // 0 - 6
   // 1 - 7
   // 2 - 8
   // 3 - 9
   // 4 - 10
   // 0 - 11
   // 1 - 12
   // 2 - 13
   // 3 - 14
   // 4 - 15
   // 0 - 16
   // 1 - 17

   public int calculateNextStart(int startPoint, int t, int scores[])
   {
      for (int startIndex = )
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int t = sc.nextInt();
         
         int scores[] = new int[n];
         Arrays.fill(scores, 0);
         
         
      }
   }

   public static void main(String args[])
   {
      new RoundRobinScore().doit();
   }
}