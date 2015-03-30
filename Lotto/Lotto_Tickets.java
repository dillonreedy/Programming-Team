import java.io.*;
import java.util.*;

public class Lotto_Tickets
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         boolean lis[] = new boolean[50];
         
         for (int i = 0; i < n; i++)
         {
            for (int j = 0; j < 6; j++)
            {
               lis[sc.nextInt()] = true;
            }
         }
         
         boolean isYes = true;
         for (int i = 1; i < 50; i++)
         {
            if (!lis[i])
            {
               isYes = false;
               break;
            }
         }
         
         if (isYes)
         {
            System.out.println("Yes");
         }
         else
         {
            System.out.println("No");
         }
      }
   }

   public static void main(String args[])
   {
      new Lotto_Tickets().doit();
   }
}