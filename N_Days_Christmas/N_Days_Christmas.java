import java.io.*;
import java.util.*;

public class N_Days_Christmas
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         long n = sc.nextLong();
         if (n==0) 
            break;
            
            System.out.println((n*(n+1)*(n+2)) / 6);
      }
   }

   public static void main(String args[])
   {
      new N_Days_Christmas().doit();
   }
}