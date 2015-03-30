import java.util.*;
import java.io.*;

public class Robot
{
	public boolean containsChar(char board[][], int r, int c, char ch)
	{
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (board[i][j] == ch) return true;

		return false;
	}

	public class Pair
	{
		int i, j;
		Pair(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r==0 && c==0) break;

			char board[][] = new char[r][c];
			sc.nextLine();
			for (int i = 0; i < r; i++) board[i] = sc.nextLine().toCharArray();
			

			
			ArrayList<Pair> q = new ArrayList<Pair>();


		}
	}

	public static void main(String args[])
	{
		new Robot().doit();
	}
}