package com.example.leetcodedsa.easy.others

/*
fun main() {
    val et = EmployeesMeetTarget()
    et.numberOfEmployeesWhoMetTarget(intArrayOf(0,1,2,3,4), 2)
}
*/

/**
 * Question 2798
 * TC - O(n)
 * SC - O(1)
 */
class EmployeesMeetTarget {
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        var count = 0
        for (hour in hours) {
            if (hour >= target)
                count++
        }
        return count
    }

    // Best Answer
    fun numberOfEmployeesWhoMetTargetTwo(hours: IntArray, target: Int): Int = hours.count { it >= target }
}