package liweibo;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 4};

        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);
        System.out.println("排序结果：" + Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if(low < high) {
            // 左边
            mergeSort(nums, low, mid);
            // 右边
            mergeSort(nums, mid + 1, high);
            // 合并
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high) {
            if(nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= high) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }

    }
}
