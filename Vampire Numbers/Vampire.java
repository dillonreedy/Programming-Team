import java.io.*;
import java.util.*;

public class Vampire
{
   public String signature(String s)
   {
      char a[] = s.toCharArray();
      Arrays.sort(a);
      return new String(a);
   }

   public boolean isVampire(int num)
   {
      String sig = signature("" + num);
      
      for (int i = 2; (i*i) < num; i++) 
         if (num%i==0)
         {
            String isig = signature("" + i + "" + (num/i));
            if (isig.equals(sig)) 
               return true;
         }
         
      return false;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      int X = sc.nextInt();
   
      while (X != 0)
      {
         while (!isVampire(X)) ++X;
         
         System.out.println(X);
         X = sc.nextInt();
      }
   
   }

   public static void main(String args[])
   {
      new Vampire().doit();
   }
}