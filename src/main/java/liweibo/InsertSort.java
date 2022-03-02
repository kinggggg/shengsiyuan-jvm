package liweibo;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1,4};
        iSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void iSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(nums[j] > value) {
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = value;
        }
    }
}
