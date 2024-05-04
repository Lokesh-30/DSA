package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val ms = MergeTwoSortedArrays()
    val arr = intArrayOf(4, 5, 6, 0, 0, 0)
    ms.merge(arr, 3, intArrayOf(1, 2, 3), 3)
    println(arr.joinToString())
}
*/

// Best Answer
// Question 88
class MergeTwoSortedArrays {

    /**
     * Go from last in descending order
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m + n - 1  // index for nums1 -> nums1.size - 1
        var first = m - 1  // index for nums1
        var second = n - 1 // index for nums2

        while (second >= 0) {
            nums1[i--] = if (first >= 0 && nums1[first] >= nums2[second])
                nums1[first--]
            else nums2[second--]
        }
    }


}