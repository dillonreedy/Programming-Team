import java.io.*;
import java.util.*;

public class Star
{
	public class ThreePair
	{
		long x, y, z;
		ThreePair(long x, long y, long z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public double dist(ThreePair Q)
		{
			return Math.sqrt(Math.pow((this.x - Q.x),2) + Math.pow((this.y-Q.y),2) + Math.pow((this.z - Q.z),2));
		}

	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			//long lStartTime = new Date().getTime();
			int n = sc.nextInt();
			double k = sc.nextDouble();
			if (n==0) break;

			ThreePair pts[] = new ThreePair[n];
			for (int i = 0; i < n; i++) pts[i] = new ThreePair(sc.nextLong(), sc.nextLong(), sc.nextLong());

			int count = 0;
			for (int i = 0; i < n; i++)
			{
				ThreePair P = pts[i];
				for (int j = (i+1); j < n; j++)
				{
					ThreePair Q = pts[j];
					if (P.dist(Q) < k) count++;
				}
			}

			System.out.println(count);
			//long lEndTime = new Date().getTime();
			//long difference = lEndTime - lStartTime;
			//System.out.println("Elapsed seconds: " + (difference/1000L));
		}
	}

	public static void main(String args[])
	{
		new Star().doit();
	}
}