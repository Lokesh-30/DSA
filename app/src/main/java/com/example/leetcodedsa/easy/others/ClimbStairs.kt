package com.example.leetcodedsa.easy.others

/*
fun main() {
    val cs = ClimbStairs()
    println(cs.climbStairs(2))
}
*/

/**
 * TC - O(n)
 * Question 70
 * Fibonacci sequence
 * It is a sequence in which each number is the sum of the two preceding ones
 * F(n) = F(n-1) + F(n-2) for n > 1
 *
 * The last values gives the number of pos
 */
class ClimbStairs {

    // Recursive
    fun climbStairs(n: Int): Int {

        // tailrec -> It allows the compiler to optimize the recursion,
        // ensuring efficient memory usage
        tailrec fun fib(i: Int, first: Int, second: Int): Int {
            return if (i == n)
                first + second
            else fib(i = i + 1, first = second, second = first + second)
        }
        return fib(i = 1, first = 0, second = 1)
    }

    // Iterator
    // SC - O(n)
    fun climbStairsIterator(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }

    // Reduces the SC - O(1)
    fun climbStairsTwo(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var twoBack = 1
        var oneBack = 2
        var curr = 0
        for (i in 2..n) {
            curr = twoBack + oneBack
            twoBack = oneBack
            oneBack = curr
        }
        return curr
    }
}