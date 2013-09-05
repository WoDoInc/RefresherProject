package refresher.generic.queue;

import java.util.Arrays;
import refresher.generic.stack.Stack;

public class Queue
{
   private String[] queueArray;
   private int queueSize = 0;

   private int front, numberOfItems, rear = 0;
   
   public Queue(int size)
   {
      queueSize = size;
      queueArray = new String[queueSize];
      
      Arrays.fill(queueArray, "-1");
   }
   
   public void insert(String string)
   {
      if (numberOfItems + 1 < queueSize)
      {
         queueArray[rear] = string;
         rear++;
         numberOfItems++;
      }
      else
      {
         System.out.println("Maximum reached within the queue.");
      }
   }
   
   public void priorityInsert(String string)
   {
      int i;
      
      if (numberOfItems == 0)
      {
         insert(string);
      }
      else
      {
         for (i = numberOfItems - 1; i >= 0; i--)
         {
            if (Integer.parseInt(string) > Integer.parseInt(queueArray[i]))
            {
               queueArray[i + 1] = queueArray[i];
            }
            else
            {
               break;
            }
         }
         
         queueArray[i+1] = string;
         rear++;
         numberOfItems++;
      }
   }
   
   public String remove()
   {
      String result = null;
      
      if (numberOfItems > 0)
      {
         result = queueArray[front];
         queueArray[front] = "-1";
         front++;
         numberOfItems--;
      }
      else
      {
         System.out.println("Queue is empty.");
      }
      
      return result;
   }
   
   public String peek()
   {
      return queueArray[front];
   }
   
   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Queue queue = new Queue(10);
      queue.insert("10");
      queue.insert("17");
      queue.insert("13");

      // Look at the top value on the stack
      System.out.println("Peeking at the following value: " + queue.peek());
      
      queue.remove();
      // Look at the top value on the stack
      System.out.println("Peeking at the following value: " + queue.peek());
      
      Queue priorityQueue = new Queue(10);
      priorityQueue.insert("10");
      priorityQueue.insert("17");
      priorityQueue.insert("11");
      priorityQueue.insert("10");
      priorityQueue.insert("20");
      
      System.out.println(priorityQueue);
   }
}
