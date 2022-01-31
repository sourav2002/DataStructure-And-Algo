package array;

public class CountEleWithStrictlySmallAndGreater {
    public static void main(String[] args) {
        int[] arr = {11,7,2,15};

        System.out.println(countElements(arr));
    }
    public static int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > min && nums[i] < max) {
                count++;
            }
        }
        return count;
    }
}
