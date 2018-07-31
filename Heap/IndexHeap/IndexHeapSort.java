package Heap.HeapSort;

import Heap.IndexHeap.IndexMaxHeap;

/**
 * @ Description:
 * @ Date: Created in 11:40 2018/7/31
 * @ Author: Anthony_Duan
 */
public class IndexHeapSort {

    // 我们的算法类不允许产生任何实例
    private IndexHeapSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<Comparable>(n);
        for( int i = 0 ; i < n ; i ++ ) {
            indexMaxHeap.insert( i , arr[i] );
        }

        for( int i = n-1 ; i >= 0 ; i -- ) {
            arr[i] = indexMaxHeap.extractMax();
        }
    }

    // 测试 Index Heap Sort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Heap.HeapSort.IndexHeapSort", arr);

        return;
    }
}
