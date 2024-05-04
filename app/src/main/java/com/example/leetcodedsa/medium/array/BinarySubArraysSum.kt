package com.example.leetcodedsa.medium.array

/*
fun main() {
    val bs = BinarySubArraysSum()
    val res = bs.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2)
    println(res)
}
*/

// Question 930
class BinarySubArraysSum {

    // Best Answer
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        fun helper(target: Int): Int {
            if (target < 0) return 0
            var res = 0
            var sum = 0
            var left = 0
            for (i in 0..nums.lastIndex) {
                sum += nums[i]
                while (sum > target) {
                    sum -= nums[left]
                    left++
                }
                println("${(i - left + 1)}")
                res += (i - left + 1)
            }
            return res
        }
        return helper(goal) - helper(goal - 1)
    }
}