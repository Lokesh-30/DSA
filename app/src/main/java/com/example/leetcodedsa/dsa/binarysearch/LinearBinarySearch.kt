package com.example.leetcodedsa.dsa.binarysearch

object LinearBinarySearch {

    private var count = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val numArray = Array(1000) { i -> i }
        val target = 999

        val res = numArray.binarySearch(target, 0, numArray.size)
        println("Inbuilt BS = $res")

        binarySearch(numArray, target)
        linearSearch(numArray, target)
        recursiveBinarySearch(0, numArray.size - 1, numArray, target)

        println("Correct ans = " + numArray.indexOf(target))
    }

    private fun linearSearch(nums: Array<Int>, target: Int): Int {
        for ((count, index) in nums.withIndex()) {
            if (count == target) {
                println("Linear Search index = $index  c = $count")
                return index
            }
        }
        return -1
    }

    private fun binarySearch(numArray: Array<Int>, target: Int): Int {
        var start = 0
        var end = numArray.size - 1
        var count = 0

        while (start <= end) {
            count++
            val targetIndex = (start + end) / 2
            if (numArray[targetIndex] == target) {
                println("Binary Search index = $targetIndex  c = $count")
                return targetIndex
            } else if (numArray[targetIndex] < target) {
                start = targetIndex + 1
            } else {
                end = targetIndex - 1
            }
        }
        return -1
    }

    private fun recursiveBinarySearch(
        start: Int, end: Int, numArray: Array<Int>, target: Int
    ): Int {
        count++
        if (start <= end) {
            val targetIndex = (start + end) / 2
            if (numArray[targetIndex] == target) {
                println("Recursive Binary Search index = $targetIndex  c = $count")
                count = 0
                return targetIndex
            } else if (numArray[targetIndex] < target) {
                recursiveBinarySearch(targetIndex + 1, end, numArray, target)
            } else recursiveBinarySearch(start, targetIndex - 1, numArray, target)
        }
        return -1
    }
}
