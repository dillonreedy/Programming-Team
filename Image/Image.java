import java.io.*;
import java.util.*;


	// 0 	C/2		C
	//
	// R/2
	//
	// R

public class Image
{
	public double getScore(char searchChar, char board[][], int r, int c)
	{
		double count = 0.0;
		double total = ((double)(r*c));
		
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (board[i][j] == searchChar) count+=1.0;

		return (count/total);
	}


	public char[][] getLossyBoard(char orig[][], int r, int c, double T)
	{
		char result[][] = new char[r][c];
		if (getScore('0', orig, r, c) >= T) // Then return a board of size n by n filled with zeros
		{
			for (int i = 0; i < r; i++) Arrays.fill(result[i], '0');
		}
		else if (getScore('1', orig, r, c) >= T) // Then return a board of size n
		{
			for (int i = 0; i < r; i++) Arrays.fill(result[i], '1');
		}
		else
		{

		int half = r/2;
		char Q1[][] = new char[half][half];
		char Q2[][] = new char[half][half];
		char Q3[][] = new char[half][half];
		char Q4[][] = new char[half][half];
		int x1 = 0, x2 = 0, x3 = 0, x4 = 0;

		// In the following lines, we are reading
		for (int i = 0; i < r; i++)
		{
			int y1 = 0, y2 = 0;
			for (int j = 0; j < c; j++)
			{
				if (0 <= i && i < half)
				{
					if (0 <= j && j < half)
					{
						Q2[x2][y2] = orig[i][j];
						y2++;
					}
					else
					{
						Q1[x1][y1] = orig[i][j];
						y1++;
					}
				}
				else
				{
					if (0 <= j && j < half)
					{
						Q3[x3][y2] = orig[i][j];
						y2++;
					}
					else
					{
						Q4[x4][y1] = orig[i][j];
						y1++;
					}
				}
			}

			if (0 <= i && i < half)
			{
				x1++;
				x2++;
			}
			else
			{
				x3++;
				x4++;
			}
		}

		Q1 = getLossyBoard(Q1, half, half, T);
		Q2 = getLossyBoard(Q2, half, half, T);
		Q3 = getLossyBoard(Q3, half, half, T);
		Q4 = getLossyBoard(Q4, half, half, T);

		x1 = 0; x2 = 0; x3 = 0; x4 = 0;
		for (int i = 0; i < r; i++)
		{
			int y1 = 0, y2 = 0;
			for (int j = 0; j < c; j++)
			{
				if (0 <= i && i < half)
				{
					if (0 <= j && j < half)
					{
						result[i][j] = Q2[x1][y1];
						y1++;
					}
					else
					{
						result[i][j] = Q1[x2][y2];
						y2++;
					}
				}
				else
				{
					if (0 <= j && j < half)
					{
						result[i][j] = Q3[x3][y1];
						y1++;
					}
					else
					{
						result[i][j] = Q4[x4][y2];
						y2++;
					}
				}
			}

			if (0<=i && i<half)
			{
				x1++;
				x2++;
			}
			else
			{
				x3++;
				x4++;
			}
		}
		}
		
		return result;
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

		int count = 1;
		for (;;)
		{
			int W = sc.nextInt();
			if (W==0) break;
			double T = (sc.nextDouble()/100.0);

			char board[][] = new char[W][W];
			sc.nextLine();
			for (int i = 0; i < W; i++) board[i] = sc.nextLine().toCharArray();


			System.out.println("Image " + count + ":");
			count++;
			printoutBoard(getLossyBoard(board, W, W, T), W, W);
		}
	}

	public static void main(String args[])
	{
		new Image().doit();
	}
}