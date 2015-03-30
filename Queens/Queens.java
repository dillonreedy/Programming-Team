import java.io.*;
import java.util.*;
import java.awt.geom.*;

public class Queens
{
	public class Pair implements Comparable<Pair>
	{
		int x, y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair Q)
		{
			if (this.x > Q.x)
			{
				return 1;
			}
			else if (this.x < Q.x)
			{
				return -1;
			}
			else
			{
				if (this.y > Q.y)
				{
					return 1;
				}
				else if (this.y < Q.y)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		}

		public String toString()
		{
			return "("+this.x+","+this.y+")";
		}
	}

	// |x
	// |    x
	// | x
	// |     x
	// |  x
	// |      x
	// |   x
	// ________

	// 3 1
	// 3 1 1 1 1

	// (0,0), (1,1)
	// 

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			int g = sc.nextInt();
			ArrayList<Pair> pts = new ArrayList<Pair>();
			for (int j = 0; j < g; j++)
			{
				int k = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				int s = sc.nextInt();
				int t = sc.nextInt();
				for (int i = 0; i < k; i++) pts.add(new Pair(((x + i*s)-1), (n-((y + i*t)))));
			}

			Pair sortPts[] = new Pair[pts.size()];
			sortPts = pts.toArray(sortPts);
			Arrays.sort(sortPts);
			pts.clear();
			for (int i = 0; i < sortPts.length; i++) pts.add(sortPts[i]);

			int upDownCollisions = 0;
			for (int i = 0; i < pts.size(); i++)
			{
				Pair P = pts.get(i);
				for (int j = (i+1); j < pts.size(); j++)
				{
					Pair Q = pts.get(j);
					if (P.y == Q.y)
					{
						upDownCollisions++;
						//System.out.println("Point: " + P.toString() + " is colliding with: " + Q.toString() + " vertically!!!");
						break;
					}
				}
			}

			int leftRightCollisions = 0;
			for (int i = 0; i < pts.size(); i++)
			{
				Pair P = pts.get(i);
				for (int j = (i+1); j < pts.size(); j++)
				{
					Pair Q = pts.get(j);
					if (P.x == Q.x)
					{
						leftRightCollisions++;
						//System.out.println("Point: " + P.toString() + " is colliding with: " + Q.toString() + " horizontally!!!");
						break;
					}
				}
			}

			int diagonalDRCollision = 0;
			for (int i = 0; i < pts.size(); i++)
			{
				Pair P = pts.get(i);
				for (int j = (i+1); j < pts.size(); j++)
				{
					Pair Q = pts.get(j);
					if (P.x < Q.x && P.y > Q.y)
					{
						if (Math.abs(P.x-Q.x) == Math.abs(P.y-Q.y))
						{
							//System.out.println("Point: " + P.toString() + " is colliding with: " + Q.toString() + " diagonally!!!");

							diagonalDRCollision++;
							break;
						}
					}
				}
			}


			int diagonalDLCollision = 0;
			for (int i = 0; i < pts.size(); i++)
			{
				Pair P = pts.get(i);
				for (int j = (i+1); j < pts.size(); j++)
				{
					Pair Q = pts.get(j);
					if (P.x < Q.x && P.y > Q.y)
					{
						if (Math.abs(P.x-Q.x) == Math.abs(P.y-Q.y))
						{
							//System.out.println("Point: " + P.toString() + " is colliding with: " + Q.toString() + " diagonally!!!");
							diagonalDLCollision++;
							break;
						}
					}
				}
			}

			System.out.println((upDownCollisions+leftRightCollisions+diagonalDRCollision+diagonalDLCollision));
		}
	}


	public static void main(String args[])
	{
		new Queens().doit();
	}
}