import java.io.*;
import java.util.*;

public class SortMe
{

   char alphabet[];

   public class Word implements Comparable<Word>
   {
      private String givenWord;
      
      Word(String givenWord)
      {
         super();
         this.givenWord = givenWord;
      }
      
      public String getGivenWord()
      {
         return this.givenWord;
      }
      
      public void setGivenWord(String givenWord)
      {
         this.givenWord = givenWord;
      }
      
      public int getIndexInAlphabet(char c)
      {
         for (int i = 0; i < alphabet.length; i++)
         {
            if (c == alphabet[i]) 
               return i;
         }
         
         System.err.println("There is no letter in the alphabet for this!!!");
         return -1;
      }
      
      public int compareTo(Word compareWord)
      {
         // In the scenario where this word is a prefix of the compareword
         // i.e. this word = "HOW" and the compared word is "HOWEVER"
         // then 
         
         if (this.givenWord.indexOf(compareWord.givenWord) == 0)
         {
            return 1;
         }
         else if (compareWord.givenWord.indexOf(this.givenWord) == 0)
         {
            return -1;
         }
         else
         {
            int n = 0;
            if (this.givenWord.length() < compareWord.givenWord.length())
            {
               n = this.givenWord.length();
            }
            else
            {
               n = compareWord.givenWord.length();
            }
            char word1[] = this.givenWord.toCharArray();
            char word2[] = compareWord.givenWord.toCharArray();
            
            for (int i = 0; i < n; i++)
            {
               int k1 = getIndexInAlphabet(word1[i]);
               int k2 = getIndexInAlphabet(word2[i]);
               
               if (k1 > k2)
               {
                  return 1;
               }
               else if (k2 > k1)
               {
                  return -1;
               }
            }
         }
         
         System.err.println("There was no way to compare these two things!!!");
         return 0;
      }
      
   }

   public void doit()
   {
      
      
      Scanner sc = new Scanner(System.in);
   
      int count = 1;
   
      for (;;)
      {
         int n = sc.nextInt();
         if (n==0) 
            break;
      
         alphabet = sc.nextLine().toCharArray();
         
         Word words[] = new Word[n];
         for (int i = 0; i < n; i++) words[i] = new Word(sc.nextLine());
         
         // 1. The first letters are in alphabetical order.
         // 2. Among strings with the same prefix, like the prefix AN in ANTLER and
         //    ANY, they are ordered by the first character that is different, T or Y here.
         // 3. One whole string may be a prefix of another string, like HOW and HOWEVER.
         //    In this case the longer sequence comes after the shorter one.
         
         Arrays.sort(words);
         System.out.println("year " + count);
         count++;
         for (Word w : words)
         {
            System.out.println(w.givenWord);
         }
         
      }
   }

   public static void main(String args[])
   {
      new SortMe().doit();
   }
}