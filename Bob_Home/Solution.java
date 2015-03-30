// DP Problem
import java.io.*;
import java.util.*;

public class Solution {

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         // Create an array V, representing all the coin values, of size N.   
         int V[] = new int[n];
         for (int i = 0; i < n; i++) V[i] = sc.nextInt();
         
         int S = sc.nextInt();
         // Create an array min, representing all the minimum number of coins to get a sum S, of Size S+1.
         int min[] = new int[S+1];
         for (int i = 0; i < S+1; i++) min[i] = Integer.MAX_VALUE;
         min[0] = 0;
         
         for (int i = 1; i < S+1; i++)
         {
            for (int j = 0; j < n; j++)
            {
               if (V[j] <= i)
                  if (min[i-V[j]]+1 < min[i]) min[i] = min[i-V[j]]+1;
            }
            
            for (int k = 0; k < S+1; k++)
            {
               if (min[k] == Integer.MAX_VALUE) 
                  break;
               System.out.print(min[k] + " ");
            }
            System.out.println();
         }
         
         System.out.println(min[S]);
      }
   }

   public static void main(String args[])
   {
      new Solution().doit();
   }
}