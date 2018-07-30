package SortingAdvance.QuickSort;

/**
 * @ Description: 三路快排 解决的是数据相同导致不平衡的问题
 * @ Date: Created in 21:40 2018/7/29
 * @ Author: Anthony_Duan
 */
public class QuickSort3Ways {

    private QuickSort3Ways(){}


    /**
     * 递归使用快速排序，对arr[l...r]的范围进行排序
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSortAdvance.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);


        /**
         * arr[l+1...lt] < v
         * arr[gt...r] > v
         * arr[lt+1...i) == v
         */
        Comparable v = arr[l];
        int lt = l ;
        int gt = r + 1;
        int i = l + 1;

        //递归终止条件
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            }
            else if (arr[i].compareTo(v) > 0) {
                swap(arr,i,gt-1);
                gt--;
            }else{ // arr[i] == v
                i ++;
            }



        }

        /**
         * 每一轮交换后
         * arr[l...lt-1] < v
         * arr[gt...r] > v
         * arr[lt...i) == v
         */
        swap(arr, i, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
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

    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SortingAdvance.QuickSort.QuickSort3Ways", arr);

        return;
    }
}
