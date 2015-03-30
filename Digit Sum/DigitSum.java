import java.io.*;
import java.util.*;

// Input - N such that 2 <= N <= 14
         // We want to begin
         // Given
         // 0 1 2 3 4 0 1 2 3
         // 0 0 1 1 2 2 3 3 4
         // - [0,0,1,1,2,2,3,3,4]
         // insertNonZeroIntoLeft(List)
         // - 1 [0,0,1,2,2,3,3,4]
         // insertNonZeroIntoRight(List)
         // - 1 1 [0,0,2,2,3,3,4]
         // insertFirstElementIntoLeft
         // - 10 1 [0,2,2,3,3,4]
         // - 10 10 [2,2,3,3,4]
         // - 102 10 [2,3,3,4]
         // - 102 102 [3,3,4]
         // - 1023 102 [3,4]
         // - 1023 1023 [4]
         // - 10234 1023
         
public class DigitSum
{

   public int getFirstNonZero(int nums[], int n)
   {
      for (int i = 0; i < n; i++)
      {
         if (nums[i] > 0)
         {
            return nums[i];
         }
      }
      
      System.err.println("There is no nonzero digits in the list!!!");
      return -1;
   }

   public int[] removeFirstOfElement(int nums[], int n, int elem)
   {
      if (n==0) 
         return nums;
   
      int newNums[] = new int[n-1];
   
      boolean foundFirst = false;
      int count = 0;
      for (int i = 0; i < n; i++)
      {
         if ((!foundFirst) && (nums[i] == elem))
         {
            foundFirst = true;
         }
         else
         {
            newNums[count] = nums[i];
            count++;
         }
      }
      return newNums;
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
         
         int nums[] = new int[n];
         for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
         
         Arrays.sort(nums);
         int leftNum = getFirstNonZero(nums, n);
         nums = removeFirstOfElement(nums, n, leftNum);
         n--;
         int rightNum = getFirstNonZero(nums, n);
         nums = removeFirstOfElement(nums, n, rightNum);
         n--;
         
         boolean isLeft = true;
         for (int i = 0; i < n; i++)
         {
            if (isLeft)
            {
               leftNum*=10;
               leftNum+=nums[i];
               isLeft = false;
            }
            else
            {
               rightNum*=10;
               rightNum+=nums[i];
               isLeft = true;
            }
         }
         System.out.println(leftNum+rightNum);
      }
   }

   public static void main(String args[])
   {
      new DigitSum().doit();
   }
}