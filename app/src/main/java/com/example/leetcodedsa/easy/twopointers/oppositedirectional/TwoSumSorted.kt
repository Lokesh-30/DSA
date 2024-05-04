package com.example.leetcodedsa.easy.twopointers.oppositedirectional

/*
fun main() {
    val tss = TwoSumSorted()
    println(tss.twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
}
*/

// Question 167
// Two Pointers
// Best Answer
class TwoSumSorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var first = 0
        var last = numbers.lastIndex
        while (first < last) {
            val sum = numbers[first] + numbers[last]
            when {
                sum < target -> first++
                sum > target -> last--
                else -> return intArrayOf(first + 1, last + 1)
            }
        }
        return intArrayOf()
    }
}