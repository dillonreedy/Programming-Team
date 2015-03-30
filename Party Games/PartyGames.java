import java.io.*;
import java.util.*;

public class PartyGames
{
	// FRED, JOE, MARGARET, SAM
	// lowerName = JOE, upperName = MARAGARET
   // lowerName.charAt(0)+1 != upperName.charAt(0)
   // 'K' != 'M'
   // result = result + lowerName.charAt(0)+1
   // return result => return "K"


   // lowerName = FRED, upperName = FREDDIE
   // "FREDDIE".indexOf("FRED") == 0 => True
   // return "FRED"

   // lowerName = "ZY", upperName = "Z"
   // 

   // ['X', 'Y', 'Z']
   // ['Y', 'Z']


   public int alphabetIndex(char c)
   {
      char alphabet[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      for (int i = 0; i < alphabet.length; i++)
      {
         if (c == alphabet[i]) 
            return i;
      }
   
      System.err.println("There has been a letter input into this alphabet that's not there!!!");
      return -1;
   }

   public void doit() throws Exception
   {
      //Scanner sc = new Scanner(System.in);
      Scanner sc = new Scanner(new File("partyGamesInput.txt"));
      PrintStream ps = new PrintStream(new File("outputPartyGames.txt"));
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         sc.nextLine();
         String names[] = new String[n];
         for (int i = 0; i < n; i++) names[i] = sc.nextLine();
      
         Arrays.sort(names);
      	     
         int lower = (n/2)-1;
         int upper = (n/2);
      
         String lowerName = names[lower];
         String upperName = names[upper];
      	
         String result = "";
      
         if (upperName.startsWith(lowerName)) // Then lowerName is a prefix of upperName
         {
            result = lowerName;
         } 
         else
         {
            int m = Math.min(lowerName.length(), upperName.length());
            for (int i = 0; i < m; i++)
            {
               if (lowerName.charAt(i) == upperName.charAt(i))
               {
                  result += lowerName.charAt(i);
               }
               else
               {
                  result += ((char)(((int) lowerName.charAt(i))+1));
                  break;
               }
            }

            if (lowerName.startsWith(result))
            {
               result = result.substring(0,result.length()-1) + ((char)result.charAt(result.length())-1);
            }
         }
      
         ps.println(result);
      }
   }

   public static void main(String args[]) throws Exception
   {
      new PartyGames().doit();
   }
}