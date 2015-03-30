import java.io.*;
import java.util.*;

public class CountCousins
{
   public class Node
   {
      int numKids, numGrandKids;
      Node parent;
   
      Node(Node parent)
      {
         this.numKids = 0;
         this.numGrandKids = 0;
         this.parent = parent;
      }
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
   
   	// This is used to match up node numbers with Node objects
      HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
      Node tree[] = new Node[1000];
   
      for (;;)
      {
      	// The first integer in the sequence in the sequence is the root of the tree.
         int n = sc.nextInt();
         int k = sc.nextInt();
         if (n==0) 
            break;
      
      	// Set all the elements in the node array to null to start with a new tree.
         Arrays.fill(tree, null);
      
      	// The first integer input is always the root.
         int root = sc.nextInt();
      	
      	// We set the zeroth indexed node in the node array to a new node with a parent value set to null,
      	// a kids value set to zero, and a grandkids set to a value of zero.
         tree[0] = new Node(null);
      
      	// Here we are removing all the mappings from the "nodes" hashmap. Thus resetting it for this problem.
         nodes.clear();
      
      	// Here the return value of put is V
      	// put(K key, V value)
      	// This method associates the specified value with the specified key in this map.
         nodes.put(root, tree[0]);
      
      	// The root is the very first parent.
      	// We'll also need to know the last node number.
         int parent = -1;
         int last = -1;
         for (int i = 1; i < n; i++)
         {
         	// Get the next node number.
         	// If the next node is not sequential (i.e. one more than the last)
         	// then we've moved on to the next node as a parent.
            int nodenum = sc.nextInt();
            if (nodenum > (last+1)) ++parent;
         
         	// Create the new node, map it's node number to it.
            tree[i] = new Node(tree[parent]);
            nodes.put(nodenum, tree[i]);
         
         	// The parent now has one more kid.
            tree[parent].numKids++;
         
         	// And the grandparent has one more grandkid.
            if (tree[parent].parent != null) tree[parent].parent.numGrandKids++;
         
         	// This is now the last node number.
            last = nodenum;
         }
      
      	// V get(Object key)
      	// Returns the value to which the specified key is mapped, or null
      	// if this map contains no mapping for the key.
         Node node = nodes.get(k);
      
         if (node == null)
         {
            System.err.println("The input is wrong!!!");
         }
         else if (node.parent == null || node.parent.parent == null)
         {
         	// This node has no parent or grandparent, therefore it cannot have any cousins
            System.out.println(0);
         }
         else
         {
         	// The number of cousins is the number of nodes which share a grandparent,
         	// but not a parent.
            System.out.println( node.parent.parent.numGrandKids - node.parent.numKids);
         }
      }
   }

   public static void main(String args[])
   {
      new CountCousins().doit();
   }
}