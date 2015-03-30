import java.io.*;
import java.util.*;

public class Mirror
{
	public boolean hasWrongChar(String orig)
	{					 // "abcdefg"
		char wrongChars[] = "acefghjklmnrstuyz".toCharArray();

		for (char c : wrongChars)
			if (orig.contains("" + c)) return true;

		return false;
	}

	public char convertChar(char c)
	{
		if (c=='b')
		{
			return 'd';
		}
		else if (c=='d')
		{
			return 'b';
		}
		else if (c=='p')
		{
			return 'q';
		}
		else if (c=='q')
		{
			return 'p';
		}
		else
		{
			return c;
		}
	}

	public String rev(String orig)
	{
		String result = "";
		for (int i = orig.length()-1; i >=0; i--)
			result = result + orig.charAt(i);
		return result;
	}

	public String executeMirror(String orig)
	{
		String result = "";
		String revStr = rev(orig);
		for (int i = 0; i < orig.length(); i++) result = result + convertChar(revStr.charAt(i));

		return result;
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		while (!line.equals("#"))
		{
			if (!hasWrongChar(line)) System.out.println(executeMirror(line));
			else System.out.println("INVALID");
			line = sc.nextLine();
		}
	}

	public static void main(String args[])
	{
		new Mirror().doit();
	}
}