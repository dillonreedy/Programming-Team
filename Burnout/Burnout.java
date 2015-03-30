import java.io.*;
import java.util.*;

// Given something in the following form
// (1 (2)*3 4)*5
public class Burnout
{
	// "(1 (2)*3 4)*5"
	// "1 (2)*3 4"
	// "(2)*3"

	// "2 2 2"
	// "1 2 2 2 4"
	// "1 2 2 2 4 1 2 2 2 4 1 2 2 2 4"
	

	public String recurse(String orig)
	{
		if (orig.indexOf("(") > 0)
		{
			int startIndex = orig
			int endIndex = orig.lastIndexOf(")");
		}
		else
		{
			return orig;
		}
	}

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt();
			if (n==0) break;

			String line = sc.nextLine();
			recurse(line);

		}
	}

	public static void main(String args[])
	{
		new Burnout().doit();
	}
}