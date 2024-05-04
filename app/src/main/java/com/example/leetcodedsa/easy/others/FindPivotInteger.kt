package com.example.leetcodedsa.easy.others

/*
fun main() {
    val pi = FindPivotInteger()
    val res = pi.pivotInteger(29)
    println(res)
}
*/

// Question 2485
class FindPivotInteger {
    fun pivotInteger(n: Int): Int {
        if (n == 1) return 1
        var pi = n/2
        var left = 0
        var right = 0
        while (pi < n) {
            for (num in 1..pi) {
                left += num
            }
            for (num in pi..n) {
                right += num
            }
            if (left == right)
                return pi

            if (left < right) {
                pi++
                left = 0
                right = 0
            } else return -1
        }
        return -1
    }

    // Best Answer
    fun pivotIntegerTwo(n: Int): Int {
        var rightSum = (1 + n) * n / 2
        var leftSum = 0

        for (i in 1..n) {
            leftSum += i
            if (leftSum == rightSum) return i
            rightSum -= i
        }

        return -1
    }
}