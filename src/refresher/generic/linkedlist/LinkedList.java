package refresher.generic.linkedlist;
class LinkedList
{
   
   private Link<Integer> first;

   //LinkList constructor
   public LinkedList()
   {
	   first = null;
   }

   //Returns true if list is empty
   public boolean isEmpty()
   {
	   return first == null;
   }

   //Inserts a new Link at the first of the list
   public void insert(int data)
   {
	   Link<Integer> link = new Link<>(data);
	   link.nextLink = first;
	   first = link;
   }

   //Deletes the link at the first of the list
   public Link<Integer> delete()
   {
	   Link<Integer> temp = first;
	   first = first.nextLink;
	   return temp;
   }

   //Prints list data
   public void printList()
   {
	   Link<Integer> currentLink = first;
	   System.out.println("List: ");
	   while(currentLink != null)
	   {
          System.out.println(currentLink.toString());
          currentLink = currentLink.nextLink;
	   }
   }
    
   public static void main(String[] args)
   {
	   LinkedList list = new LinkedList();
	   list.insert(1);
	   list.insert(2);
	   list.insert(3);
	   list.insert(4);
	   list.insert(5);
	   list.printList();

      while(!list.isEmpty())
	   {
		   Link<Integer> deletedLink = list.delete();
		   System.out.println("deleted: " + deletedLink.toString());
	   }

      list.printList();
   }
}
