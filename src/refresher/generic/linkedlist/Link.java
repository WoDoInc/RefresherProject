package refresher.generic.linkedlist;

public class Link<T>
{
   private T data;
   private Link<T> next;

   /**
    * Constructor for the link. Assigns data to the link object.
    * 
    * 
    */
   public Link(T data)
   {
      this.data = data;
   }

   /**
    * Retrieve the data in the current link.
    * 
    * @return The data stored in this link.
    */
   public T getData()
   {
      return this.data;
   }
   
   /**
    * Set the data in the current link.
    */
   public void setData(T data)
   {
      this.data = data;
   }

   /**
    * Gets the next link.
    * 
    * @return The next link in the list.
    */
   public Link<T> getNext()
   {
      return this.next;
   }

   /**
    * Sets the next link.
    * 
    * @param next The next link to set.
    */
   public void setNext(Link<T> next)
   {
      this.next = next;
   }

   @Override
   public String toString()
   {
       return data.toString();
   }
}
