import java.io.*;
import java.util.*;

public class Steg
{
	public char intToChar(int i)
	{
		char chars[] = " ABCDEFGHIJKLMNOPQRSTUVWXYZ',-.?".toCharArray();
		if (0<=i && i<32)
		{
			return chars[i];
		}
		else
		{
			System.err.println("The given integer is out of range!!!");
			return '/';
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		while (!line.equals("#"))
		{
			ArrayList<String> lines = new ArrayList<String>();
			while (!line.equals("*"))
			{
				lines.add(line);
				line = sc.nextLine();
			}
	
			String wholeLine = "";
			for (String curLine : lines) wholeLine+=curLine;

			String message = "";
			while (wholeLine.contains(" "))
			{
				int nextSpace = wholeLine.indexOf(" ");
				wholeLine = wholeLine.substring(nextSpace+1, wholeLine.length());
				int numConsecSpaces = 1;
				while (wholeLine.charAt(0) == ' ')
				{
					numConsecSpaces++;
					wholeLine = wholeLine.substring(1, wholeLine.length());
				}

				if (numConsecSpaces%2==0) message+="1";
				else message+="0";
			}

			while (message.length()%5 != 0) message+="0";

			int n = message.length()/5;
			for (int i = 0; i < n; i++)
			{
				String chunk = message.substring(0,5);
				Byte b = Byte.parseByte(chunk, 2);
				int bVal = ((int) b);
				System.out.print(intToChar(bVal));
				message = message.substring(5,message.length());
			}
			System.out.println();
			line = sc.nextLine();
		}
	}

	public static void main(String args[])
	{
		new Steg().doit();
	}
}