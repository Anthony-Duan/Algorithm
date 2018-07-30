package SortingAdvance.MergeSort;

import java.util.Arrays;

/**
 * @ Description: 归并排序 普通迭代版 时间复杂度O(nlogn)
 * @ Date: Created in 12:08 2018/7/29
 * @ Author: Anthony_Duan
 */
public class MergeSortIteration {

    private MergeSortIteration(){}

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;
        for (int k = l; k <=r ; k++) {
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        /**
         * 迭代的方式是指底而上，递归是自顶向下
         * sz 是每次左右部分中元素的个数
         * 外层循环控制分组
         * 内层循环控制归并
         */
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += sz + sz ) {
                merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }

    // 测试 MergeSort BU
    public static void main(String[] args) {

        // MergeSortIteration 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，MergeSortIteration也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，MergeSortIteration就是一个反例
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSortIteration", arr);

        return;
    }

}
