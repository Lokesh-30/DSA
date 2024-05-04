package com.example.leetcodedsa.easy.twopointers.slidingorequidirectional

/*
fun main() {
    val ms = MaxSumInArray()
    println(ms.getMaxSum(intArrayOf(2,1,5,1,3,2), 3))
}
*/

/**
 * Sliding Window Technique or Eqi-directional
 * TC - O(n)
 */
class MaxSumInArray {
    fun getMaxSum(arr: IntArray, k: Int): Int {
        var maxSum = 0
        var wSum = 0
        for (i in 0 until k) {
            wSum += arr[i]
        }

        for (i in k until arr.lastIndex) {
            wSum += arr[i] - arr[i - k]
            maxSum = wSum.coerceAtLeast(maxSum)
        }

        return maxSum
    }
}