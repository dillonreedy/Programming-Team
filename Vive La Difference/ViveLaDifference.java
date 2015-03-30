import java.io.*;
import java.util.*;

public class ViveLaDifference
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         long a = sc.nextInt();
         long b = sc.nextInt();
         long c = sc.nextInt();
         long d = sc.nextInt();
         if (a==0 && b==0 && c==0 && d==0) 
            break;
      
         int steps = 0;
         while (a != b || b != c || c != d || d != a)
         {
            long newA = Math.abs(a-b);
            long newB = Math.abs(b-c);
            long newC = Math.abs(c-d);
            long newD = Math.abs(d-a);
         
            a = newA;
            b = newB;
            c = newC;
            d = newD;
            steps++;
         }
      
         System.out.println(steps);
      }
   }

   public static void main(String args[])
   {
      new ViveLaDifference().doit();
   }
}