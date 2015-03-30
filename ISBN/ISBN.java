import java.io.*;
import java.util.*;

public class ISBN
{
   public long convertCharToLong(char c)
   {
      char numbers[] = "0123456789X".toCharArray();
      
      for (int i = 0; i < numbers.length; i++) 
         if (c == numbers[i]) 
            return ((long) i);
      
      System.err.println("There is no character to convert this too!!!");
      return -1;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         String number = sc.next();
         if (number.equals("0")) 
            break;
         
         long sum = 0;
         
         for (long i = 9; i >= 0; i--) sum+=((i+1)*convertCharToLong(number.charAt(((int) i))));
         
         if (sum % 11 == 0) System.out.println("The number is a valid ISBN!");
         else System.out.println("The number is not a valid ISBN!");
      }
   }

   // 123456789X
   // (1*10)+(2*9)+(3*8)+(4*7)+(5*6)+(6*5)+(7*4)+(8*3)+(9*2)+(10*1)
   // 10+18+24+28+30+30+28+24+18+10
   // 28+52+60+52+28
   // 80+80+60
   // 160+60
   // 220
   // "The number is a valid ISBN"

   // 1234567891
   // 28+52+60+52+19
   // 80+71+60
   // 140+71
   // 211
   // "The number is not a valid ISBN"

   public static void main(String args[])
   {
      new ISBN().doit();
   }
}