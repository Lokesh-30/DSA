package com.example.leetcodedsa.easy.arrays

/*
fun main() {
    val mf = MaxFrequency()
    val res = mf.maxFrequencyElements(intArrayOf(1,2,3,4,5))
    println(res)
}
*/

/**
 * Question 3005
 * TC - O(n)
 * SC - O(n)
 */
class MaxFrequency {

    /**
     * Maps Solution
     * Better in Space Complexity than Loops sol
     */
    fun maxFrequencyElements(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var maxFreq = 1
        nums.forEach {
            if (map[it] == null){
                map[it] = 1
            } else {
                map[it]?.let { value ->
                    value.plus(1).let { iValue ->
                        if (iValue > maxFreq)
                            maxFreq = iValue
                        map[it] = iValue
                    }
                }
            }
        }
        return map.filter { it.value == maxFreq }.size * maxFreq
    }

    fun maxFrequencyElementsLoops(nums: IntArray): Int {
        val counts = IntArray(101)
        for (num in nums) {
            counts[num]++
        }
        var maxCount = 0
        var answer = 0
        for (count in counts) {
            if (count > maxCount) {
                maxCount = count
                answer = count
            } else if (count == maxCount) {
                answer += count
            }
        }
        return answer
    }
}