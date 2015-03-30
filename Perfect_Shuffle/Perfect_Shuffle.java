import java.io.*;
import java.util.*;

public class Perfect_Shuffle
{

   public void readInReverse(String lis[])
   {
      for (int i = lis.length - 1; i > -1; i--)
      {
         System.out.println(lis[i]);
      }
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         String lis[] = new String[n];
         if (n==0) 
            break;
         
         for (int i = 0; i < n; i++) lis[i] = sc.next();
        
        
         if (n%2 == 0)
         {
            for (int i = 0; i < (n/2); i++)
            {
               System.out.println(lis[i]);
               System.out.println(lis[i+(n/2)]);
            }
         }
         else
         {
         
            for (int i = 0; i < (n/2); i++)
            {
               System.out.println(lis[i]);
               System.out.println(lis[i+(n/2)+1]);
            }
            System.out.println(lis[(n/2)]);
         
         }
      }
   }
   
   public static void main(String args[])
   {
      new Perfect_Shuffle().doit();
   }
}