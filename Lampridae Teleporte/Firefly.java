import java.io.*;
import java.util.*;

//1.) We will only be chasing one firefly at a time
//2.) Firefly chasing will take place in two dimensions where all units are considered to be yards.
//3.) The firefly is "caught" if the chaser can manage to come within one yard of the firefly.
//4.) The chaser's movement toward a firefly is always in a straight line from his or her current location directly toward the flash.

public class Firefly
{
	public class Teleporter
	{
		double maxRange, x, y;
		Teleporter(double maxRange, double x, double y)
		{
			this.maxRange = maxRange; // The maximum range will be a positive range from 1 to 1000
			this.x = x;
			this.y = y;
		}

		public double dist(Pair p)
		{
			return Math.sqrt(Math.pow(p.x-this.x,2) + Math.pow(p.y-this.y,2));
		}
	}

	public class Pair
	{
		double x, y;
		Pair(double x, double y)
		{
			this.x = x;
			this.y = y;
		}

		public String toString()
		{
			return "("+((int) this.x)+","+((int) this.y)+")";
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int probNum = 1;
		for (;;)
		{
			Teleporter t = new Teleporter(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
			if (t.maxRange==0.0) break;

			ArrayList<Pair> pts = new ArrayList<Pair>();
			for (;;)
			{
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				if (x!=-1.0 && y!=-1.0) break;
				pts.add(new Pair(x,y));
			}
			
			boolean caughtFly = false;
			for (Pair p : pts)
			{
				double d = t.dist(p);

				if (d-t.maxRange <= 1.0)
				{
					System.out.println("Firefly " + probNum + " caught at " + p.toString());
					caughtFly = true;
					break;
				}
			
				t.x += (t.maxRange/d) * (p.x-t.x);
				t.y += (t.maxRange/d) * (p.y-t.y);
			}

			if (!caughtFly) System.out.println("Firefly " + probNum + " not caught");
			probNum++;		
		}
	}

	public static void main(String args[])
	{
		new Firefly().doit();
	}
}