package com.jixs.common.util;


import java.util.stream.IntStream;

/**
 * 排序工具类
 */
public class SortUntil {
    /**
     * 归并排序
     *
     * @param low  最低
     * @param high 最高
     * @return 排序好的数组
     */
    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        IntStream.range(0, temp.length).forEach(x -> array[x + low] = temp[x]);
    }

    /**
     * 堆排序
     *
     * @param array 待排序数组
     */
    public static void heapSort(int[] array) {
        int i;
        int len = array.length;
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustment(array, i, len);
        }
        for (i = len - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            adjustment(array, 0, i);
        }
    }

    private static void adjustment(int[] array, int pos, int len) {
        int child = 2 * pos + 1;
        if (child + 1 < len && array[child] < array[child + 1]) {
            child++;
        }
        if (child < len && array[pos] < array[child]) {
            int tmp = array[pos];
            array[pos] = array[child];
            array[child] = tmp;
            adjustment(array, child, len);
        }
    }

    /**
     * 选择排序
     *
     * @param array 待排序数组
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = {1, 3, 4, 2, 6, 7, 9};
//        //归并排序
////        SortUntil.mergeSort(array, 0, array.length - 1);
//        //堆排序
//        SortUntil.heapSort(array);
//        //选择排序
////        SortUntil.selectSort(array);
//        for (int i : array) {
//            System.out.println(i);
//        }
//        String string = new String();
//        if (string == null) {
//
//        }
//
        String ss = "aaaaaa|testRunFlagddddddddaaaaaa|test|dddddd|testRunFlag";
        System.out.print(ss.contains("|testRunFlag"));
    }
}
