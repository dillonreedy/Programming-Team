import java.io.*;
import java.util.*;

public class SundayDrive2
{
   public static final int MAX_SEGMENTS = 100000;
   public static final int MAX_LANES = 10;

   // n = 3, m = 3
   // types[] =  ['', R, S, L, ''..'']
   // lengths[] = [0, 100, 1000, 100, 0..0]
   // best[][] = [[0.0, 0.0, 0.0..0.0], [Double.MAX_VALUE, Double.MAX_VALUE..]..]
   
   // i = 1
   // types[i] == 'R' => True
   
   // j = 0
   // r = best[i-1][j] + 5.0 + 10.0 * (m-1-j) => best[1-1][0] + 5.0 + 10.0 * (3-1-0) => best[0][0] + 5.0 + 20.0 => 0.0 + 25.0 => 25.0
   // r = 25.0   
   // best[i][j] => best[1][0]
   // best[1][0] = best[i-1][j] + 0.5 * Math.PI * r; => best[1-1][0] + 0.5 * Math.PI * 25.0 => 12.5 * Math.PI
   // best[][] = [[0.0, 0.0, 0.0..0.0], [(12.5 * Math.PI), Double.MAX_VALUE..Double.MAX_VALUE]..]

   // j = 1
   // r = best[i-1][j] + 5.0 + 10.0 * (m-1-j) => best[1-1][1] + 5.0 + 10.0 * (3-1-1) => best[0][1] + 5.0 + 10.0 * 1 => 0.0 + 5.0 + 10.0 => 15.0
   // r = 15.0
   // best[i][j] => best[1][1]
   // best[1][1] = best[i-1][j] + 0.5 * Math.PI * r => best[1-1][1] + 0.5 * Math.PI * 15.0 => 0.0 + 7.5 * Math.PI => 7.5 * Math.PI
   // best[][] = [[0.0, 0.0, 0.0..0.0], [(12.5 * Math.PI), (7.5 * Math.PI), Double.MAX_VALUE..]..]

   // j = 2
   // ..
   // best[][] = [[0.0, 0.0, 0.0..0.0], [(12.5 * Math.PI), (7.5 * Math.PI), (2.5 * Math.PI), Double.MAX_VALUE..]..]

   // i = 2
   // types[i] == 'S' => True

   // crossable = lengths[i]/100 => lengths[2]/100 => 1000/100 => 10
   
   // j = 0
   // least = Double.MAX_VALUE

   // k = 0
   // lanesToCross = Math.abs(k-j) => Math.abs(0-0) => 0
   // (lanesToCross <= crossable) => (0 <= 10) => True
   // distance = best[i-1][k] + Math.hypot(lengths[i], 10.0*lanesToCross) => best[2-1][0] + Math.hypot(lengths[2], 10.0*0)
   // => best[1][0] + Math.hypot(1000, 0.0) => (12.5 * Math.PI) + Math.hypot(1000, 0.0)
   // (distance < least) => (12.5 * Math.PI) + Math.hypot(1000, 0.0) < Double.MAX_VALUE => True
   // least = (12.5 * Math.PI) + Math.hypot(1000, 0.0)

   // k = 1
   // lanesToCross = Math.abs(1-0) => 1
   // (lanesToCross <= crossable) => True
   // distance = (7.5 * Math.PI) + Math.hypot(1000, 10)   
   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         int m = sc.nextInt();
      	
         int lengths[] = new int[MAX_SEGMENTS+1];
         char types[] = new char[MAX_SEGMENTS+1];
      	// best[i][j] will be the least distance it takes to
      	// drive from the beginning of the highway to the end
      	// of segment i, ending in lane j.
         double best[][] = new double[MAX_SEGMENTS+1][MAX_LANES];
      
      	// Initialize the the beginning to all zero, because
      	// it takes 0.0 distance to get to the beginning.
         Arrays.fill(best[0], 0.0);
      
         for (int i = 0; i < n; i++)
         {
            types[i+1] = sc.next().charAt(0);
            lengths[i+1] = sc.nextInt();
            Arrays.fill(best[i+1], Double.MAX_VALUE);
         }  
            
      
      	// Here we go through the n segments starting from the
      	// beginning
      
         for (int i = 1; i <= n; i++)
         {
            if (types[i] == 'S')
            {
            	// It takes 100 feet to change lanes, therfore
            	// this is the number of lanes we can cross 
            	// given a straight segment.
               int crossable = lengths[i]/100;
            
            	// Now for each lane:
               for (int j = 0; j < m; j++)
               {
                  double least = Double.MAX_VALUE;
               
               	// Figure out how to get to the jth lane
               	// starting from the kth lane on this 
               	// segment.
                  for (int k = 0; k < m; k++)
                  {
                  	// The number of lanes crossed.
                     int lanesToCross = Math.abs(k-j);
                  
                  	// Do we have enough straight lane
                  	// distance to cross that many lanes?
                     if (lanesToCross <= crossable)
                     {
                     	// The least distance to cross these lanes is to take 
                     	// the whole segment to do it. Therefore, we'll use
                     	// Pythagoream theory to calculate the distance. Where
                     	// one leg of the triangle is the length of the segment
                     	// and the other leg of the triangle is the number of lanes
                     	// changed.
                        double distance = best[i-1][k] + Math.hypot(lengths[i], 10.0*lanesToCross);
                        if (distance < least) least = distance;
                     }
                  }
                  best[i][j] = least;
               }
            }
            else if (types[i] == 'L')
            {
            	// Have to stay in your lane turning left or right.
               for (int j = 0; j < m; j++)
               {
                  double r = lengths[i] + 5.0 + (10.0*j);
                  best[i][j] = best[i-1][j] + 0.5 * Math.PI * r;
               }
            }
            else if (types[i] == 'R')
            {
               for (int j = 0; j < m; j++)
               {
                  double r = lengths[i] + 5.0 + (10.0 * (m-1-j));
                  best[i][j] = best[i-1][j] + 0.5 * Math.PI * r;
               }
            }
            else
            {
               System.err.println("PANIC!!!");
            }
         }
      
      	// Go through all the lanes at the end of the highway.
      	// See which values have the least distance.
         double least = Double.MAX_VALUE;
         for (int j = 0; j < m; j++) 
            if (best[n][j] < least) least = best[n][j];
      
         System.out.printf("%.2f", least);
         System.out.println();
      }
   }

   public static void main(String args[])
   {
      new SundayDrive2().doit();
   }
}