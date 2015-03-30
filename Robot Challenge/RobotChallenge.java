import java.io.*;
import java.util.*;
import java.awt.geom.*;
// 100 meter by 100 meter space
// Certain spaces are identified as targets
// Always starts at (0,0)
// Must stop for 1 second at each target
// Must finally stop at (100,100)
// Time penalties for skipping any targets except (0,0) and (100,100)



public class RobotChallenge
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			// We're going to add 2 points to the input
			// The start (0,0) and the end (100,100)
			n+=2;
			Point2D pts[] = new Point2D[n];
			int penalties[] = new int[n];
			pts[0] = new Point2D.Double(0.0, 0.0);
			penalties[0] = Integer.MAX_VALUE;
			pts[n-1] = new Point2D.Double(100.0, 100.0);
			penalties[n-1] = Integer.MAX_VALUE;

			for (int i = 1; i<n-1; i++)
			{
				pts[i] = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
				penalties[i] = sc.nextInt();
			}
			
			double best[] = new double[n];
			best[n-1] = 1.0;

			for (int i = n-2; i>=0; i--) // Starting from the end and working to the beginning.
			{
				int penalty = 0;
				best[i] = Double.MAX_VALUE;

				for (int j = i+1; j<n; j++)
				{
					double dist = pts[i].distance(pts[j]);
					double cost = 1.0 + dist + penalty + best[j]; // 1 second is incurred on every target.

					best[i] = Math.min(best[i], cost);
					penalty+=penalties[j];

					if (penalty+3.0 >= best[i]) break;
				}
			}

			System.out.printf("%.3f", best[0]-1.0);
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new RobotChallenge().doit();
	}
} 