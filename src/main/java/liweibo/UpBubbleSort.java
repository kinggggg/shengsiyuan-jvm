package liweibo;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class UpBubbleSort {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 4, 3};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sort(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return;
        }

        for(int i = 0; i < nums.length; i++) {// 遍历多少个元素
            boolean changed = false;
            for(int j = 0; j < nums.length - i - 1; j++) { // 当前的元素需要遍历多少遍
                if(nums[j+1] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    changed = true;
                }
            }
            if(!changed){
                break;
            }
        }
    }
}
