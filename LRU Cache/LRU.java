import java.io.*;
import java.util.*;

public class LRU
{
   public void printout(ArrayList<Character> cache)
   {
      for (int k = 0; k < cache.size(); k++)
         System.out.print(cache.get(k));
      System.out.println();
   }
   
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      int count = 1;
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
      
         ArrayList<Character> cache = new ArrayList<Character>(n);
         String str = sc.next();
         
         System.out.println("Simulation " + count);
         for (int i = 0; i < str.length(); i++)
         {
            char c = str.charAt(i);
         	
            if (c!='!')
            {
               if (cache.contains(c)) // The cache already contains the character, remove it then requeue it.
               {
                  cache.remove(((Character)c));
                  cache.add(c);
               }
               else // The character is not in the cache
               {
                  if (cache.size() == n) // The cache is full and the cache does not contain the element.
                  {
                     cache.remove(0);
                     cache.add(c);  
                  }
                  else // The cache is not full and the cache does not contain the element.
                     cache.add(c);
               }
            }
            else if (c=='!') printout(cache);
            else System.err.println(c + " is an invalid input character!!!");
         }
         count++;
      }
   }

   public static void main(String args[])
   {
      new LRU().doit();
   }
}