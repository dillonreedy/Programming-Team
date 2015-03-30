import java.io.*;
import java.util.*;

public class DuelingPhilosphers
{
   // 5 4
   // 1 5
   // 5 2
   // 3 2
   // 4 3

   // n = 5, numE = 4, eList[] = [new Vertex()..]
   // eList[0].out => [].add(4) => [4]
   // eList[4].in  => [].add(0) => [0]
   // eList[4].out => [].add(1) => [1]
   // eList[1].in  => [].add(4) => [4]
   // eList[2].out => [].add(1) => [1]
   // eList[1].in  => [4].add(2) => [4,2]
   // eList[3].out => [].add(2) => [2]
   // eList[2].in  => [].add(3) => [3]
   // ..
   // (out, in)
   // eList[] = [([4],[]), ([],[4,2]), ([1],[3]), ([2],[]), ([1],[0])]
   // ordering[] = [0,0,0,0,0]
   // used[] = [false,..]
   //
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt(); // 1 <= n <= 1,000
         if (n==0) 
            break;
         int numE = sc.nextInt(); // 1 <= m <= 500,000
         
         // Set up ordering matrix
         vertex eList[] = new vertex[n];
         for (int i = 0; i < n; i++) eList[i] = new vertex();
         // Put in edges in both the appropriate in and out degree lists
         for (int i = 0; i < numE; i++)
         {
            int v = sc.nextInt()-1;
            int w = sc.nextInt()-1;
            eList[v].out.add(w);
            eList[w].in.add(v);
         }

         // run a topological sort
         topSort prob = new topSort(eList);
         System.out.println(prob.runAlg());
      }
   }

   public class vertex
   {
      public HashSet<Integer> in;
      public HashSet<Integer> out;

      public vertex()
      {
         in = new HashSet<Integer>();
         out = new HashSet<Integer>();
      }
   }

   public class topSort
   {
      // Easier to run our sort storing all this stuff in an object.
      int ordering[];
      boolean used[];
      int n;
      vertex eList[];

      public topSort(vertex eList[])
      {
         this.eList = eList;
         n = eList.length;
         used = new boolean[n];
         ordering = new int[n];
      }

      // Here is our topological sort, adjusted to return 0, 1, or 2,
      // for 0, 1, or more than one possible sorted output.
      public int runAlg()
      {
         // Fill spots forward.
         int curIndex = 0;
         int retVal = 1;

         while (curIndex < n)
         {
            // pre-count vertices in this step.
            int cnt = 0;
            int remove[] = new int[n];
            for (int i = 0; i < n; i++) if (!used[i] && eList[i].in.size() == 0) remove[cnt++] = i;

            // If no vertices have in degree 0 at any iteration, algorithm fails.
            if (cnt==0) return 0;

            // Stores that if we find 1 viable option later, there must be at least 2.
            if (cnt > 1) retVal = 2;

            // Now process 0 degree vertices, deleting them
            for (int i = 0; i < cnt; i++)
            {
               // Put this item in our list
               ordering[curIndex] = remove[i];
               curIndex++;
               used[remove[i]] = true;

               // Remove edges leaving i
               for (Integer e : eList[remove[i]].out)
               {
                  eList[e].in.remove(remove[i]);
               }
            }
         }
         return retVal;
      }
   }

   public static void main(String args[])
   {
      new DuelingPhilosphers().doit();
   }
}