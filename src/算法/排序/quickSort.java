package 算法.排序;

public class quickSort {
    public static void main(String[] args) {
        quickSort sort = new quickSort();
        int[] arr=new int[]{2,3,5,651,4,6,1,33,77,88,0,999};
        sort.quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private void quickSort(int[] arr, int l, int r) {
        if(l<r){
            int index= partition(arr,l,r);
            quickSort(arr,l,index-1);
            quickSort(arr,index+1,r);
        }
    }

    /**
     * 右边界的值作为target,移动target,使得左边都小于，右边都大于
     * 返回坐标
     *
     */
    private int partition(int[] arr, int l, int r) {
        int target=arr[r];
        int index=l;
        // 将小于target的移到index左边，维护index
        for (int i = l; i <r ; i++) {
            if(arr[i]<target){
                swap(arr,i,index);
                index++;
            }
        }
        // [l,r) index左边的都小于，右边的都大于 交换target
        swap(arr,index,r);
        return index;
    }

    private void swap(int[] arr, int i, int j) {
        if(i==j){
            return;
        }
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
