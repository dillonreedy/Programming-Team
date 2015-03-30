import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Euclid
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			Point2D A = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			Point2D B = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			Point2D C = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			Point2D D = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			Point2D E = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
			Point2D F = new Point2D.Double(sc.nextDouble(), sc.nextDouble());

			if (A.getX() == 0.0 && A.getY() == 0.0 && B.getX() == 0.0 && B.getY() == 0.0) break;

			Line2D base = new Line2D.Double(D,E);
			double areaDEF = 0.5 * base.ptLineDist(F) * D.distance(E);
			double AB = A.distance(B);
			double AC = A.distance(C);
			double BC = B.distance(C);
			double l = areaDEF / AB;
			double cosine = (AB*AB+AC*AC-BC*BC) / (2.0 * AB * AC);
			double dist = l / Math.sqrt(1.0 - cosine*cosine);
			double ratio = dist / AC;
			double diffX = ratio * (C.getX() - A.getX());
			double diffY = ratio * (C.getY() - A.getY());

			Point2D H = new Point2D.Double(A.getX()+diffX, A.getY()+diffY);
			Point2D G = new Point2D.Double(B.getX()+diffX, B.getY()+diffY);

			System.out.printf("%.3f %.3f %.3f %.3f", G.getX(), G.getY(), H.getX(), H.getY());
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new Euclid().doit();
	}
}