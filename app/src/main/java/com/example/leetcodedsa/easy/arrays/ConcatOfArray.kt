package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val ca = ConcatOfArray()
    val res = ca.getConcatenation(intArrayOf(1,2,3))
    println(res)
}
*/

// Question 1929
// Best Answer
class ConcatOfArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val arr = IntArray(nums.size * 2)
        for (i in 0..nums.lastIndex) {
            arr[i] = nums[i]
            arr[i + nums.size] = nums[i]
        }
        return arr
    }
}