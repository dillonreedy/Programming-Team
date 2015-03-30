import java.io.*;
import java.util.*;

public class HashSetTests
{
	public void doit()
	{
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> nums = new HashSet<Integer>();

		int n = sc.nextInt();
		System.out.println("Input 1 to add, input 2 to remove:");
		for (int i = 0; i < n; i++)
		{
			if (sc.nextInt() == 1)
			{
				nums.add(sc.nextInt());
			}
			else
			{
				nums.remove(sc.nextInt());
			}
			System.out.println(nums.toString());
		}
	}

	public static void main(String args[])
	{
		new HashSetTests().doit();
	}
}