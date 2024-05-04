package com.example.leetcodedsa.medium.stack

import java.util.Stack

/*
fun main () {
    val da = DestroyingAsteriods()
    val res = da.asteroidsDestroyed(10, intArrayOf(3,9,19,5,21))
    println(res)
}
*/

// Question 2126
class DestroyingAsteriods {

    // Stack Method
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        val stack = Stack<Int>()
        var m = mass.toLong()
        for (a in asteroids) {
            stack.push(a)
            while (stack.isNotEmpty() && m >= stack.peek()) {
                m += stack.pop()
            }
        }
        return stack.empty()
    }

    /**
     * Sort Method
     * Best Answer
     * TC - O(nLogn)
     * SC - O(1)
     */
    fun asteroidsDestroyedTwo(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var m = mass.toLong()
        for (a in asteroids) {
            if (a > m)
                return false
            m += a
        }
        return true
    }
}