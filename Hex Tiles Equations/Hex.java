import java.util.*;
import java.io.*;

//		1	2	3	4	5
//1: 		1 		2
//2: 	3		X		4
//3:		5		6	

// 			(1,2)	(1,4)
//		(2,1)	(2,3)	(2,5)
//			(3,2)	(3,4)

//			(-1,-1)	(-1,+1)
//		(0,-2)	(0,0)	(0,+2)
//			(+1,-1)	(+1,+1) 	

public class Hex
{
	// The number of rows: R | (R>2) && (R%2==1)
	// The number of tiles: T | (curRow%2==0) then 
	// The rows are numbered from 1 to N, starting at the the top and making its way down.

	// There is exactly one '='
	// The number of multiplication symbols: M | (0<=M) && (M<=2)
	// The total number of hex tiles: H | (H<15)
	// 

	public void doit()
	{
		Scanner sc = new Scanner(System.in);

	}

	public static void main(String args[])
	{
		new Hex().doit();
	}
}