import java.io.*;
import java.util.*;

public class DataRecovery
{
	// -1 -1  6 -1  8
	// -1 -1  0  4  2
	//  3 -1 -1  5 -1
	//  4  0  2 -1 -1
	//  2  1  5 -1 -1

	// -1 -1  6 -1  8 = 21
	// -1 -1  3  4  2 = 18

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r==0) break;

			int board[][] = new int[r][c];
			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					board[i][j] = sc.nextInt();

			int sumRows[] = new int[r];
			for (int i = 0; i < r; i++) sumRows[i] = sc.nextInt();

			int sumCols[] = new int[c];
			for (int i = 0; i < c; i++) sumCols[i] = sc.nextInt();

			int S[][] = new int[r][c];

			for (int i = 0; i < r; i++)
			{
				for (int j = 0; j < c; j++)
				{
					if (board[i][j] == -1)
					{

					}
					else
					{
						S[i][j] = board[i][j];
					}
				}
			}

		}
	}

	public static void main(String args[])
	{
		new DataRecovery().doit();
	}
}