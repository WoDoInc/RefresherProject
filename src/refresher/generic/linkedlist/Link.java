package refresher.generic.linkedlist;

public class Link<T>
{
   public T data;
   public Link<T> nextLink;

   /**
    * Constructor for the link. Assigns data to the link object.
    * 
    * 
    */
   public Link(T data)
   {
      this.data = data;
   }

   //Print Link data
   public String toString()
   {
       return data.toString();
   }
}
