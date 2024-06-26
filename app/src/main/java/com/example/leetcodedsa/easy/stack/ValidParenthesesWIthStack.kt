package com.example.leetcodedsa.easy.stack

import java.util.Stack

/*
fun main() {
    val vp = ValidParenthesesWIthStack()
    println(vp.isValid("{[()]}"))
}
*/

// Stack
class ValidParenthesesWIthStack {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (char in s) {
            when (char) {
                '(', '{', '[' -> stack.push(char)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            }
        }
        return stack.isEmpty()
    }
}