import java.io.*;
import java.util.*;

public class Profit
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
      
         int nums[] = new int[n];
         for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
      
      	// Kandane's Algorithm
      	// Initialize:
      	//		max_so_far = 0
      	//		max_ending_here = 0
      
         int max_so_far = Integer.MIN_VALUE;
         int max_ending_here = 0;
         
         // {-3, 4, 9, -2, -5, 8}
         // i=0
         // max_ending_here = -3
         // (max_so_far < max_ending_here) => True
         // max_so_far = -3
         // (max_ending_here < 0) => True
         // max_ending_here = 0
      
         // i=1
         // max_ending_here = 4
         // (max_so_far < max_ending_here) => True
         
      
         for (int i = 0; i < n; i++)
         {
            max_ending_here += nums[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
            max_ending_here = Math.max(0, max_ending_here);
         }
         System.out.println(max_so_far);
      }
   }

   public static void main(String args[])
   {
      new Profit().doit();
   }
}