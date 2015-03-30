import java.io.*;
import java.util.*;

public class Parity
{
	public int numOfChar(char c, String str)
	{
		int count = 0;
		char chars[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) if (chars[i] == c) count++;

		return count;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		// A bit string has odd parity if the number of 1's is odd.

		String line = sc.nextLine();
		while (!line.equals("#"))
		{
			int numOnes = numOfChar('1', line);
			String takeRest = line.substring(0,line.length()-1);
			if (line.charAt(line.length()-1)=='e')
			{
				if (numOnes%2!=0) takeRest += "1";	
				else takeRest += "0";
			}
			else
			{
				if (numOnes%2==0) takeRest += "1";
				else takeRest += "0";
			}

			System.out.println(takeRest);
			line = sc.nextLine();
		} 
	}

	public static void main(String args[])
	{
		new Parity().doit();
	}
}