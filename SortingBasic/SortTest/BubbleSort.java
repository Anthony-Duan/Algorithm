package SortingBasic.BubbleSort;

/**
 * @ Description:
 * @ Date: Created in 18:58 2018/7/27
 * @ Author: Anthony_Duan
 */
public class BubbleSort2 {

    private BubbleSort2(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    newn = i;
                }
            }
            n = newn;
        } while (newn > 0);
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
