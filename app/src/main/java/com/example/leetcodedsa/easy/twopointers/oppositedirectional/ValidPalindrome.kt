package com.example.leetcodedsa.easy.twopointers.oppositedirectional

/*
fun main() {
    val vp = ValidPalindrome()
    println(vp.isPalindrome("A man, a plan, a canal: Panama"))
}
*/

// Best Answer
// Question 125
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var first = 0
        var last = s.length - 1
        while (first < last) {
            while (first < last && !s[first].isLetterOrDigit()) {
                first++
            }
            while (first < last && !s[last].isLetterOrDigit()) {
                last--
            }
            if (!s[first].equals(s[last], true)) {
                return false
            }
            first++
            last--
        }
        return true
    }
}