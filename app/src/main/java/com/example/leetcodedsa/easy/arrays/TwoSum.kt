package com.example.leetcodedsa.easy.arrays

class TwoSum {

    // Question 1
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices){
            map[target - nums[i]]?.let{
                return intArrayOf(i, it)
            }
            map[nums[i]] = i
        }
        throw IllegalStateException("no solution found")
    }
}