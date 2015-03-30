import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Slice
{

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) break;

         double angles[] = new double[n];
         double mags[]   = new double[n];
         for (int i = 0; i < n; i++)
         {
            angles[i] = sc.nextDouble();
            mags[i] = sc.nextDouble();
         }
      
         Point2D pts[] = new Point2D[n+1];
         Arrays.fill(pts, null);
         pts[0] = new Point2D.Double(0.0, 0.0);
         ArrayList<Line2D> lines = new ArrayList<Line2D>();
         
         boolean isHole = false;
         int result = 0;
         double angle = 90.0;
         
         for (int i = 1; i < n+1; i++)
         {
            Point2D startPt1 = pts[i-1];
            angle += angles[i-1];
            double mag = mags[i-1];
            
            double resultX = startPt1.getX() + (mag * (Math.cos( Math.toRadians(angle))));
            double resultY = startPt1.getY() + (mag * (Math.sin( Math.toRadians(angle))));
            
            Point2D endPt1 = new Point2D.Double(resultX, resultY);
            
            Line2D cut = new Line2D.Double(startPt1, endPt1);
            
            for (int j = 0; j < lines.size()-1; j++)
            {
               if (cut.intersectsLine(lines.get(j)))
               {
                  isHole = true;
                  result = i;
                  break;
               }
            }
         
            if (!isHole)
            {
               pts[i] = endPt1;
               lines.add(cut);
            }
            else break;
         }
      
         if (isHole) System.out.println(result);
         else System.out.println("SAFE");
      }
   }

   public static void main(String args[])
   {
      new Slice().doit();
   }

}