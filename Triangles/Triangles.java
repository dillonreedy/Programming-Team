import java.io.*;
import java.util.*;


public class Triangles
{
   public class Point
   {
      double x, y;
      
      Point(double x, double y)
      {
         this.x = x;
         this.y = y;
      }
   }

   public double dist(Point P, Point Q)
   {
      return Math.sqrt(Math.pow((P.x-Q.x),2)+Math.pow((P.y-Q.y),2));
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         Point points[] = new Point[n];
         for (int i = 0; i < n; i++) points[i] = new Point(sc.nextDouble(), sc.nextDouble());
         
         double distances[][] = new double[n][n];
         
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
               distances[i][j] = dist(points[i], points[j]);
        
         double maxDist = 0.0;
         double areas[] = new double[n];
         int max_index_i = 0;
         int max_index_j = 0;
        
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
               if (distances[i][j] > maxDist)
               {
                  maxDist = distances[i][j];
                  max_index_i = i;
                  max_index_j = j; 
               }
        
        System.out.println();      
      }
   }

   public static void main(String args[])
   {
      new Triangles().doit();
   }
}