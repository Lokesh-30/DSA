package com.example.leetcodedsa.dsa.stack

class DynamicStack {

    private var capacity = 2
    private var stack = IntArray(capacity)
    private var top = 0

    fun push(value: Int) {
        if (size() == capacity)
            expand()
        stack[top] = value
        top++
    }

    fun pop(): Int {
        if (isEmpty())
            throw NoSuchElementException()
        top--
        val value = stack[top]
        stack[top] = 0
        if (size() <= (capacity/2)/2)
            shrink()
        return value
    }

    fun peek(): Int {
        return stack[top - 1]
    }

    fun size(): Int = top

    fun isEmpty(): Boolean = top == 0

    private fun expand() {
        capacity *= 2
        val array = IntArray(capacity)
        System.arraycopy(stack, 0, array, 0, size())
        stack = array
    }

    private fun shrink() {
        capacity /= 2
        val array = IntArray(capacity)
        System.arraycopy(stack, 0, array, 0, size())
        stack = array
    }

    fun show() {
        stack.forEach {
            print("$it ")
        }
        println()
    }

}