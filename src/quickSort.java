public class quickSort {
    public static void main(String[] args) {
        quickSort sort = new quickSort();
        int[] arr=new int[]{2,3,5,651,4,6,1,33,77,88,0,999};
        int k=3;
        sort.quickSort(arr,0,arr.length-1,k);
        for(int i= arr.length-1;i>arr.length-1-k;i--){
            System.out.println(arr[i]);
        }

    }
    /**
     * 对数组的l..r快速排序，要前k个
     * O(nlogn)
     */
    private void quickSort(int[] arr, int l, int r, int k) {
        if (l < r) {
            int index = merge(arr, l, r);
            int rightLen = r - index + 1;
            if (rightLen < k) {
                quickSort(arr, l, index - 1, k);
            }
            if (rightLen > k) {
                quickSort(arr, index + 1, r, k);
            }

        }
    }

    /**
     * 让目标元素处在应处的位置
     * 左边的元素都小于 右边的元素都大于
     */
    private int merge(int[] arr, int l, int r) {
        int pivot = arr[r];
        int index = l;
        for (int i = l; i < r; i++) {
            // 碰到小的交换位置
            if (arr[i] < pivot) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index, r);
        return index;
    }


    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
