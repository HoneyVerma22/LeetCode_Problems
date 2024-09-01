class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (nums[i] == 0) {
                // print(" "+count + ""+sum);
                sum =  Math.max(count, sum);
                count = 0;
            }

        }
        if (count > sum) {
            return count;
        }
        return sum;

    }
}