import java.io.*;
import java.util.*;

public class Voting
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		while (!line.equals("#"))
		{
			char letters[] = line.toCharArray();

			int votes[] = new int[4]; // Y - 0
									  // N - 1
									  // A - 2
									  // P - 3

			for (char c : letters)
			{
				if (c=='Y')
				{
					votes[0]+=1;
				}
				else if (c=='N')
				{
					votes[1]+=1;
				}
				else if (c=='A')
				{
					votes[2]+=1;
				}
				else if (c=='P')
				{
					votes[3]+=1;
				}
			}

			int half = 0;
			if (letters.length%2 == 0)
			{
				half = letters.length/2;
			}
			else
			{
				half = (letters.length/2)+1;
			}

			if (votes[2] >= half)
			{
				System.out.println("need quorum");
			}
			else if (votes[0] > votes[1])
			{
				System.out.println("yes");
			}
			else if (votes[1] > votes[0])
			{
				System.out.println("no");
			}
			else if (votes[1] == votes[0])
			{
				System.out.println("tie");
			}

			line = sc.nextLine();
		}
	}

	public static void main(String args[])
	{
		new Voting().doit();
	}
}