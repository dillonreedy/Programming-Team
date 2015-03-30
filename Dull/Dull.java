import java.io.*;
import java.util.*;

// DLL - a file that contains a collection of pre-compiled functions that can be loaded
// into a program at runtime.

// 1) Only one copy of a DLL is needed in memory, regardless of how many different programs
// are using it at the same time.
// 2) Since they are seperate from programs

public class Dull
{
	public int charToInt(char c)
	{
		char alp[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for (int i = 0; i < alp.length; i++) if (c==alp[i]) return i;

		System.err.println("The given character was no where to be found in our alphabet!!!");
		return -1;
	}


	public void doit()
	{

		Scanner sc = new Scanner(System.in);

		for (;;)
		{
			int n = sc.nextInt(); // The number of DuLLs available 0<N && N<21
			if (n==0) break;
			int p = sc.nextInt(); // The number of programs which can be executed 0<P && P<10
			int s = sc.nextInt(); // The number of state transitions recorded 0<S && S<33

			int dullSize[] = new int[n];

			for (int i = 0; i < n; i++) dullSize[i] = sc.nextInt(); // The size of a DuLL can be 0<S && S<1001

			int programSize[] = new int[p];
			String dullsRequired[] = new String[p];

			for (int i = 0; i < p; i++)
			{
				programSize[i] = sc.nextInt();
				dullsRequired[i] = sc.nextLine().trim();
			} 

			int memory = 0;
			int maxMemory = 0;
			int dllReferences[] = new int[26];
			for (int i = 0; i < s; i++)
			{
				int q = sc.nextInt();

				if (q <= 0)
				{
					memory -= programSize[-q-1];

					String dlls = dullsRequired[-q-1];
					int adjustments = 0;

					for (int j = 0; j < dlls.length(); j++)
					{
						int d = charToInt(dlls.charAt(j));
						dllReferences[d]--;
						if (dllReferences[d] == 0) adjustments += dullSize[d];
					}

					memory -= adjustments;
				}
				else
				{	
					memory += programSize[q-1];

					String dlls = dullsRequired[q-1];

					int adjustment = 0;
					for (int j = 0; j < dlls.length(); j++)
					{
						int d = charToInt(dlls.charAt(j));
						if (dllReferences[d] == 0) adjustment+=dullSize[d];
						dllReferences[d]++;
					}
					memory += adjustment; 
				}

				if (memory > maxMemory) maxMemory = memory;
			}

			System.out.println(maxMemory);

		}
	}


	public static void main(String args[])
	{
		new Dull().doit();
	}
}