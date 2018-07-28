package SortingBasic.InsertionSort;

import java.util.Arrays;

/**
 * @ Description: 算法性能比较
 * @ Date: Created in 12:32 2018/7/27
 * @ Author: Anthony_Duan
 */
public class main {
    public static void main(String[] args) {


        // 比较SelectionSort和InsertionSort两种排序算法的性能效率
        // 此时，插入排序比选择排序性能略低
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort", arr1);
        SortTestHelper.testSort("SortingBasic.InsertionSort.InsertionSortAdvance", arr2);
        return;
    }
}
