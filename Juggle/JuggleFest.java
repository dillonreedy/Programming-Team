import java.io.*;
import java.util.*;

public class JuggleFest
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			ArrayList<Integer> sequence = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) sequence.add(sc.nextInt());

			while (sequence.size() != 20) sequence.add(sequence.get(sequence.size() % n));

			char pattern[] = new char[20];
			Arrays.fill(pattern, ' '); // Assigns the space character value to each element of the "pattern"-character-array.
			int numBalls = 0;
			boolean isCrash = false;

			for (int i = 0; i < 20; i++)
			{
				char c = pattern[i];
				if (c == ' ') // If there is an empty space here, we need the next letter in the alphabet
				{
					c = ((char)('A' + numBalls)); //"ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(numBalls);
					numBalls++;
					pattern[i] = c;
				}

				int j = sequence.get(i)+i; // Calculate the next jump location
				if (j < 20) // Make sure the next jump location is in bounds
				{
					if (pattern[j] != ' ') // If there isn't an empty space here, then that means there are two balls landing at location j,
										   // thus a crash occurs.
					{
						isCrash = true;
						break;
					}
					else pattern[j] = c; // If there is an empty space here, place the current character into the next jumping location.
				}
			}

			if (isCrash) System.out.println("CRASH");
			else System.out.println(new String(pattern));
		}
	}

	public static void main(String args[])
	{
		new JuggleFest().doit();
	}
}