package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val si = SearchInsertPosition()
    val res = si.searchInsert(intArrayOf(1, 3, 5, 6), 8)
    println(res)
}
*/

/**
 * Binary Search
 * TC - O(log n)
 * SC - O(1)
 * Question 35
 */
class SearchInsertPosition {

    // Best Answer
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left // Target not found, return the index where it would be inserted
    }
}