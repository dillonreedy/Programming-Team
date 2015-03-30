import java.io.*;
import java.util.*;

public class MarbleInputCreator
{
	public static void main(String args[]) throws Exception
	{
		PrintStream ps = new PrintStream(new File("marbleInput2.txt"));

		ps.println("100000");
		for (int i = 0; i < 100000; i++)
		{
			ps.print("1000 ");
		}
		ps.println();
	}
}