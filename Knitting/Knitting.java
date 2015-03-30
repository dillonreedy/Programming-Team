import java.io.*;
import java.util.*;

public class Knitting
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt(); // The number of stictches in the first row. 
         if (n==0) 
            break;
         int m = sc.nextInt(); // The total number of rows in the project.
         int k = sc.nextInt(); //
      
         ArrayList<Integer> sequence = new ArrayList<Integer>();
         for (int i = 0; i < k; i++) sequence.add(sc.nextInt());
      
         int count = k;
         while (sequence.size() < m)
         {
            sequence.add(sequence.get((count%k)));
            count++;
         }
      
         int knits[] = new int[m+1];
         knits[1] = n;
      
         for (int i = 2; i < m+1; i++) knits[i] = knits[i-1] + sequence.get(i-2);
         
         int sum = 0;
         for (int j = 0; j < knits.length; j++) sum+=knits[j];
         
         System.out.println(sum);
      }
   }

   public static void main(String args[])
   {
      new Knitting().doit();
   }
}