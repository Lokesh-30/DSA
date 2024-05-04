package com.example.leetcodedsa.medium.array

/*
fun main () {
    val pa = ProductArrayExceptSelf()
    val res = pa.productExceptSelf(intArrayOf(1,2,3,4))
    println(res.joinToString())
}
*/

// TC - O(n)
// Question 238
class ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var prefix = 1
        var postfix = 1
        for (i in 0..nums.lastIndex) {
            if (i == 0) {
                res[i] = prefix
            } else {
                prefix *= nums[i - 1]
                res[i] = prefix
            }
        }
        for (i in nums.lastIndex downTo 0) {
            if (i == nums.lastIndex) {
                res[i] *= postfix
            } else {
                postfix *= nums[i + 1]
                res[i] *= postfix
            }
        }
        return res
    }

    // Best Answer
    // Similar but better
    fun productExceptSelfTwo(nums: IntArray): IntArray {
        val outputArray = IntArray(nums.size)
        var productBefore = 1
        var productAfter = 1
        for (index in nums.indices) {
            outputArray[index] = productBefore
            productBefore *= nums[index]
        }
        for (index in nums.indices.reversed()) {
            outputArray[index] *= productAfter
            productAfter *= nums[index]
        }
        return outputArray
    }
}