import java.io.*;
import java.util.*;

public class Parity2
{
	public int numOnes(String str)
	{
		char chars[] = str.toCharArray();
		int count = 0;
		for (int i = 0; i < str.length(); i++) if (chars[i] == '1') count++;

		return count;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		while (!line.equals("#"))
		{	
			String takeRest = line.substring(0,line.length()-1);
			if (line.charAt(line.length()-1) == 'e')
			{
				if (numOnes(line)%2!=0) takeRest+="1";
				else takeRest+="0";
			}
			else
			{
				if (numOnes(line)%2==0) takeRest+="1";
				else takeRest+="0";
			}
			System.out.println(takeRest);
			line = sc.nextLine();
		}
	}

	public static void main(String args[])
	{
		new Parity2().doit();
	}
}