import java.io.*;
import java.util.*;

public class newKnightMoves
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

	public Pair getLocation(char ch, char board[][], int r, int c)
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (board[i][j] == ch) return new Pair(i, j);
			}
		}

		System.err.println("The character is not on the board!!!");
		return null;
	}

	public int getScore(char board[][], int r, int c)
	{	
		Pair startPt = getLocation('X', board, r, c);
		ArrayList<Pair> q = new ArrayList<Pair>();
		boolean beenHere[][] = new boolean[r][c];
		int score[][] = new int[r][c];
		for (int i = 0; i < r; i++) Arrays.fill(score[i], Integer.MAX_VALUE);
		q.add(startPt);
		beenHere[startPt.x][startPt.y] = true; 

		int dx[] = {1, -1, 2, 2,-2,-2, 1, -1};
		int dy[] = {2,  2, 1,-1, 1,-1,-2,  2};

		while (!q.isEmpty())
		{
			Pair currentLoc = q.remove(0);
			for (int k = 0; k < 8; k++)
			{
				int x = currentLoc.x + dx[k];
				int y = currentLoc.y + dy[k];

				if ((0<=x && x<r)
				&&  (0<=y && y<c))
				{
					if (board[x][y] == 'K') return score[x][y];
					if ((board[x][y] != '#') && (!beenHere[x][y]))
					{
						score[x][y] = score[currentLoc.x][currentLoc.y]+1;
						beenHere[x][y] = true;
						q.add(new Pair(x, y));
					}
				}
			}

		}
		return -1;

	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();

		char board[][] = new char[r][c];
		sc.nextLine();
		for (int i = 0; i < r; i++) board[i] = sc.nextLine().toCharArray();

		printoutBoard(board, r, c);

		System.out.println(getScore(board, r, c));
	}

	public void printoutBoard(char board[][], int r, int c)
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				System.out.print(board[i][j] + " ");
			}
		}
	}

	public static void main(String args[])
	{
		new newKnightMoves().doit();
	}
}