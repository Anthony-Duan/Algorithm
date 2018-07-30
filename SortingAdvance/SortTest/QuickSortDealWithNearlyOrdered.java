package SortingAdvance.QuickSort;

/**
 * @ Description:快速排序优化
 * 对于近乎有序的序列，如果不进行优化，快速排序每次选择第一个元素作为标定点
 * 就会产生大于与小于标定点的部分几乎没有数据，产生失衡。退化为O(n^2)的复杂度
 * 类似于二叉树的失衡不平衡问题
 * 解决这个问题的方法很简单，就是随机选择标定点，统计意义上这样平均每次都是平衡的
 * （但是这里没有对等于标定点做处理，这是下一个优化点）
 * @ Date: Created in 20:10 2018/7/29
 * @ Author: Anthony_Duan
 */
public class QuickSortDealWithNearlyOrdered {


    private QuickSortDealWithNearlyOrdered(){}

    private static int partition(Comparable[] arr, int l, int r) {


        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    private static void swap(Object[] arr,int i,int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void sort(Comparable[] arr, int l, int r) {

        /**
         * 对于小规模的数组，使用插入排序效率更高
         * 这个可以作为排序算法的通用优化策略
         */
        if (r - l <= 15) {
            InsertionSortAdvance.sort(arr, l, r);
            return ;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.QuickSort.QuickSortDealWithNearlyOrdered", arr);

        return;
    }

}
