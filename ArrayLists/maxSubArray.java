/*Problem Statement: Given an array of integers, find the contiguous subarray (containing at least one number) that has the largest sum and return its sum.

This problem can be solved using a variety of techniques, including Kadane's algorithm, dynamic programming, and divide and conquer.*/

public int maxSubArray(int[] nums) {
    int maxSum = nums[0]; // Initialize maxSum with the first element
    int currentSum = nums[0]; // Initialize currentSum with the first element

    for (int i = 1; i < nums.length; i++) {
        // Choose between extending the subarray or starting a new one
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        // Update maxSum if a new maximum is found
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
}

/*
In this problem, you need to handle various cases, such as when the array contains all negative numbers, and when it contains both positive and negative numbers. Solving it optimally requires understanding dynamic programming principles and making appropriate choices at each step.

While this problem is considered challenging, it's just one example. There are many other complex array-related problems that involve advanced algorithms and data structures. As you gain more experience with arrays and coding challenges, you'll encounter a variety of difficult problems to tackle.

  */

  
