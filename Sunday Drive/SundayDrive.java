// 1.) Given description of several sections of the highway.
// 2.) All sections will have the same number of lanes.
// 3.) Each lane is 10 feet wide.
// 4.) Two kinds of highway section:
//		-Curved
//		-Straight
// 5.) You cannot change lanes on curved sections.
// 6.) Distance needed to change a lane 'D'
// 		- 100 ft <= D <= Infinity
// 7.) You must be in the exact center of a lane to take a turn.

import java.io.*;
import java.util.*;

public class SundayDrive
{
	public class Pair
	{
		int x, y;
		Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public double calculateArc(int r)
	{
		return ((double)(r*(Math.PI/2.0)));
	}

	public double distance(Pair p, Pair q)
	{
		return Math.sqrt(Math.pow((p.x-q.x),2)+Math.pow((p.y-q.y),2);
	}

	public boolean turnAhead(char sections[], int startIndex)
	{
		for (int i = startIndex; i<sections.length; i++)
		{
			if (sections[i] == 'R' || sections[i] == 'L') return true;
		}
		return false;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;
			char sections[] = new char[n];
			int distances[] = new int[n];
			for (int i = 0; i < n; i++)
			{
				sections[i] = sc.next().charAt(0);
				distances[i] = sc.nextInt();
				sc.nextLine();
			}

			double distanceTravelled = 0.0;
			char currentSection = section[0];
			
			for (int i = 1; i < n; i++)
			{
				char currentSection = sections[i];
			}

			// Case 1: We just completed a turn, and there is not a turn ahead

			// Case 2: We just completed a turn, and there is a turn ahead
			// 		Case 2.1: We just completed a left turn, and there is a left turn ahead
			//				- Take the inner most lane, remain in the same lane, take the innermost lane
			//		Case 2.2: We just completed a left turn, and there is a right turn ahead
			//			Case 2.2.1: The straight away distance between turns divided by 100 is less than the number of lanes
			//					- Move Math.floor(S/100) feet up and S distance to the left.
			//			Case 2.2.2: The straight away distance between turns divided by 100 is greater than or equal to the number of lanes
			//					-The end point is M*10 feet up and S distance to the left.
			//		Case 2.3: We just completed a right turn, and there is a left turn ahead
			//			Case 2.3.1: The straight away distance between turns divided by 100 is less than the number of lanes
			//					- Move Math.floor(S/100) feet up and S distance to the right.
			//			Case 2.3.2: The straight away distance between turns divided by 100 is greater than or equal to the number of lanes
			//					- Move M*10 feet up and S distance to the right.
			//		Case 2.4: We just completed a right turn, and there is a right turn ahead.
			//				- Take the inner most lane, remain in the same lane, take the innnermost lane
		}
	}

	public static void main(String args[])
	{
		new SundayDrive().doit();
	}
}