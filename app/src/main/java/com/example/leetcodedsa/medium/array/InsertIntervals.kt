package com.example.leetcodedsa.medium.array

fun main() {
    val iI = InsertIntervals()
    iI.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
}

class InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var n = newInterval[0]
        var res = Array(intervals.size) { intArrayOf() }
        var ind = 0
        for (i in 0..intervals.lastIndex) {
            val x = intervals[i][0]
            val y = intervals[i][1]

            if (x >= n) {

            }
            res[i] = intArrayOf(x,y)
        }
    }
}