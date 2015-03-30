import java.io.*;
import java.util.*;

public class CrashJudge
{
	public static void main(String args[])
	{
		new CrashJudge().doit();
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			int n = sc.nextInt();
			if (n==0) break;

			LinkedList<Group> groups = new LinkedList<Group>();
			// We keep an overall list of the groups.
			for (int arrival = 0; arrival < n; arrival++)
			{
				// We start a new group g.
				Group g = new Group();
				g.x = sc.nextInt();
				g.y = sc.nextInt();
				g.r = sc.nextInt();

				for (;;)
				{
					// For all the previous groups.
					int numGroups = groups.size();
					// We create a list a groups called neighbors.
					LinkedList<Group> neighbors = new LinkedList<Group>();
					for (int i = 0; i < numGroups; i++)
					{
						Group old = groups.removeFirst();
						double distSq = (g.x-old.x)*(g.x-old.x) + (g.y-old.y)*(g.y-old.y);
						double maxR = Math.max(g.r, old.r);

						if (distSq <= maxR*maxR)
						{
							System.out.println("Merging: " + (arrival+1) + " and " + (i+1));
							neighbors.addLast(old); // If they touch add this group to the neighbors group.
						}
						else groups.addLast(old); // If they don't just re-add them back into the overall groups list.
					}
					System.out.println();
				
					if (neighbors.isEmpty()) break; // If we have no neighbors then break out of this infinity loop.

					neighbors.add(g); // Add the newest group into the neighbors list.
					g = new Group(); //
					for (Group temp : neighbors)
					{
						g.x += temp.x;
						g.y += temp.y;
						g.r += (temp.r*temp.r);
					}
					g.x /= neighbors.size();
					g.y /= neighbors.size();
					g.r = Math.sqrt(g.r);
				}
			
			groups.addLast(g);
			}
		
		System.out.println(groups.size());
		}		
	}

	class Group
	{
		public double x;
		public double y;
		public double r;
	}
}