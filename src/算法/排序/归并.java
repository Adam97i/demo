package 算法.排序;

import java.util.Arrays;

public class 归并 {

    public static void main(String[] args) {
        int a[] = {5, 6, 0, 1, 9};
        归并 demo = new 归并();
        demo.mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

    public void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // 左边有序
            mergeSort(a, l, mid);
            // 右边有序
            mergeSort(a, mid + 1, r);
            // 左右归并
            merge(a, l, mid, r);
        }

    }

    /**
     * 合并两个有序数组  [l,mid] [mid+1,r]
     */
    public  void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 两个数组都有值的情况
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 数组剩余情况
        // 把左边剩余的数移入数组
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int q = 0; q < tmp.length; q++) {
            arr[l + q] = tmp[q];
        }
    }


}