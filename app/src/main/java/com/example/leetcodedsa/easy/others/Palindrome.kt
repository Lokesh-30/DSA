package com.example.leetcodedsa.easy.others

class Palindrome {

    // Question 9
    fun isPalindrome(x: Int): Boolean {
        val arr = x.toString()
        for (i in 0..arr.length / 2) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}