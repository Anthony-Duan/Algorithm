package SortingAdvance.MergeSort;

import java.util.Arrays;

/**
 * @ Description: 归并排序递归优化版  时间复杂度 O(nlogn)
 * @ Date: Created in 12:49 2018/7/29
 * @ Author: Anthony_Duan
 */
public class MergeSortRecursionAdvance {


    // 我们的算法类不允许产生任何实例
    private MergeSortRecursionAdvance(){}

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


    private static void sort(Comparable[] arr, int l, int r) {

        //优化2： 对于小规模数组，说那个插入排序
        if (r -l <=15) {
            InsertionSortAdvance.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);


        //优化1：对于arr[mid]<= arr[mid+1]的情况，不进行merge
        // 对于近乎有序的数组非常有效，但是对于一般情况，有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }


    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSortRecursionAdvance", arr);

        return;
    }
}
