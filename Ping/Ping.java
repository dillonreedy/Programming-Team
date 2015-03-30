import java.io.*;
import java.util.*;

public class Ping
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      String line = sc.nextLine();
      while (!line.equals("0"))
      {
      	// If an even number of satellites ping
      	// then the string shall have zero.
      
      	// If an odd number of satellites ping
      	// then the string shall have one.
      
      	// The number of possible unique satellites is between 1 <= S <= N
      
      	// All satellites ping at time zero.
      	// After time zero, the satellites shall ping at their unique given time slot.
         char chars[] = line.toCharArray();
         if (chars.length == 1) 
            break;
      
         String results = "";
         for (int i = 1; i < chars.length; i++)
         {
            if (chars[i]=='1')
            {
               results+=i+" ";
               for (int j = i; j < chars.length; j+=i)
               {
                  if (chars[j]=='1')
                  {
                     chars[j] = '0';
                  }
                  else
                  {
                     chars[j] = '1';
                  }
               }
            }	
         }
         System.out.println(results);
         line = sc.nextLine();
      }
   }

   public static void main(String args[])
   {
      new Ping().doit();
   }
}