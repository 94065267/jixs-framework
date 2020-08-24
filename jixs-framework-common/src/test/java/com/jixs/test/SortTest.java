package com.jixs.test;

/**
 * 冒泡排序/选择排序/插入排序/快速排序
 *
 * @author: jixs
 * @date: 2020-08-17
 */
public class SortTest {
    /**
     * 冒泡升序排序
     *
     * @param a 待排序数组
     */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : a) {
            stringBuilder.append(i).append(",");
        }
        System.out.println("冒泡排序结果：" + stringBuilder.subSequence(0, stringBuilder.toString().length() - 1));
    }

    /**
     * 选择升序排序
     *
     * @param a 待排序数组
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : a) {
            stringBuilder.append(i).append(",");
        }
        System.out.println("选择排序结果：" + stringBuilder.subSequence(0, stringBuilder.toString().length() - 1));
    }

    /**
     * 插入升序排序
     *
     * @param a 待排序数组
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            //将a[i]插入到a[i-1]，a[i-2]，a[i-3]……之中
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : a) {
            stringBuilder.append(i).append(",");
        }
        System.out.println("插入排序结果：" + stringBuilder.subSequence(0, stringBuilder.toString().length() - 1));
    }

    /**
     * 快速升序排序
     *
     * @param arr 待排序数组
     */
    public static int[] fastSort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = fastSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = fastSort(arr, j + 1, end);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 10, 5, 5, 7, 6, 10, 8, 4};
        SortTest.bubbleSort(a);

        a = new int[]{1, 3, 2, 10, 5, 5, 7, 6, 10, 8, 4};
        SortTest.selectSort(a);

        a = new int[]{1, 3, 2, 10, 5, 5, 7, 6, 10, 8, 4};
        SortTest.insertSort(a);

        //快速排序递归处理
        a = new int[]{1, 3, 2, 10, 5, 5, 7, 6, 10, 8, 4};
        SortTest.fastSort(a, 0, a.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : a) {
            stringBuilder.append(i).append(",");
        }
        System.out.println("快速排序结果：" + stringBuilder.subSequence(0, stringBuilder.toString().length() - 1));
    }
}
