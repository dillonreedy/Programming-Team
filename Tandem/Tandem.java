import java.io.*;
import java.util.*;

// MUST FIND A SOLUTION IN O(N*LOG(N)) TIME!!!!
// Primitive Tandem Repeat - Tandem Repeats which do not contain shorter tandem repeats.





public class Tandem
{
   public String removeLast(String origWord)
   {
      int m = origWord.length();
      return origWord.substring(0,m-1);
   }
   
   public boolean lastCharsSame(String str1, String str2)
   {
      int m1 = str1.length();
      int m2 = str2.length();
      char c1 = str1.charAt(m1-1);
      char c2 = str2.charAt(m2-1);
      return (c1==c2);
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         String word = sc.next();
         if (word.equals("0")) 
            break;
         
         int n = word.length();
         
         
         
      }
   }

   public static void main(String args[])
   {
      new Tandem().doit();
   }
}