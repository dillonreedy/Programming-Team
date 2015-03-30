import java.io.*;
import java.util.*;



public class Fibonacci
{
	
		// In the context of algorithms, dynamic programming always refers
		// to the technique of filling in a table with values computed from
		// other table values!!!
		//
		// It's dynamic because the values in the table are filled in by 
		// the algorithm based on other values of the table.
		//
		// It's programming in the sense of setting things in a table,
		// like how television programming is concerned with when to
		// broadcast which shows.

		// Memoization Methodology
		// 1. Start with a backtracking algorithm
		//	2. Look up the problem in the table; if there's a valid entry for it, return that value.
		//	3. Otherwise, compute the problem recursively, and then store the result in the table before returning the value.
   public int getFib1(int n, int a[])
   {
      if (n==0 || n==1)
      {
         return n;
      }
      else if (a[n] != -1)
      {
         return a[n];
      }
      else
      {
         a[n] = getFib1(n-1, a) + getFib1(n-2, a);
         return a[n];
      }
   }
   
   public int getFib2(int n, int a[])
   {
      if (n==0 || n==1) 
         return n;
      
      int u = 0;
      int v = 1;
      
      for (int i = 2; i < n; i++)
      {
         int t = u + v;
         u = v;
         v = t;
      }
      
      return v;
   }
   
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int a[] = new int[n+1];
         Arrays.fill(a,-1);
      
         System.out.println(getFib1(n, a));
         
         System.out.println(getFib2(n, a));
      }
   }

   public static void main(String args[])
   {
      new Fibonacci().doit();
   }
}