package refresher.generic.linkedlist;
class LinkedList
{
   /** The head of the list. */
   private Link<Integer> head;
   
   /** The tail of the list. */
   private Link<Integer> tail;

   /**
    * The linked list constructor. Creates the initial references, which are set to null.
    */
   public LinkedList()
   {
	   this.head = null;
	   this.tail = null;
   }

   /**
    * Returns true of the list is empty.
    * 
    * @return True if empty, false otherwise.
    */
   public boolean isEmpty()
   {
	   return this.head == null;
   }

   /**
    * Inserts a link at the front of the list.
    * 
    * @param data The data to insert in front.
    */
   public void insertFront(int data)
   {
	   Link<Integer> link = new Link<>(data);
	   
	   if (link.getNext() == null)
	   {
	      this.tail = this.head;
	   }
	   
	   link.setNext(this.head);
	   this.head = link;
   }

   /**
    * Deletes the link at the front of the list.
    * 
    * @return Returns the deleted data.
    */
   public Link<Integer> removeHead()
   {
	   Link<Integer> temp = this.head;
	   this.head = this.head.getNext();
	   if (this.head.getNext() == null)
	   {
	      this.tail = head.getNext();
	   }
	   
	   return temp;
   }

   /**
    * Deletes the given link.
    * 
    * @param link The link to delete.
    * @return
    */
   public boolean remove(Link<Integer> link)
   {
      Link<Integer> position = this.head;
      
      if (link == null || this.head == null)
      {
         return false;
      }
      
      if (link.equals(this.head))
      {
         this.head = link.getNext();
         if (this.head == null)
         {
            this.tail = null;
         }
         return true;
      }
      
      while (position != null)
      {
         if (position.getNext().equals(link))
         {
            position.setNext(link.getNext());
            if (position.getNext() == null)
            {
               this.tail = position;
            }
            
            return true;
         }
      }
         
      return false;  
   }
   
   /**
    * Find the data given the following.
    * 
    * @param link The link to begin the search.
    * @param data The data to find.
    * 
    * @return Returns the link containing the data.
    */
   public Link<Integer> find(Link<Integer> link, Integer data)
   {
      while(link != null && link.getData() != data)
      {
         link = link.getNext();
      }
      
      return link;
   }
   
   /**
    * Finds the Mth element from the end of the list.
    * 
    * @param head The head of the list.
    * @param mPosition The number of positions back to inspect.
    * @return Returns null if no Mth position exists, otherwise returns the Mth from last position.
    */
   public Link<Integer> findMtoLastElement(Link<Integer> head, Integer mPosition)
   {
      Link<Integer> current = head;
      Link<Integer> mBehind = head;
      
      // Advance current m elements from beginning, checking for the end of the list.
      for (int i = 0; i < mPosition; i++)
      {
         if (current.getNext() != null)
         {
            current = current.getNext();
         }
         else
         {
            return null;
         }
      }
      
      // Start mBehind and advance pointers together until current hits last element.
      while (current.getNext() != null)
      {
         current = current.getNext();
         mBehind = mBehind.getNext();
      }
      
      return mBehind;
   }
   
   /**
    * Prints the list. This is a simple System.out.print. Change to a log or String for alternative print methods.
    */
   public void printList()
   {
	   Link<Integer> currentLink = this.head;
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
		   Link<Integer> deletedLink = list.removeHead();
		   System.out.println("Deleted: " + deletedLink.toString());
	   }

      list.printList();
   }
}
