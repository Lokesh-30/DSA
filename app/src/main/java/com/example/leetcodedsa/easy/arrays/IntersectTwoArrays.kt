package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val mcv = IntersectTwoArrays()
    val res = mcv.intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 1))
    println(res)
}
*/

// Question 349
class IntersectTwoArrays {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toHashSet()
        val set2 = nums2.toHashSet()
        return set1.intersect(set2).toIntArray()
    }

    /**
     * Best Answer
     * TC - O(m+n)
     * SC - O(m+n)
     */
    fun intersectionMap(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val res = HashMap<Int, Int>()
        nums1.forEach {
            if (map[it] == null) {
                map[it] = it
            }
        }
        nums2.forEach {
            map[it]?.let { _ ->
                res[it] = it
            }
        }
        return res.keys.toIntArray()
    }
}