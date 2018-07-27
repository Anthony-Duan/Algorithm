package SortingBasic.InsertionSort;

import SortingBasic.SelectionSortDetectPerformance.SortTestHelper;

/**
 * @ Description:
 * @ Date: Created in 11:39 2018/7/27
 * @ Author: Anthony_Duan
 */
public class SelectionSort {

    private SelectionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    minIndex = j;
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingBasic.SelectionSortDetectPerformance.SelectionSort", arr);

        return;
    }
}
