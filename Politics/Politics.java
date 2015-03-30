import java.io.*;
import java.util.*;

public class Politics
{
 // [("STEVENS",0), ("MICHAELS",0), ("JORDAN",0)]
 
 // supporter = "BOB", candidate = "JORDAN"
 // [("STEVENS",0), ("MICHAELS",0), ("JORDAN",0)]
 // ("JORDAN",0)
 // ("JORDAN",1)
 // [("STEVENS",0), ("MICHAELS",0), ("JORDAN",1)]
 //
 // supporter = "JACK", candidate = "STEVENS"
 // [("STEVENS",0), ("MICHAELS",0), ("JORDAN",1)]
 // ("STEVENS",0)
 // ("STEVENS",0)
 // [("STEVENS",1), ("MICHAELS",0), ("JORDAN",1)]
 //
 // supporter = "MACK", candidate = "MICHA"

	// This hash map will map each index to a unique integer, in order
   HashMap<String, Integer> indices = new HashMap<String, Integer>();
	
	// This is used to assign a unique integer to each index, in order
   int count = 0;

	// Add an index
	// If it's not there yet, give it a number and advance the count
	// If it's already there, do nothing.
	// @param index An index to add
   public void addIndex( String index )
   {
      if ( !indices.containsKey( index )) indices.put(index, count++);
   }

   public class IndexedValue implements Comparable<IndexedValue>
   {
   	// Index, value
      String candidate, supporter;
      int order;
   
      public IndexedValue(String candidate, String supporter, int order)
      {
         this.candidate = candidate;
         this.supporter = supporter;
      }
   
   	// Compare this indexedValue to another, first by index, then by value
   	// @param is Another indexed value to compare with this one.
   	// @return -1, 0, or 1, as is usual for compareTo()
      public int compareTo( IndexedValue is )
      {
      	// First, compare by index, using the assigned number
         int diff = indices.get( candidate ).compareTo( indices.get( is.candidate ));
      
         if (diff==0) diff = order - is.order;
         return diff;
      }
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
      for (;;)
      {
         int n = sc.nextInt();
         int m = sc.nextInt();
         if (n==0) 
            break;
      
      	// Here we read in the indices.
         indices.clear();
         count = 0;
         for (int i = 0; i < n; i++) addIndex( sc.next() );
      
      	// Here we read in the values.
         IndexedValue values[] = new IndexedValue[m];
      
         for (int i = 0; i < m; i++)
         {
            String supporter = sc.next();
            String candidate = sc.next();
            values[i] = new IndexedValue( candidate, supporter, i);
         
         	// Gotta add this index if it's not already there.
            addIndex( candidate );
         }
      
         Arrays.sort( values );
      
         for (IndexedValue iv : values) System.out.println(iv.supporter);
      }
   }

   public static void main(String args[])
   {
      new Politics().doit();
   }
}