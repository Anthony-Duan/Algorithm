package SortingAdvance.QuickSort;


/**
 * @ Description: 双路快排 解决的是相同数据过多导致失衡的问题
 * @ Date: Created in 20:53 2018/7/29
 * @ Author: Anthony_Duan
 */
public class QuickSort2Ways {


    private QuickSort2Ways(){}

    private static int partition(Comparable[] arr, int l, int r) {

        //随机选定标定点 针对的是近乎有序序列的优化
        swap( arr, l,(int)(Math.random()*(r-l+1))+l);

        Comparable v = arr[l];

        /**
         * 双路排序的具体实现
         * arr[l+1...i) <= v; arr(j...r] >= v
         * 双路排序是从两端向中间排序，
         * 如果arr[i]小于标定点就让控制小于等于标定点部分边界的i++,此时arr[i]中的元素一定大于等于v
         * 如果arr[j]小于标定点就让控制大于等于标定点部分边界的j--,此时arr[i]中的元素一定小于等于v
         * 当前两个条件都不满足并且i<j的时候，交换arr[i],arr[j]因为此时他们保留的分别是符合对方区间的元素
         * 交换后i，j分别加一
         * 应当注意的是即使 arr[i],arr[j]此时都等于v 他们也会交换元素
         */
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }


    private static void sort(Comparable[] arr, int l, int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSortAdvance.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.QuickSort.QuickSort2Ways", arr);

        return;
    }
}
