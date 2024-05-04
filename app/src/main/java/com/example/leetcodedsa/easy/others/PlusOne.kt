package com.example.leetcodedsa.easy.others

/*
fun main() {
    val po = PlusOne()
    println(po.plusOne(intArrayOf(4,3,2,1)).joinToString())
}
*/

// Best Answer
// Question 66
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else {
                digits[i] = digits[i].plus(1)
                return digits
            }
        }
        val arr = IntArray(digits.size + 1)
        arr[0] = 1
        return arr
    }
}