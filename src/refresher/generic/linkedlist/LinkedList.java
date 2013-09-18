package refresher.generic.linkedlist;
class LinkedList
{
   
   private Link<Integer> head;

   /**
    * The linked list constructor. Creates the initial reference, which is set to null.
    */
   public LinkedList()
   {
	   head = null;
   }

   /**
    * Returns true of the list is empty.
    * 
    * @return True if empty, false otherwise.
    */
   public boolean isEmpty()
   {
	   return head == null;
   }

   /**
    * Inserts a link at the front of the list.
    * 
    * @param data The data to insert in front.
    */
   public void insertFront(int data)
   {
	   Link<Integer> link = new Link<>(data);
	   link.setNext(head);
	   head = link;
   }

   /**
    * Deletes the link at the front of the list.
    * 
    * @return Returns the deleted data.
    */
   public Link<Integer> delete()
   {
	   Link<Integer> temp = head;
	   head = head.getNext();
	   return temp;
   }

   public Link<Integer> find(Link<Integer> head, Integer data)
   {
      while(head != null && head.getData() != data)
      {
         head = head.getNext();
      }
      
      return head;
   }
   
   /**
    * Prints the list. This is a simple System.out.print. Change to a log or String for alternative print methods.
    */
   public void printList()
   {
	   Link<Integer> currentLink = head;
	   System.out.println("List: ");
	   while(currentLink != null)
	   {
          System.out.println(currentLink.toString());
          currentLink = currentLink.getNext();
	   }
   }
    
   public static void main(String[] args)
   {
	   LinkedList list = new LinkedList();
	   list.insertFront(1);
	   list.insertFront(2);
	   list.insertFront(3);
	   list.insertFront(4);
	   list.insertFront(5);
	   list.printList();

      while(!list.isEmpty())
	   {
		   Link<Integer> deletedLink = list.delete();
		   System.out.println("Deleted: " + deletedLink.toString());
	   }

      list.printList();
   }
}
