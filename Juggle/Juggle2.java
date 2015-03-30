import java.io.*;
import java.util.*;

public class Juggle2
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			ArrayList<Integer> sequence = new ArrayList<Integer>(20);
			for (int i = 0; i < n; i++) sequence.add(sc.nextInt());

			// Here we fill up the sequence so that we know the numbers.
			while (sequence.size() != 20) sequence.add(sequence.get(sequence.size()%n));
			
			char pattern[] = new char[20];
			Arrays.fill(pattern, ' ');
			int numBalls = 0;
			boolean isCrash = false;

			for (int i = 0; i < 20; i++)
			{
				char c = pattern[i];
				if (c == ' ')
				{
					c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(numBalls);
					numBalls++;
					pattern[i] = c;
				}

				int j = sequence.get(i)+i;
				if (j < 20) // The next jump sequence is in bounds.
				{
					if (pattern[j] != ' ') // If the next jump location is not empty then we have a crash.
					{
						isCrash = true;
						break;
					}
					else pattern[j] = c;
				}
			}

			if (isCrash) System.out.println("CRASH");
			else System.out.println(new String(pattern));

		}
	}

	public static void main(String args[])
	{
		new Juggle2().doit();
	}
}