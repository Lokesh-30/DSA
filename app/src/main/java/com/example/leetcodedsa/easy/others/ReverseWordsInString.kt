package com.example.leetcodedsa.easy.others

/*
fun main() {
    val rw = ReverseWordsInString()
    val res = rw.reverseWordsTwo("the sky is blue")
    println(res)
}
*/

// Question 151
class ReverseWordsInString {

    // Best Answer
    fun reverseWords(s: String): String {
        val a = s.trim().split(" ")
        var str = ""
        for (i in a.lastIndex downTo 1) {
            if (a[i].isNotEmpty()) {
                str += a[i] + " "
            }
        }
        return str + a[0]
    }

    fun reverseWordsTwo(s: String): String {
        var word = ""
        val arr = arrayListOf<String>()
        for (i in 0..s.lastIndex) {
            if (s[i].isWhitespace()) {
                if (word.isNotEmpty()) {
                    arr.add(word)
                    word = ""
                }
            } else {
                word += s[i]
                if (i == s.lastIndex) {
                    arr.add(word)
                    word = ""
                }
            }
        }
        for (i in arr.lastIndex downTo 1) {
            word += arr[i] + " "
        }
        return word + arr[0]
    }

    // Best Answer
    fun reverseWordsThree(s: String): String {
        val sb = StringBuilder(s.length)
        var wordEnd = s.length
        for (i in s.lastIndex downTo 0) {
            if (s[i] == ' ') {
                if (wordEnd - i > 1) {
                    sb.append(s.substring(i + 1, wordEnd))
                    sb.append(' ')
                }
                wordEnd = i
            }
        }
        if (wordEnd > 0) {
            sb.append(s.substring(0, wordEnd))
        } else {
            sb.setLength(sb.length - 1)
        }

        return sb.toString()
    }
}