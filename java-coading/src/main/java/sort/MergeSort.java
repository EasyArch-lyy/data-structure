package sort;
/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 9, 7, 3, 5, 8, 6};
        mergeSort(a);
        for (int v : a) {
            System.out.println(v);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * @param arr 待排序数组
     * @param L 数组左边界
     * @param R 数组右边界
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        // 获取给定数组中点
        // 求法：  左边界 + 两边界下标 / 2 的值
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * 合并数组，较小的一方数组下标向后移动，自身放入数组
     */
    public static void merge(int[] arr, int L, int M, int R) {
        // 辅助数组
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
