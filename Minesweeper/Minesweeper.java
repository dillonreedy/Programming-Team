import java.io.*;
import java.util.*;

public class Minesweeper
{
   public int d[][] = {{0,1},
   					{1,1},
   					{1,0},
   					{1,-1},
   					{0,-1},
   					{-1,-1},
   					{-1,0},
   					{-1,1}};

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int r = sc.nextInt();
         int c = sc.nextInt();
         if (r==0 && c==0) 
            break;
         sc.nextLine();
      
         boolean mine[][] = new boolean[r][c];
         for (int j = 0; j < r; j++)
         {
            char line[] = sc.nextLine().toCharArray();
            for (int i = 0; i < c; i++) 
               if (line[i] == '*') mine[j][i] = true;
         }
      
         int table[][] = new int[r][c];
         for (int i = 0; i < r; i++) Arrays.fill(table[i],0);
      
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               if (mine[i][j])
               {
                  for (int k = 0; k < 8; k++)
                  {
                     int x = (i+d[k][0]);
                     int y = (j+d[k][1]);
                  
                     if ((0 <= x) && (x < r)
                     &&  (0 <= y) && (y < c))
                     {
                        table[x][y]++;
                     }
                  }
               }
            }
         }
      
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               if (mine[i][j])
               {
                  System.out.print("*");
               }
               else
               {
                  System.out.print(table[i][j]);
               }
            }
            System.out.println();
         }
      
      }
   }

   public static void main(String args[])
   {
      new Minesweeper().doit();
   }
}