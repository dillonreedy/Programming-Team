import java.io.*;
import java.util.*;

public class Magnets
{
	public int charToInt(char c)
	{
		char lets[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

		for (int i = 0; i < lets.length; i++) if (c==lets[i]) return i;

		System.err.println("This letter is not contained within our alphabet!!!");
		return -1;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		ArrayList<String> lines = new ArrayList<String>();
		String line = sc.nextLine();
		while (!line.equals("END"))
		{
			lines.add(line);
			line = sc.nextLine();
		}

		for (int i = 0; i < lines.size(); i++)
		{
			boolean alreadyHere[] = new boolean[26];
			String curLine = lines.get(i).replaceAll("\\s+","");
			boolean isValid = true;
			for (int j = 0; j < curLine.length(); j++)
			{
				int charIndex = charToInt(curLine.charAt(j));
				if (alreadyHere[charIndex])
				{
					isValid = false;
					break;
				}
				else
				{
					alreadyHere[charIndex] = true;
				}
			}

			if (isValid) System.out.println(lines.get(i));
		}
	}

	public static void main(String args[])
	{
		new Magnets().doit();
	}
}