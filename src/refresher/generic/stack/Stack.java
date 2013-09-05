package refresher.generic.stack;

import java.util.Arrays;

public class Stack
{
   private String[] stackArray;
   private int stackSize = 0;
   private int topOfStack = -1;
   
   public Stack(int size)
   {
      stackSize = size;
      stackArray = new String[stackSize];
      
      Arrays.fill(stackArray, "-1");
   }
   
   public void push(String string)
   {
      if (topOfStack + 1 < stackSize)
      {
         topOfStack++;
         stackArray[topOfStack] = string;
      }
      else
      {
         System.out.println("Maximum reached within the stack.");
      }
   }
   
   public String pop()
   {
      String result = null;
      
      if (topOfStack >= 0)
      {
         result = stackArray[topOfStack];
         stackArray[topOfStack] = "-1";
         topOfStack--;
      }
      else
      {
         System.out.println("Nothing within the stack.");
      }
      
      return result;
   }
   
   public void popAll()
   {
      for(int i = topOfStack; i >= 0; i--)
      {
         pop();
      }
   }

   public void popDisplayAll()
   {
      String theReverse = "";

      for(int i = topOfStack; i >= 0; i--)
      {
         theReverse += stackArray[i];
      }

      System.out.println("The Reverse: " + theReverse);
      popAll();
   }

   public String peek()
   {
      return stackArray[topOfStack];
   }

   public void pushMany(String multipleValues)
   {
      String[] tempString = multipleValues.split(" ");
      for(int i = 0; i < tempString.length; i++)
      {
         push(tempString[i]);
      }
   }

   public void displayTheStack()
   {
            
      for(int n = 0; n < 61; n++)
         System.out.print("-");
      System.out.println();
       
      for(int n = 0; n < stackSize; n++)
      {
          System.out.format("| %2s "+ " ", n);
      }
       
      System.out.println("|");
      for(int n = 0; n < 61; n++)
         System.out.print("-");
      System.out.println();

      for(int n = 0; n < stackSize; n++)
      {
         if(stackArray[n].equals("-1"))
            System.out.print("|     ");
         else
            System.out.print(String.format("| %2s "+ " ", stackArray[n]));
      }
       
      System.out.println("|");
      for(int n = 0; n < 61; n++)
         System.out.print("-");

      System.out.println();
    }

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Stack stack = new Stack(10);
      stack.push("10");
      stack.push("17");
      stack.push("13");

      // Look at the top value on the stack
      System.out.println("Peeking at the following value: " + stack.peek());

      // Remove values from the stack (LIFO)
      stack.pop();
      stack.pop();
      stack.pop();

      // Add many to the stack
      stack.pushMany("J Y R T U M");

      // Remove all from the stack
      // theStack.popAll();
      
      // Remove all from the stack and print them
       stack.popDisplayAll();
      // stack.displayTheStack();
   }
}
