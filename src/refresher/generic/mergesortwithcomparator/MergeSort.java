package refresher.generic.mergesortwithcomparator;

import java.util.Comparator;

public class MergeSort {

     public static <E> void sort(E[] a, Comparator<? super E> comp) {
       mergeSort(a, 0, a.length - 1, comp);
     }

     private static <E> void mergeSort(E[] a, int first, int last, Comparator<? super E> comp) {
       if (first == last)
         return;
       int mid = (first + last) / 2;
       // Sort the first and the second half
       mergeSort(a, first, mid, comp);
       mergeSort(a, mid + 1, last, comp);
       merge(a, first, mid, last, comp);
     }

     private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {
       int n = to - from + 1;
       Object[] values = new Object[n];
       int fromValue = from;
       int middleValue = mid + 1;
       int index = 0;

       while (fromValue <= mid && middleValue <= to) {
         if (comp.compare(a[fromValue], a[middleValue]) < 0) {
           values[index] = a[fromValue];
           fromValue++;
         } else {
           values[index] = a[middleValue];
           middleValue++;
         }
         index++;
       }

       while (fromValue <= mid) {
         values[index] = a[fromValue];
         fromValue++;
         index++;
       }
       
       while (middleValue <= to) {
         values[index] = a[middleValue];
         middleValue++;
         index++;
       }

       for (index = 0; index < n; index++)
         a[from + index] = (E) values[index];
     }
}
