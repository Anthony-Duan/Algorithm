/**
 * @ Description: 希尔排序
 * @ Date: Created in 19:17 2018/7/27
 * @ Author: Anthony_Duan
 */
public class ShellSort {

    private ShellSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;

        int h = 1;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        while (h<h/3){
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {

                
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }
}
