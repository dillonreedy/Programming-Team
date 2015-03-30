import java.io.*;
import java.util.*;

// There are N teams attending the contest at that site.
// Each sitting at a different location
// 3 4 6
// 1 2 3
// 2 2 2
// 3 3 2

// best[] = [0, 0, 0, 0, 0, 0]

// a = 4, b = 5
// best[] = [0, 1, 0, 0, 0, 0]
// 1 2 3
// 2 2 2
// 2 3 1

// a = 4, b = 4
// best[] = [0, 1, 2, 0, 0, 0]
// 1 2 3
// 2 2 2
// 1 3 1

// 

public class Balloons
{
	public class Team
	{
		int k, da, db;
		Team(int k, int da, int db)
		{
			this.k = k;
			this.da = da;
			this.db = db;
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (n==0) break;

			Team teams[] = new Team[n];
			int totalNeeded = 0;
			for (int i = 0; i < n; i++)
			{
				int k = sc.nextInt();
				totalNeeded+=k;
				teams[i] = new Team(k, sc.nextInt(), sc.nextInt());
			}

			int sum = 0;
			for (int i = 1; i < totalNeeded+1; i++)
			{
				int least = Integer.MAX_VALUE;
				int t = 0;
				boolean tableA = true;
				
				if (a > 0 && b > 0) // Then test both columns
				{
					for (int j = 0; j < n; j++)
					{
						if (teams[j].k != 0)
						{
							if (teams[j].da < teams[j].db)
							{
								if (teams[j].da < least)
								{
									least = teams[j].da;
									t = j;
									tableA = true;
								}
							}
							else
							{
								if (teams[j].db < least)
								{
									least = teams[j].db;
									t = j;
									tableA = false;
								}
							}
						}
					}

				}
				else if (a==0) // Then only test the db column
				{
					tableA = false;
					for (int j = 0; j < n; j++)
					{
						if ((teams[j].db < least) && (teams[j].k != 0))
						{
							least = teams[j].db;
							t = j;
						}
					}
				}
				else if (b==0)
				{
					for (int j = 0; j < n; j++)
					{
						if ((teams[j].da < least) && (teams[j].k != 0))
						{
							least = teams[j].da;
							t = j;
						}
					}
				}

				if (tableA) a--;
				else b--;
				
				teams[t].k = teams[t].k-1;
				sum+=least;
			}

			System.out.println(sum);
		}
	}

	public static void main(String args[])
	{
		new Balloons().doit();
	}
}