package com.example.leetcodedsa.easy.twopointers.oppositedirectional

fun main() {
    val mz = MoveZeros()
    val arr = intArrayOf(0, 0, 1, 7, 0, 11, 15)
    mz.moveZeroesOne(arr)
    println(arr.joinToString())
}

class MoveZeros {

    // Best Answer
    fun moveZeroesOne(nums: IntArray): Unit {
        var curr = 0
        for (i in nums.indices) {
            val value = nums[i]

            if (value != 0) {
                nums[curr++] = value
            }
        }

        for (i in curr until nums.size) {
            nums[i] = 0
        }
    }



    // Snow ball Method
    // Order do not change
    // Best Answer
    fun moveZeroes(nums: IntArray): Unit {
        var snowBallSize = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                snowBallSize++
            } else if (snowBallSize > 0) {
                val t = nums[i]
                nums[i] = 0
                nums[i - snowBallSize] = t
            }
        }
    }
}