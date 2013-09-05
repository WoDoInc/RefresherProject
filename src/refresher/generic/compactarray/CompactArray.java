package refresher.generic.compactarray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CompactArray<T>
{
   /**
     * Compact an array, removing elements
     * whose indexes are listed in an
     * array of indexes
     *
     * @param original The array to be compacted
     * @param removals The indexes of the elements to remove
     *
     * @return The compacted array
     */
   public static <T> T[] compact(T[] original, int[] removals)
   {
      T[] result = (T[]) Array.newInstance(original[0].getClass(), original.length - removals.length);
      int ixRemovals = 0;
      int ixResult = 0;

      for (int i = 0; i < original.length; i++)
      {
         if ((ixRemovals < removals.length) && (i == removals[ixRemovals]))
         {
            ixRemovals++;
         }
         else
         {
            result[ixResult++] = original[i];
         }
      }

      return result;
   }

   /**
     * Compact an array, 'removing' any element that
     * is null
     *
     * @param original The array to be compacted
     *
     * @return The compacted array
     */
   public static <T> T[] compact(T[] original)
   {
      T[] result = null;
      int ix = 0;
      
      for (int i = 0; i < original.length; i++)
      {
         if (original[i] != null)
         {
            original[ix++] = original[i];
         }
      }

      if (ix != original.length)
      {
         int i;

         for (i = 0; (i < original.length) && (original[i] == null); i++)
         {}

         if (i == original.length)
         {
            throw new RuntimeException(
               "All elements null. Cannot determine element type");
         }

         result = (T[]) Array.newInstance(original[i].getClass(), ix);
         System.arraycopy(original, 0, result, 0, result.length);
      }

      return result;
   }
       
   /**
    * Remove duplicates from an array, sort, compact.
    */
   public static void compactArray(char[] array)
   {
      Arrays.sort(array);
      char resultArray[] = new char[array.length];
      resultArray[0] = array[0];
      int k = 1;
      for (int i = 0; i < array.length - 1; i++) {
          if(array[i+1] > array[i]) {
              resultArray[k] = array[i + 1];
              k++;
          }
      }
      resultArray = Arrays.copyOf(resultArray, k);
      System.out.println("Array: " + Arrays.toString(resultArray) + " Size of array: " + resultArray.length);
   }
   
   /**
    * Just for demo
    *
    * @param args The command line args
    */
   public static void main(String[] args)
   {
      Integer[] a1 = { 1, 2, 5, 6, 3, 8 };
      // Show original
      System.out.println(java.util.Arrays.toString(a1));
      // Delete the element '5'
      a1[2] = null;
      a1 = (Integer[]) CompactArray.compact(a1);
      System.out.println(java.util.Arrays.toString(a1));

      Integer[] a2 = { 1, 2, 5, 6, 3, 8 };
      // Remove first three elements
      a2 = (Integer[]) CompactArray.compact(a2, new int[] { 0, 1, 2 });
      System.out.println(java.util.Arrays.toString(a2));
      
      char[] a3 = new char[] {'h', 'a', 'b', 'c', 'b', 'g', 'z'};
      // Compact duplicates and sort.
      compactArray(a3);
   }
}
