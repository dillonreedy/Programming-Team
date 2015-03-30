import java.io.*;
import java.util.*;


// Ways you can win:
// Take as many cards as we can get after our first two cards.
// Take no cards after our first two cards.
// 

public class NoWin
{
	public int minAce(char c)
	{
		char chars[] = "A23456789".toCharArray();
		for (int i = 0; i < chars.length; i++) if (c==chars[i]) return (i+1);

		return 10;
	}

	public int maxAce(char c)
	{
		char chars[] = "23456789".toCharArray();
		for (int i = 0; i < chars.length; i++) if (c==chars[i]) return (i+2);

		if (c=='A') return 11;

		return 10;
	}

	public int aceHere(char cards[])
	{
		
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		while (!line.equals("JOKER"))
		{
			char cards[] = line.toCharArray();
			int score1 = 0;
			int score2 = 0;
			score1+=minAce(cards[0]);
			score2+=minAce(cards[1]);
			score1+=minAce(cards[2]);
			score2+=minAce(cards[3]);

			for (int i = 4; i < )

			line = sc.nextLine();
		}
	}

	public static void main(String args[])
	{
		new NoWin().doit();
	}
}