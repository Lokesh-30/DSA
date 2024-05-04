package com.example.leetcodedsa.easy.others

/*
fun main() {
    val fo = FirstOccurrenceInString()
    println(fo.strStr("mississippi", "issipi"))
}
*/

// Question 28
class FirstOccurrenceInString {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length)
            return -1
        for (i in 0..(haystack.lastIndex - needle.lastIndex)) {
            if (haystack[i] == needle.first()) {
                if (haystack.substring(i, i + needle.length) == needle) {
                    return i
                }
            }
        }
        return -1
    }
}