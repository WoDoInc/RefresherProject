package refresher.generic.reversearrayinplace;

public class Reverse
{
   public static void reverse(Integer[] a)
   {
      int l = a.length;
      for (int j = 0; j < l / 2; j++)
      {
         int temp = a[j];
         a[j] = a[l - j - 1];
         a[l - j - 1] = temp;
      }
   }

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Integer[] finalArray = new Integer[args.length];
      for (int i = 0; i < args.length; i++)
      {
         finalArray[i] = Integer.parseInt(args[i]);
      }

      System.out.println("Initial array: ");

      for (int initial : finalArray)
      {
         System.out.println(initial);
      }

      reverse(finalArray);
      System.out.println("Reversed array: ");

      for (int finalInt : finalArray)
      {
         System.out.println(finalInt);
      }
   }
}
