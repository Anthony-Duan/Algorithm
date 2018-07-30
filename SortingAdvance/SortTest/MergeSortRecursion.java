package SortingAdvance.MergeSort;

import java.util.Arrays;

/**
 * @ Description: 归并排序 普通递归版 时间复杂度O(nlogn)
 * @ Date: Created in 11:42 2018/7/29
 * @ Author: Anthony_Duan
 */
public class MergeSortRecursion {

    //不允许实例
    private MergeSortRecursion(){}

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        //拷贝数组，[l,r+1)
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // i是左半部分的索引，j是右半部分的索引，j的歧视索引为mid+1
        int i = l, j = mid + 1;
        //k是比较后得到的较小的元素将要放入原数组的索引 注意k是索引原数组的，i，j是索引拷贝后数组的
        for (int k = l; k <=r ; k++) {
            //如果左半部分的已经全部放到原数组了，将右半部分数组全部依次放入原数组
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            }
            //如果右半部分的已经全部放到原数组了，将左半部分数组全部依次放入原数组
            else if (j > r) {
                arr[k] = aux[i-l];
                i++;
            }
            //如果左半部分取出的元素比较小，那么将左半部分索引取出的元素放入原数组 然后左半部分索引加一
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i-l];
                i++;
            }
            //右半部分取出的元素比较小，那么将右半部分索引取出的元素放入元素放入数组，然后右半部分索引加一
            else {
                arr[k] = aux[j-l];
                j++;
            }
        }
    }


    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr,0,n-1);
    }
    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.MergeSortRecursion.MergeSortRecursion", arr);

        return;
    }
}
