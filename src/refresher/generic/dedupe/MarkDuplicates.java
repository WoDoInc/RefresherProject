package refresher.generic.dedupe;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MarkDuplicates
{
   
   /**
    * Method that identifies the duplicate Integers within a List. It then returns the Set of duplicate Integers.
    * 
    * @param listContainingDuplicates This is the list containing potential duplicates to be found.
    * @return Set The set containing all of the duplicate integers found in the list.
    */
   public static Collection<Integer> findDuplicates(List<Integer> listContainingDuplicates)
   { 
     final Collection<Integer> setWithDuplicates = new HashSet<Integer>(); 
     final Collection<Integer> trackDuplicates = new HashSet<Integer>();

     for (Integer element : listContainingDuplicates)
     {
        if (!trackDuplicates.add(element))
        {
           setWithDuplicates.add(element);
        }
     }
     
     return setWithDuplicates;
   }
   
   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Integer[] array = {1, 2, 2, 1, 1, 6, 6, 7, 8, 10};
      List<Integer> aList = Arrays.asList(array);
      Collection<Integer> duplicatesList = MarkDuplicates.findDuplicates(aList);
      
      System.out.println("The list of duplicates: " + duplicatesList.toString());
   }
}
