import java.io.*;
import java.util.*;

public class HorT
{
   int dx[] = {0,0,1,-1};
   int dy[] = {1,-1,0,0};

   public boolean[][] selectCoin(int i, int j, int n, int m, boolean table[][])
   {
      table[i][j] = !table[i][j];
      for (int k = 0; k < 4; k++)
      {
         int x = i+dx[k];
         int y = j+dy[k];
         
         if ((0<=x && x<m)
         &&  (0<=y && y<n))
         {
            table[x][y] = !table[x][y];
         }
      }
      
      return table;
   }

   public void printOutTable(int n, int m, boolean table[][])
   {
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            System.out.print(table[i][j] + " ");
         }
         System.out.println();
      }
   }
   // Given a 2 by 1 board
   // a=1, b=2
   // Then the number of final position states are:
   // 1:[True, False]
   // 2:[False, True]
   // 3:[True, True]
   // True is heads, False is tails
   // k = 1
   // 1:[False, True] => TH
   // 2:[True, False] => HT
   // 3:[False, False]=> TT
   
   

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int m = sc.nextInt();
      	// false shall equal tails
      	// true shall equal heads
         boolean table[][] = new boolean[m][n];
         
         int t = sc.nextInt();
         for (int i = 0; i < t; i++)
         {
            table = selectCoin(sc.nextInt(), sc.nextInt(), n, m, table);
            // She can't remember if she pushed a coin more than once.
            printOutTable(n, m, table); 
         }
      
      }
   }

   public static void main(String args[])
   {
      new HorT().doit();
   }
}