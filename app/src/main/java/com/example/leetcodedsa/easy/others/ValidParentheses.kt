package com.example.leetcodedsa.easy.others

/*
fun main() {
    val vp = ValidParentheses()
    println(vp.isValid("()"))
}
*/

// Recursive
// Best Answer
class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s == "")
            return true

        val simplified = s
            .replace("()", "")
            .replace("{}", "")
            .replace("[]", "")

        if (simplified == s)
            return false

        return isValid(simplified)
    }
}