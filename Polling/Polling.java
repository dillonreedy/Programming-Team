import java.io.*;
import java.util.*;

public class Polling
{
	// BARNEY, BARNEY, FRED, FRED, FRED
	// 
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      int n = sc.nextInt();
   	sc.nextLine();
      String names[] = new String[n];
      for (int i = 0; i < n; i++)
      {
         names[i] = sc.nextLine();
      }
   
      Arrays.sort(names);
   
      Map<String, Integer> map = new HashMap<String, Integer>();
      for (String s : names)
      {
         if (map.containsKey(s))
         {
            map.put(s, map.get(s)+1);
         }
         else
         {
            map.put(s,1);
         }
      }
   
      int most = Integer.MIN_VALUE;
      for (String s : names) most = Math.max(map.get(s), most);
   
      ArrayList<String> results = new ArrayList<String>();
      for (String s : names)
      {
         if ((map.get(s) == most) && (!results.contains(s))) results.add(s);
      }
   
      for (int i = 0; i < results.size(); i++) System.out.println(results.get(i));
   }

   public static void main(String args[])
   {
      new Polling().doit();
   }
}