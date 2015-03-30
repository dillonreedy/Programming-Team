import java.io.*;
import java.util.*;

// Steps:
// 1.) Get graph
// 2.) Find minimum distances by memoizing
// 3.) Remove all edges not minimal (then no need for lengths anymore)
// 4.) Any node with edge from it removed would need a marker if the node is used.
// 5.) Recursively mark vertices still in possible use via memoization
// 6.) Mark others as having large distance
// 7.) Sort by distance to get reverse topological order.
// 8.) Generate all subsets of marks with few enough marks, and test each to see if sufficient via reverse topological check
// 9.) If sufficient, reduce minMarks

/*
Since there is a minimal length path with at most 7 tunnels, there
exists a solution with 7 or less markers. That bounds the number of
possible marker subsets to consider to C(17,7) + C(17,6)+..+C(17,0) = 41226
*/

// The vertical direction is oriented upward on the page.
// The lair begins at label A.
// The surface is at label F.
// The other labels mark intersections.

// A group of wizards finds the need to rush through such tunnels
// to the surface following an upward path that takes the minimum
// amount of time.

// Many upward tunnels can leave an intersection, and there is
// no obvious way to choose the best tunnel in general.

// Mark as few intersections of tunnels as possible.
	class Node implements Comparable<Node>
	{
		List<Node> next = new ArrayList<Node>(); // All possible next nodes
		int weight[];
		char name;
		boolean needsMark, canUse, doMark;
		int dist = -1;

		public void init(Scanner sc, Node nodes[])
		{
			String seq="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij";
			name = sc.next().charAt(0);
			int n = sc.nextInt();
			weight = new int[n];

			for (int i = 0; i < n; i++)
			{
				next.add( nodes[ seq.indexOf( sc.next() ) ] );
				weight[i] = sc.nextInt();
			}
		}

		public int compareTo(Node nd) // Allows sort by distance
		{
			return dist - nd.dist;
		}

		public int getDist() // Basic memoized minimum path length algorithm
		{
			if (dist == -1)
			{
				dist = 100000;
				for (int i = 0; i < next.size(); i++)
				{
					int distToIthNearbyNode = next.get(i).getDist();
					dist = Math.min(dist, weight[i]+distToIthNearbyNode);
				}
			}
			return dist;
		}

		public void killLong() // Remove edges that are too long.
		{
			int k = next.size();
			for (int i = k-1; i>=0; i--) // Going backwards allows the use of the original weights
			{
				int ithNodeDist = next.get(i).dist;

				if (dist != weight[i] + ithNodeDist) next.remove(i);
			}
			needsMark = next.size() < k;
		}

		public void setReachable() // Search forward for nodes reachable after edge removal
		{
			if (canUse) return;
			
			canUse = true;
			for (Node nd : next) nd.setReachable();
		}

		public void setCanUse() // Reverse topological check if node is useable with current marker choices
		{
			if (!doMark && needsMark) canUse = false;
			else
			{
				int okTunnels = 0;
				for (Node nd : next) if (nd.canUse) okTunnels++;

				canUse = ((okTunnels == next.size()) || (okTunnels > 0 && doMark));
			}
		}

		public String toString()
		{
			String after = "";
			for (Node nd : next) after += nd.name;

			return String.format("%s: %s, d: %s; nM:%s;  cU: %s", name, after, dist, needsMark, canUse);
		}
	}


public class Markers
{

	static int MAX_STEPS = 7;
	static int MAX_EDGES = 35;
	static Node[] nodes;
	static int tot; // intial count of nodes; later drop unreachable
	static int minMarks;

	public static void doit()
	{
		Scanner sc = new Scanner(System.in);
	
		for (;;)
		{
			tot = sc.nextInt();
			if (tot==0) break;

			nodes = new Node[tot];
			for (int i = 0; i < tot; i++) nodes[i] = new Node(); // Unitialized, but can reference
			
			int totEdges = 0;
			for (Node nd : nodes)
			{
				nd.init(sc, nodes); // Input data initializes node
				totEdges += nd.next.size();
			}

			nodes[tot-1].dist = 0; // At destination
			int totDist = nodes[0].getDist(); // recursive memoize, find dist to end

			for (Node nd : nodes) nd.killLong(); // dump nonoptimal edges

			nodes[tot-1].canUse = true;
			nodes[0].setReachable(); // Label all now reachable (canUse) from start

			for (Node nd : nodes)
			{
				if (!nd.canUse)
				{
					nd.dist = 100000; // Will be sorted out of the way.
					tot--; // one less active node
				}
			} 

			Arrays.sort(nodes); // Now reverse topological order of tot nodes.
			minMarks = Math.min(MAX_STEPS, tot-1); // Could mark a single whole path.

			doSubsets(1, 0);

			for (Node nd : nodes)
			{
				System.out.println(nd.toString());
			}

			System.out.println(totDist + " " + minMarks);
		}
	}

	public static void doSubsets(int nextMark, int marks)
	{
		if (marks >= minMarks) return;

		for (int i = 1; i < tot; i++) nodes[i].setCanUse(); // See if marks sufficient, and set in reverse topological order

		if (nodes[tot-1].canUse) // Did you reach the starting node?
		{
			minMarks = marks;
			return;
		}

		for (int i = nextMark; i < tot; i++) // Add one more mark
		{
			nodes[i].doMark = true;
			doSubsets(i+1, marks+1);
			nodes[i].doMark = false;
		}
	}

	public static void main(String args[])
	{
		new Markers().doit();
	}
}