import java.io.*;
import java.util.*;

public class Top25
{
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String lis1[] = new String[n];
      String lis2[] = new String[n];
      sc.nextLine();
      for (int i = 0; i < n; i++) lis1[i] = sc.nextLine();
   
      for (int i = 0; i < n; i++) lis2[i] = sc.nextLine();

      HashSet<String> h1 = new HashSet<String>();
      int count = 1;
      for (int i = 0; i < n; i++)
      {
         if (!h1.remove(lis1[i])) h1.add(lis1[i]);
         if (!h1.remove(lis2[i])) h1.add(lis2[i]);
         if (h1.isEmpty())
         {
            System.out.println(count);
            count=0;
         }
         count++;
      }
   }

   public static void main(String args[])
   {
      new Top25().doit();
   }
}