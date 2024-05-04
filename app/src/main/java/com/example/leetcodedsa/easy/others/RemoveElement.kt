package com.example.leetcodedsa.easy.others

/*
fun main() {
    val rm = RemoveElement()
    val arr = intArrayOf(3, 2, 2, 3)
    val res = rm.removeElement(arr, 3)
    println(arr.joinToString())
    println(res)
}
*/

// Best Answer
// Question 27
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        nums.forEach {
            if (it != `val`) {
                nums[index] = it
                index++
            }
        }
        return index
    }
}