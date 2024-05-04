package com.example.leetcodedsa.easy.arrays

class RemoveDuplicates {

    // Question 26
    /**
     * As the array is sorted the duplicate must be its next num
     */
    fun removeDuplicates(nums: IntArray): Int {
        var count = 1
        for(i in 1 until nums.size){
            if(nums[i] != nums[i-1]){
                nums[count] = nums[i]
                count++
            }
        }
        return count
    }
}