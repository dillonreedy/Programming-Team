import java.io.*;
import java.util.*;
import java.text.*;

// "000121" - 0
// 121
// 122
// 

public class Palindrometer
{
   public String reverse(String str)
   {
      String rev = "";
      for (int i = str.length() - 1; i >= 0; i--) rev += str.charAt(i);  
      return rev;
   }

   public boolean isPalin(String orig)
   {
      return orig.equals( reverse(orig) );
   }

   public String updateLong(String str)
   {
      long num = Long.parseLong(str, 10) + ((long)1);
      
      String pattern = "";
      for (int i = 0; i < str.length(); i++) pattern+="0";
   
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(num);
      
      return output;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      String orig = sc.nextLine();
      while (!orig.equals("0"))
      {
         String nextPalin = orig;
         
         while (!isPalin(nextPalin)) nextPalin = updateLong(nextPalin);
      
         System.out.println(Long.parseLong(nextPalin,10)-Long.parseLong(orig,10));
         orig = sc.nextLine();
      }
   }

   public static void main(String args[])
   {
      new Palindrometer().doit();
   }
}