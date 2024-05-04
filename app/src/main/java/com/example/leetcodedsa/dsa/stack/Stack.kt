package com.example.leetcodedsa.dsa.stack

class Stack {

    private val stack = IntArray(5)
    private var top = 0

    fun push(value: Int) {
        if (stack.size == top)
            throw NoSuchElementException()
        stack[top] = value
        top++
    }

    fun pop(): Int {
        if (isEmpty())
            throw NoSuchElementException()
        top--
        val value = stack[top]
        stack[top] = 0
        return value
    }

    fun peek(): Int {
        return stack[top - 1]
    }

    fun size(): Int = top

    fun isEmpty(): Boolean = top == 0

    fun show() {
        stack.forEach {
            print("$it ")
        }
        println()
    }

}