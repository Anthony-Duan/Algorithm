package SortingAdvance.MergeSort;


import SortingBasic.InsertionSort.InsertionSort;

import java.util.Arrays;

/**
 * @ Description: 归并排序迭代优化版  时间复杂度O(nlogn)
 * @ Date: Created in 13:04 2018/7/29
 * @ Author: Anthony_Duan
 */
public class MergeSortIterationAdvance {

    // 我们的算法类不允许产生任何实例
    private MergeSortIterationAdvance(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 ) {
            InsertionSortAdvance.sort(arr, i, Math.min(i+15, n-1) );
        }

        for( int sz = 16; sz < n ; sz += sz ) {
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
            {
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 ) {
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
                }
            }
        }

    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSortIterationAdvance", arr);

        return;
    }


}
