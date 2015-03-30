import java.io.*;
import java.util.*;

public class Quine
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      String q = sc.nextLine().trim();
      while (!q.equals("END"))
      {
      	// Here q is a valid line
         int firstQuoteIndex = q.indexOf('\"');
         int nextQuoteIndex = q.indexOf('\"', 1);
         int endIndex = q.indexOf("\" ");
         int n = q.length();
      
         if (firstQuoteIndex == 0
         &&  nextQuoteIndex == endIndex
         &&  endIndex > 0)
         {
            String a = q.substring(1, endIndex);
            if (a.equals(q.substring(endIndex+2)))
            {
               System.out.println("Quine(" + a + ")");
            }
            else
            {
               System.out.println("not a quine");
            }
         }
         else
         {
            System.out.println("not a quine");
         }
         
         
         q = sc.nextLine().trim();
      }
   }

   public static void main(String args[])
   {
      new Quine().doit();
   }
}