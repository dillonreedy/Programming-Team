import java.io.*;
import java.util.*;

// 3 3 3
// {100, 50, -20}
// {0, 0, 0, 0}
// {0, 100, 0, 0}
// {0, 100, 150, 0}
// {0, 100, 150, 150}

// {100, 50, -20, 60}
// {0, 0, 0, 0, 0}
// {0, 100, 0, 0, 0} = 1 turn
// 		  {50, -20, 60, 30}
//		  {0, 50, 50, 110, 140}
// {0, 100, 150, 0, 0} = 2 turns
// {0, 100, 150, 150, 0} = 3 turns
// {0, 100, 150, 150, 210} = 4 turns



public class RIPOFF
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // The total number of squares on the board, 1<N && N<201
		int S = sc.nextInt(); // The maximum number of spaces you may advance in each turn, 1<S && S<11
		int T = sc.nextInt(); // The maximum number of turns allowed, where N/S<T && T<N+2

		int board[] = new int[N];
		for (int i = 0; i < N; i++) board[i] = sc.nextInt();
		
		int currentSum = 0;
		int currentLoc = 0;
		for (int t = T; t > 0; t--)
		{
			int most = Integer.MIN_VALUE;
			int mostSpaces = 0;
			for (int s = 0; s < S; s++)
			{
				if (s+currentLoc<board.length)
				{
					if (most<board[s+currentLoc])
					{
						most = board[s+currentLoc];
						mostSpaces = s;
					}
				}
			}

			currentLoc+=mostSpaces+1;
			currentSum+=most;
			System.out.println("The currentLocation: " + currentLoc);
			System.out.println("The current running total: " + currentSum);
		}
	}

	public static void main(String args[])
	{
		new RIPOFF().doit();
	}
}