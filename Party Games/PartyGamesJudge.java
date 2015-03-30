import java.io.*;
import java.util.*;

public class PartyGamesJudge
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			String names[] = new String[n];
			sc.nextLine();
			for (int i = 0; i < n; i++) names[i] = sc.nextLine();

			Arrays.sort(names);
			String a = names[n/2-1];
			String b = names[n/2];

			String result = "";

			// String c will be a substring of a that we base the result on.
			String c = "";

			// Go from the shortest possible string to the largest,
			// looking for one that works.
			for (int i = 0; i < a.length(); i++)
			{
				// Get the next character of a
				char ch = a.charAt(i);

				// In order for the result to be greater than or equal
				// to a, then the last letter must be one more than 
				// the corresponding letter of a. There are two exceptions:
				// If this letter is Z, then there is no letter. And, if 
				// it's the last letter of a, then we can just use a
				// as the result and we don't have to increment it.
				if (ch != 'Z' && i<a.length()-1) ++ch;

				result = c+ch;

				// If the string works hooray! and get out of the loop
				if (result.compareTo( a ) >= 0 && result.compareTo(b) < 0) break;

				// otherwise move on to the next character
				c += a.charAt(i);
			}

			System.out.println(result);
		}
	}

	public static void main(String args[])
	{
		new PartyGamesJudge().doit();
	}
}