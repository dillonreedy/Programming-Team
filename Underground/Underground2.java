import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.geom.*;

public class Underground2
{
   public class Edge implements Comparable<Edge>
   {
      int v, w;
      double weight;
      Edge(int v, int w, double weight)
      {
         this.x = x;
         this.y = y;
         this.weight = weight;
      }
   
      public int getEither()
      {
         return this.v;
      }

      public int getOther(int vertex)
      {
         if (this.v == vertex) return this.w;
         else return this.v;
      }

      public int compareTo(Edge f)
      {
         if (this.weight < f.weight) return -1;
         if (this.weight > f.weight) return 1;
         if (this.v < f.v) return -1;
         if (this.v > f.v) return 1;
         if (this.w < f.w) return -1;
         if (this.w > f.w) return 1;
         return 0;
      }
   }


   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
      
         Point2D ptsPoint[] = new Point2D[n];
         for (int i = 0; i < n; i++) ptsPoint[i] = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
      	
         Arrays.sort(ptsPoint);
         Point2D ptsPoint2D[] = new Point2D[n];
         for (int i = 0; i < n; i++) ptsPoint2D[i] = new Point2D.Double(ptsPoint[i].x, ptsPoint[i].y);
      
         double weights[][] = new double[n][n];
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
               weights[i][j] = ptsPoint2D[i].distance(ptsPoint2D[j]);
      
         double sum = 0.0;
         ArrayList<Line2D> lines = new ArrayList<Line2D>();
      
         for (int i = 0; i < n; i++)
         {
            double least = Double.MAX_VALUE;
            Line2D resultLine = null;
            for (int j = i+1; j < n; j++)
            {
               if (i!=j)
               {
                  Point2D P = ptsPoint2D[i];
                  Point2D Q = ptsPoint2D[j];
                  Line2D cut = new Line2D.Double(P,Q);
                  if (!intersectsPrevious(lines, cut))
                  {
                     if (weights[i][j] < least)
                     {
                        least = weights[i][j];
                        resultLine = cut;
                     }
                  }
               }
            }
            sum+=least;
            lines.add(resultLine);
         }
      
         System.out.println(sum);
      
      }
   }

   public static void main(String args[])
   {
      new Underground2().doit();
   }
}