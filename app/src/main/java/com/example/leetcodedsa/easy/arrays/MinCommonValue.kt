package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val mcv = MinCommonValue()
    val res = mcv.getCommon(intArrayOf(1, 2, 3), intArrayOf(2, 4))
    println(res)
}
*/

// Question 2540
class MinCommonValue {

    /**
     * Best Answer
     * TC - O(n)
     * SC - O(1)
     */
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == nums2[j] -> {
                    return nums1[i]
                }

                nums1[i] < nums2[j] -> {
                    i++
                }

                else -> j++
            }
        }
        return -1
    }
}