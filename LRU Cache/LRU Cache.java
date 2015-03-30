import java.io.*;
import java.util.*;

// cache = ['', '', '', '', '']
// []

public class LRU
{
   public void printout(ArrayList<char> cache)
   {
      for (int k = 0; k < cache.size(); k++)
         System.out.print(cache.get(k));
      System.out.println();
   }

   public char[] removeChar(char c, char cache[])
   {
      for (int k = 0; k < cache.length; k++)
         if (cache[k] == c)
         {
            cache[k] = ' ';
            String str = String.valueOf(cache);
            str+=" ";
            return str.toCharArray();
         }
   
      System.err.println("The character wasn't in there!!!");
      return null;
   }


   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         ArrayList<char> cache = new ArrayList<char>(n);
         System.out.println(cache.size());
         String str = sc.next();
      
         for (int i = 0; i < str.length(); i++)
         {
            char c = str.charAt(i);
         	
            if (c!='!')
            {
               if (cache.contains(c))
               {
                  cache.remove(c);
                  cache.add(c);
               }
               else // The character is not in the cache
               {
                  //if (spaceInCache(cache))
                  //{
                  	// Place the character in the next empty space
                     //cache = placeInNextEmpty(c, cache);
                  //}
                  //else
                  //{
                  	// The cache is full.
                    // cache = removeFirst(cache);
                     //cache = shiftLeft(cache);
                     //cache[cache.length-1] = c;
                  //}
               }
            }
            else if (c=='!')
            {
               printout(cache);
            }
         
         }
      
      
      }
   }

   public static void main(String args[])
   {
      new LRU().doit();
   }
}