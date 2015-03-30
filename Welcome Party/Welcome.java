import java.io.*;
import java.util.*;

public class Welcome
{
	// Teas where first name begin with the same letter
	// first name teams = [0,0..,0]
	// second name teams = []

	// [S=1]
	// [C=1]
	public class Name
	{
		String firstName, lastName;
		Name(String firstName, String lastName)
		{
			this.firstName = firstName;
			this.lastName = lastName;
		}

		// returns 0 if they belong in the same group
		// returns -1 if they do not belong in the same group
		public int compareTo(Name givenName)
		{
			if (this.firstName.charAt(0) == givenName.firstName.charAt(0))
			{
				return 0;
			}
			else
			{
				if (this.lastName.charAt(0) == givenName.lastName.charAt(0))
				{
					return 0;
				}
				else
				{
					return -1;
				}
			}
		}
	}

	public boolean[][] fillRow(int i, int c,  boolean table[][])
	{
		for (int j = 0; j < c; j++)
			table[i][j] = true;
		return table;
	}

	public boolean[][] fillCol(int j, int r, boolean table[][])
	{
		for (int i = 0; i < r; i++)
			table[i][j] = true;
		return table;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			boolean table[][] = new boolean[n][n];
			int score[][] = new int[n][n];


			int teams = 0;
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
					
			}

		}
	}

	public static void main(String args[])
	{
		new Welcome().doit();
	}
}