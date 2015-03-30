import java.io.*;
import java.util.*;

public class Alchemy
{
	public class Circle
	{
		int x, y, r;
		int a, b;

		Circle(int x, int y, int r, int a, int b)
		{
			this.x = x;
			this.y = y;
			this.r = r;
			this.a = a;
			this.b = b;
		}

		public double dist(Circle c)
		{
			return (Math.sqrt(Math.pow((this.x-c.x),2)+Math.pow((this.y-c.y),2)));
		}
	}

	public boolean isInside(Circle c1, Circle c2)
	{
		double distance = c1.dist(c2);
		if (distance <= Math.abs(c1.r - c2.r))
		{
			// Circle 2 is inside circle 1
			return true;
		}
		else if (distance > (c1.r + c2.r))
		{
			// Circle 2 does not overlap circle 1
			return false;
		}
		else
		{
			// Circle 1 overlaps the other circle.
			System.err.prinln("The circles intersect panic!!!");
			return false;
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;
			Circle circles[] = new Circle[n];
			for (int i = 0; i < n; i++) circles[i] = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

			


		}
	}

	public static void main(String args[])
	{
		new Alchemy().doit();
	}
}