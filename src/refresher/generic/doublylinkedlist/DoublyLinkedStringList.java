package refresher.generic.doublylinkedlist;

class DoublyLinkedStringList
{

   private Node head, tail;
   boolean forward;

   /**
    * This class represents the node for a doubly-linked list.
    *
    */
   private class Node
   {
      private String content;
      private Node next;
      private Node prev;

      public Node(String content)
      {
         this.content = content;
      }

      public Node(String content, Node next)
      {
         this.content = content;
         
         if (forward)
         {
            this.next = next;
         }
         else
         {
            this.prev = next;
         }
      }

      public Node getNext()
      {
         return (forward) ? next : prev;
      }
      
      public Node getPrev()
      {
         return (forward) ? prev : next;
      }

      public void setNext(Node next)
      {
         if (forward)
         {
            this.next = next;
         }
         else
         {
            this.prev = next;
         }
      }
   
      public void setPrev(Node prev)
      {
         if (forward)
         {
            this.prev = prev;
         }
         else
         {
            this.next = prev;
         }
      }
   }

   public DoublyLinkedStringList()
   {
      this.head = null;
      this.tail = null;
   }

   public Node prepend(String info)
   {
       Node newNode = new Node(info);
       newNode.setPrev(null);
       newNode.setNext(getHead());
       
       if (newNode.getNext()!=null)
       { 
         newNode.getNext().setPrev(newNode);
       }
       
       if (forward)
       {
          head = newNode;
       }
       else
       {
          tail = newNode;
       }
       
       if (getTail() == null)
       {
           if(forward)
           {
              tail = newNode;
           }
           else
           {
              head = newNode;
           }
       }
       
       return head;
   }

   public Node append(String info)
   {
       Node newNode = new Node(info);
       newNode.setPrev(getTail());
       newNode.setNext(null);
       
       if (newNode.getPrev() != null)
       { 
         newNode.getPrev().setNext(newNode);
       }
       
       if (forward)
       {
          tail = newNode;
       }
       else
       {
          head = newNode;
       }
       
       if (getTail() == null)
       {
           if(forward)
           {
              head = newNode;
           }
           else
           {
              tail = newNode;
           }
       }
       
       return tail;
   }
   
   public Node delete(int index)
   {
      Node currNode = getHead();
      int count = 0;

      if (index == 0)
      {
         if (forward)
         {
            head = head.next;
         }
         else
         {
            tail = tail.prev;
         }
         
         return head;
      }
   
      while (currNode != null)
      {
         if (count + 1 == index)
         {
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            break;
         }
         currNode = currNode.getNext();
         count++;
      }
      
      return currNode;
   }

   public Node getHead()
   {
      return (forward) ? head : tail;
   }
   
   public Node getTail()
   {
      return (forward) ? tail : head;
   }
   
   public DoublyLinkedStringList reverse()
   {
      forward = !forward; return this;
   }

   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      for (Node currNode = getHead(); currNode != null; currNode = currNode.getNext())
      {
         sb.append(currNode.content);
         if (currNode.getNext() != null)
         {
            sb.append(", ");
         }
      }
      
      return sb.toString();
   }

   public static void main(String argv[])
   {
      DoublyLinkedStringList list = new DoublyLinkedStringList();
      list.prepend("6");
      list.prepend("5");
      list.prepend("4");
      list.prepend("3");
      list.prepend("2");
      list.prepend("1");
      list.prepend("0");
      list.delete(3);
      System.out.println(list);
      System.out.println(list.reverse());
   }
}