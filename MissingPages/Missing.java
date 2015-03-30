import java.io.*;
import java.util.*;

// 12 2
// [1,2,3,4,5,6,7,8,9,10,11,12]
// extractOutPage(nums, n)
// pageContains(page, n, p)
// printOutPage(page, p)

// 12 9
// [1,2,3,4,5,6,7,8,9,10,11,12]
// extractOutPage(nums, n)
// pageContains(page, n, p)
// removePage(nums, n)
// [3,4,5,6,7,8,9,10]
public class Missing
{
   public int[] extractOutPage(int nums[], int n)
   {
      int page[] = new int[4];
      page[0] = nums[0];
      page[1] = nums[1];
      page[2] = nums[n-2];
      page[3] = nums[n-1];
      return page;
   }

   public boolean pageContains(int page[], int elem)
   {
      for (int i = 0; i < 4; i++)
      {
         if (page[i] == elem) 
            return true;
      }
      return false;
   }
   
   public int[] removePage(int nums[], int n)
   {
      int newPage[] = new int[n-4];
      int j = 0;
      for (int i = 2; i < n-2; i++)
      {
         newPage[j] = nums[i];
         j++; 
      }
      return newPage;
   }

   public void printOutPage(int page[], int p)
   {
      for (int i = 0; i < 4; i++)
      {
         if (page[i] != p) System.out.print(page[i] + " ");
      }
      System.out.println();
   }

   public void doit()
   {
      Scanner sc = new Scanner(System.in);
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
            
         int p = sc.nextInt();
         
         int nums[] = new int[n];
         for (int i = 0; i < n; i++) nums[i] = i+1;
         
         int page[] = new int[4];
         page = extractOutPage(nums, n);
         while (!pageContains(page, p))
         {
            nums = removePage(nums, n);
            n-=4;
            page = extractOutPage(nums,n);
         }
         printOutPage(page, p);  
      }
   }

   public static void main(String args[])
   {
      new Missing().doit();
   }
}