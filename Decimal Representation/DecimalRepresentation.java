import java.io.*;
import java.util.*;
import java.text.*;

public class DecimalRepresentation
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         double n = sc.nextDouble();      
         if (n==0) break;

         for (double i = 1.0; i < n; i+=1.0)
         {
            for (double j = 1.0; j < n; j+=1.0)
            {
               String str = ""+(i/j);
               if (str.endsWith(".0"))
               {
                  System.out.print(((int)(i/j)) + " ");
               }
               else
               {
                  System.out.print((i/j) + " ");
               }
            }
            System.out.println();
         }
      }
   }

   public static void main(String args[])
   {
      new DecimalRepresentation().doit();
   }
}