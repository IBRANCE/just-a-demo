package com.zhz.justademo.biz.leetcode;

/**
 * 子数组范围和 https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 */
public class SubArrayRanges {
    
    public static void main(String[] args) {
        SubArrayRanges sar = new SubArrayRanges();

        int[] nums = {1, 2, 3};
        sar.subArrayRanges(nums);
    }


    public long subArrayRanges(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0L;
        }

        long sum = 0;

        int size = nums.length;
        for (int left = 0; left < size; left ++) {
            for (int right = 0; right < size; right ++) {
                sum += nums[right] - nums[left];
            }
        }
        
        return sum;
    }


}
