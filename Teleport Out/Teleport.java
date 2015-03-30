import java.util.*;
import java.io.*;

public class Teleport
{
   int dx[] = {0,0,1,-1};
   int dy[] = {1,-1,0,0};

   public class Pair
   {
      int x, y;
      Pair(int x, int y)
      {
         this.x = x;
         this.y = y;
      }
   }

   public int[][] computeAllDistances(char maze[][], int r, int c)
   {
      ArrayList<Pair> q = new ArrayList<Pair>();
      int result[][] = new int[r][c];
   
      for (int i = 0; i < r; i++)
      {
         for (int j = 0; j < c; j++)
         {
            if (maze[i][j] == 'E') // There's an exit here, set distances here equal to zero, and the (i,j) pair to the queue.
            {
               result[i][j] = 0;
               q.add(new Pair(i,j));
            }
            else if (maze[i][j] == 'X') // There's a blocked location here, set the distance here to negative infinity.
            {
               result[i][j] = Integer.MIN_VALUE;
            }
            else if (maze[i][j] == '.' || maze[i][j] == 'Y') // This is an empty space or a teleport location, set the distance here to positive infinity.
            {
               result[i][j] = Integer.MAX_VALUE;
            }
            else
            {
               System.err.println("The maze has an invalid character input into it!!!");
            }
         
         }
      }
   
      int steps = 0; // The number of steps we are away from a particular exit.
      while (steps < q.size())
      {
         Pair p = q.get(steps);
         steps++;
      
         for (int k = 0; k < 4; k++)
         {
            int x = p.x + dx[k];
            int y = p.y + dy[k];
         
            if ((x >= 0 && x < r)
            &&  (y >= 0 && y < c)
            &&  (result[x][y] > result[p.x][p.y]+1))
            {
               result[x][y] = result[p.x][p.y] + 1;
               q.add(new Pair(x,y));
            }
         }
      }
   
      return result;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   	// In a rectangular maze.
   	// Would like to get out of the maze as quickly as possible.
   	// The maze is a rectangular grid of square locations.
   	// Some locations are blocked.
   	// Some other locations are exits.
   	// If you arrive at an exit location, you can immeadiately leave the maze.
   
   	// You may walk one step at a time, onto one of the locations adjacent 
   	// to your current location.
   
   	// Two locations are adjacent if they share side.
   
      for (;;)
      {
      	// Each test case begins with two positive integers R <= 200, C <= 200
         int r = sc.nextInt();
         int c = sc.nextInt();
         if (r==0) 
            break;
         sc.nextLine();
         char maze[][] = new char[r][c];
      
         for (int i = 0; i < r; i++) maze[i] = sc.nextLine().toCharArray();
      
         int distances[][] = computeAllDistances(maze, r, c);
      
      	// Find the worse spot in the maze; the maximum distance
         int maxD = 0;
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               if (Integer.MIN_VALUE < distances[i][j] && distances[i][j] < Integer.MAX_VALUE) maxD = Math.max(maxD, distances[i][j]);
            }
         }
      
      
         int count[] = new int[maxD + 1];
         int total = 0;
      
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               if (Integer.MIN_VALUE < distances[i][j] && distances[i][j] < Integer.MAX_VALUE) ++count[ distances[i][j] ];
            
               if (Integer.MIN_VALUE < distances[i][j]) ++total;
            }
         }
      
         int sum[] = new int[maxD + 1];
         sum[0] = count[0];
         for (int i = 1; i <= maxD; i++) sum[i] = sum[i-1]+count[i];
      
         double res = -1.0;
      
         for (int i = 0; i < r; i++)
         {
            for (int j = 0; j < c; j++)
            {
               if (maze[i][j] == 'Y') res=distances[i][j];
            }
         }
      
         double area = 0.0;
         for (int k = 0; k < maxD; k++)
         {
            double p = (double) sum[k] / total;
         
            area += k*count[k];
            res = Math.min(res, (1/p)+(area/sum[k]));
         }
      
         System.out.printf("%.3f%n", res);
      }
   }

   public static void main(String args[])
   {
      new Teleport().doit();
   }
}