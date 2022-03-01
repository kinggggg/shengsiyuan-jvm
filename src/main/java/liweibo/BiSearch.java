package liweibo;

/**
 * 二分查找
 */
public class BiSearch {

    public static void main(String[] args) {

        int target = 5;
        int[] nums = new int[]{1, 2, 3, 4};

        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if(nums[middle] > target) {
                high--;
            }else if (nums[middle] < target) {
                low++;
            }else {
                System.out.println(middle);
                break;
            }
        }
    }
}
