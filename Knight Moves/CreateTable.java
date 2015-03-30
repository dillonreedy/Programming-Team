import java.io.*;
import java.util.*;

public class CreateTable
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new File("output.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();

		char board[][] = new char[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(board[i], '.');

		board[0][0] = 'K';
		board[n-1][m-1] = 'X';

		for (int i = 0; i < n; i++) ps.println(new String(board[i]));
	}
}