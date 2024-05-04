package com.example.leetcodedsa.easy.others

/*
fun main() {
    val sq = SquareRoot()
    val res = sq.mySqrt(2147395599)
    println(res)
}
*/

// Best Answer
// Question 69
class SquareRoot {

    /**
     * Binary Search
     * If the square of mid (mid * mid) is equal to x, it means mid is the square root, and the function returns mid.
     * If mid * mid is greater than x, it means the square root lies in the left half. Therefore, r is updated to mid - 1.
     * If mid * mid is less than x, it means the square root lies in the right half. Therefore, l is updated to mid + 1.
     */
    fun mySqrt(x: Int): Int {
        var l = 1
        var r = x
        while (l <= r) {
            val mid = l + (r - l) / 2
            when {
                mid > x / mid -> r = mid - 1
                mid < x / mid -> l = mid + 1
                else -> return mid
            }
        }
        return r
    }
}