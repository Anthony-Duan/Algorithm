package Heap.HeapSort;


/**
 * @ Description:使用Heapify初始化输出的堆排序
 * @ Date: Created in 08:55 2018/7/31
 * @ Author: Anthony_Duan
 */
public class HeapSortAdvance {

    private HeapSortAdvance(){}

    /**
     * 使用Heapify过程创建堆
     * 此时，创建堆的过程时间复杂度为O(n)，将所有元素一次从堆中取出来实践复杂度为O(nlogn)
     * 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort性能更优, 因为创建堆的性能更优
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeapWithHeapify<Comparable> maxHeapWithHeapify = new MaxHeapWithHeapify<Comparable>(arr);

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeapWithHeapify.extractMax();
        }
    }
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Heap.HeapSort.HeapSortAdvance", arr);

        return;
    }
}
