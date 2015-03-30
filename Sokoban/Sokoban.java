import java.io.*;
import java.util.*;

public class Sokoban
{
	public class Pair
	{
		int i, j;
		Pair() {}

		Pair(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}

	public Pair getLocation(char board[][], int R, int C, char c)
	{
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (board[i][j] == c) return new Pair(i, j);

		System.err.println("The character does not exist on the board!!");
		return null;
	}

	public char[][] removeWandB(char board[][], int r, int c)
	{
		char newBoard[][] = new char[r][c];
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if ((board[i][j] == '#') || (board[i][j] == '.') || (board[i][j] == '+'))
				{
					newBoard[i][j] = board[i][j];
				}
				else if ((board[i][j] == 'b') || (board[i][j] == 'w'))
				{
					newBoard[i][j] = '.';
				}
				else
				{
					newBoard[i][j] = '+';
				}
			}
		}
		return newBoard;
	}

	public boolean boardContains(char board[][], int r, int c, char ch)
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (board[i][j] == ch) return true;
			}
		}
		return false;
	}

	public boolean inRange(Pair p, int R, int C)
	{
		return ((0<=p.i && p.i<R) && (0<=p.j && p.j<C));
	}

	public boolean isBlocker(char c)
	{
		return ((c=='#') || (c=='b') || (c=='B'));
	}

	public void doit() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new File("sokobanOutput.txt"));

		int gameNum = 1;
		for (;;)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r==0 && c==0) break;
			
			char board[][] = new char[r][c];
			sc.nextLine();
			for (int i = 0; i < r; i++) board[i] = sc.nextLine().toCharArray();

			char origBoard[][] = new char[r][c];
			origBoard = removeWandB(board, r, c);

			String instructions = sc.nextLine();
			boolean finished = false;
			for (int k = 0; k < instructions.length(); k++)
			{
				Pair start = new Pair();
				if (boardContains(board, r, c, 'w')) start = getLocation(board, r, c, 'w');
				else start = getLocation(board, r, c, 'W');

				char instruction = instructions.charAt(k);
				Pair oneAway = new Pair(start.i, start.j);
				Pair twoAway = new Pair(start.i, start.j);
				if ((instruction == 'U') || (instruction == 'D'))
				{
					if (instruction =='U')
					{
						oneAway.i -= 1;
						twoAway.i -= 2;
					}
					else
					{
						oneAway.i += 1;
						twoAway.i += 2;
					}
				}
				else
				{
					if (instruction == 'L')
					{
						oneAway.j -= 1;
						twoAway.j -= 2;
					}
					else
					{
						oneAway.j += 1;
						twoAway.j += 2;
					}
				}

				if (inRange(oneAway, r, c))
				{
					// If moving one space away is within range.
					if (board[oneAway.i][oneAway.j] != '#')
					{
						// And the space one away is not a wall.
						if (inRange(twoAway, r, c))
						{
							if (!isBlocker(board[twoAway.i][twoAway.j]))
							{
								// Then we can move a box here if there is a box one away.
								if (board[oneAway.i][oneAway.j] == 'b' || board[oneAway.i][oneAway.j] == 'B')
								{
									if (board[twoAway.i][twoAway.j] == '.')
									{
										board[twoAway.i][twoAway.j] = 'b';
										board[oneAway.i][oneAway.j] = origBoard[oneAway.i][oneAway.j];
									}
									else if (board[twoAway.i][twoAway.j] == '+')
									{
										board[twoAway.i][twoAway.j] = 'B';
										board[oneAway.i][oneAway.j] = origBoard[oneAway.i][oneAway.j];
									}
								}
							}
						}

						if (board[oneAway.i][oneAway.j] == '.')
						{
							board[oneAway.i][oneAway.j] = 'w';
							board[start.i][start.j] = origBoard[start.i][start.j];
						}
						else if (board[oneAway.i][oneAway.j] == '+')
						{
							board[oneAway.i][oneAway.j] = 'W';
							board[start.i][start.j] = origBoard[start.i][start.j];	
						}
					}
				}

				ps.println("At move number " + (k+1) + " we do instruction " + instruction);
				printoutBoardPS(board, r, c, ps);
				ps.println();

				if (!boardContains(board, r, c, 'b'))
				{
					finished = true;
					System.out.println("Game " + gameNum + ": complete");
					printoutBoard(board, r, c);
					break; 
				}
			}

			if (!finished)
			{
				System.out.println("Game " + gameNum + ": incomplete");
				printoutBoard(board, r, c);
			}
			gameNum++;
		}
	}

	public void printoutBoardPS(char board[][], int r, int c, PrintStream ps) throws Exception
	{
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				ps.print(board[i][j]);
			}
			ps.println();
		}
	}

	public void printoutBoard(char board[][], int R, int C)
	{
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws Exception
	{
		new Sokoban().doit();
	}
}