// You want to decorate your floor with tiles
// We like rectangles.

// With 6 square flooring tiles we can form exactly 2 unique rectangles:
// 1.) Block A1: 1x6 (6x1 is considered the same thing)
// 2.) Block B1: 2x3 (3x2 is considered the same thing)

// With 4 square flooring tiles we can form exactly 2 unique rectangles:
// 1.) Block A2: 1x4 (4x1 is considered the same thing)
// 2.) Block B2: 2x2 

// A1: 1x6
// [ ][ ][ ][ ][ ][ ]

// B1: 2x3
// [ ][ ][ ]
// [ ][ ][ ]

// A2: 1x4
// [ ][ ][ ][ ]

// B2: 2x2
// [ ][ ]
// [ ][ ]

// What is the smallest number of square tiles needed to be able to make
// exactly N unique rectangles?

// F(1) = 1
// F(2) = 4

import java.io.*;
import java.util.*;

public class FlooringTiles
{
	// Find the smallest number that has exactly 'n' factors
	// with 'p' as its smallest prime factor.

	// How do we find a number that has exactly 'n' factors?
	// 		Assume p, q, and r are all primes.
	//			1.) How many factors does p have? 2: 1 and p
	//			2.) How many factors does p^2 have? 3: 1, p, and p^2
	//			3.) So p^i has i+1 factors.

	//			1.) Now, what about p*q? That has 4: 1, p, q, and p*q
	//			2.) p*p*q? 6: 1, p, q, p*q, p*p, p*p*q
	//			3.) p*p*p*q? 8: 1, p, q, p*p, p*q, p*p*q, p*p*p, p*p*p*q
	//			4.) p^i*q^j has (i+1)*(j+1)

	public void doit()
	{
		Scanner sc = new Scanner(System.in);
		for (;;)
		{
			int n = sc.nextInt(); // An integer
		}
	}

	public static void main(String args[])
	{
		new FlooringTiles().doit();
	}
}