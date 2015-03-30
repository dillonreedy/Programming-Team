import java.io.*;
import java.util.*;

public class CandyStore
{

   // Given 2 0.10
   // 700 0.02
   // 200 0.01

   // The table should end up as:
   // [0.00, 0.01, 0.02, 0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.10]
   // i = 1
   // j = 0, i-c[j] >= 0
   // [0,  , 200,   700,  900, 1400, 1600, 2100, 2300, 2800, 3000, 3500]

   public class Pair
   {
      int calories, price;
      Pair(int calories, int price)
      {
         this.calories = calories;
         this.price = price;
      }  
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int n = sc.nextInt(); // The number of different types of candy for sale.
         if (n==0) 
            break;
      
         int m = ((int) (sc.nextDouble() * 100.0)); // The amount of money we have to spend. Thus equivalent to calling Fib(8), etc.
      
      	// Make an array for all the previous amounts of money we can spend upon,
      	// this shall be our best[] array.
      
         int best[] = new int[m+1];
         Arrays.fill(best,0);
         Pair pairs[] = new Pair[n];
         for (int i = 0; i < n; i++) pairs[i] = new Pair(sc.nextInt(), ((int)(sc.nextDouble()*100.0)));
      
         // Iterate through all the prices between 0 and the total amount we can afford.
         for (int i = 1; i < m+1; i++)
            for (int j = 0; j < n; j++) 
               if (i-pairs[j].price >= 0) best[i] = Math.max(best[(i-pairs[j].price)] + pairs[j].calories, best[i]);
         
         System.out.println(best[best.length-1]);
      }
   }

   public static void main(String args[])
   {
      new CandyStore().doit();
   }
}