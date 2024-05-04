package com.example.leetcodedsa.easy.arrays

class RomanToInt {
    fun romanToInt(s: String): Int {
        val map = mutableMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )
        var res = 0
        for (i in s.lastIndex downTo 0) {
            if (i != s.lastIndex)
                when (s[i]) {
                    'I' -> {
                        if (s[i + 1] == 'V' || s[i + 1] == 'X') {
                            res -= 1
                            continue
                        }
                    }

                    'X' -> {
                        if (s[i + 1] == 'L' || s[i + 1] == 'C') {
                            res -= 10
                            continue
                        }
                    }

                    'C' -> {
                        if (s[i + 1] == 'D' || s[i + 1] == 'M') {
                            res -= 100
                            continue
                        }
                    }
                }
            res += map[s[i]] ?: 0
        }
        return res
    }

    // Best Answer
    fun romanToIntBest(s: String): Int {
        var sum = 0
        var num = 0
        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                'I' -> num = 1
                'V' -> num = 5
                'X' -> num = 10
                'L' -> num = 50
                'C' -> num = 100
                'D' -> num = 500
                'M' -> num = 1000
            }
            if (3 * num < sum) sum -= num
            else sum += num
        }
        return sum
    }
}