package SortingAdvance.QuickSort;


/**
 * @ Description: 快速排序普通版
 * @ Date: Created in 18:44 2018/7/29
 * @ Author: Anthony_Duan
 */
public class QuickSort {

    private QuickSort(){}

    /**
     * 对arr[l..r]部分进行partition操作，
     * 返回p 是得arr[l..p-1]<=[p]  arr[p+1...r]>arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Comparable[] arr, int l, int r) {

        //这里每次取第一个来比较
        Comparable v = arr[l];

        int j = l;
        /**
         * arr[l+1...j] <= v ; arr[j+1...i) > v
         * l是数组的左端点 r是数组的右端点
         * j是小于等于v部分的右端点
         * i是遍历比较的索引
         *
         * 1. 当arr[i]大于v的时候，i++就好了
         * 2. 当arr[i]小于v的时候，将arr[i]与当前arr[j+1]交换
         */
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        //最后 将这一轮比较的元素与j进行交换
        swap(arr, l, j);
        return j;
    }


    /**
     * 递归快速排序 对arr[l...r]的范围进行排序
     * 每一轮确定一个元素的最终位置
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }


    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.QuickSort.QuickSort", arr);

        return;
    }
}
