package com.example.leetcodedsa.easy.arrays

class CommonPrefix {

    // Question 14
    // Best Answer
    fun longestCommonPrefix(strs: Array<String>): String {
        strs.sort()
        var solution = ""
        val first = strs[0]
        val last = strs[strs.size - 1]
        for (i in first.indices) {
            if (first[i] == last[i]) {
                solution += first[i]
            } else {
                break
            }
        }
        return solution
    }
}