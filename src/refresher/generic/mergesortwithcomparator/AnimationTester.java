package refresher.generic.mergesortwithcomparator;

import java.util.Comparator;

public class AnimationTester {
   
   public static void main(String[] args) {

     Integer[] values = new Integer[] {1,2,7,3,5};
     
     Comparator<Integer> comp = new Comparator<Integer>() {
       public int compare(Integer d1, Integer d2) {
         return d1.compareTo(d2);
       }
     };
     
     MergeSort.sort(values, comp);
     
     for (int i = 0; i < values.length; i++){
       System.out.print(values[i]+" ");
     }
     
   }
}
