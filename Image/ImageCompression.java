import java.io.*;
import java.util.*;

public class ImageCompression
{
	public double getScore(char searchChar, char board[][], int r, int c)
	{
		double count = 0.0;
		double total = ((double) r*c);
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (board[i][j]==searchChar)count+=1.0;
			}
		}

		return (count/total);
	}

	public char[][] getLossyBoard(char board[][], int r, int c, double T)
	{
		if (getScore('0',board,r,c) >= T)
		{
			char result[][] = new char[r][c];
			for (int i = 0; i < r; i++) Arrays.fill(result[i],'0');
			return result;
		}

		if (getScore('1',board,r,c) >= T)
		{
			char result[][] = new char[r][c];
			for (int i = 0; i < r; i++) Arrays.fill(result[i], '1');
			return result;
		}

		int half = r/2;
		char Q1[][] = new char[half][half];
		char Q2[][] = new char[half][half];
		char Q3[][] = new char[half][half];
		char Q4[][] = new char[half][half];

		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				
			}
		}
	}

	public void printoutBoard(char board[][], int r, int c)
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;
			double T = (sc.nextDouble()/100.0);
			char board[][] = new char[n][n];
			for (int i = 0; i < n; i++) board[i] = sc.nextLine().toCharArray();

			printoutBoard(getLossyBoard(board, n, n), n, n);
		}
	}

	public static void main(String args[])
	{
		new ImageCompression().doit();
	}
}