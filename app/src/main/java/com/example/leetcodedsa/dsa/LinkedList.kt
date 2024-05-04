package com.example.leetcodedsa.dsa

class LinkedList {
    class Node(var value: Int) {
        var next: Node? = null
    }

    private var first: Node? = null
    private var last: Node? = null

    fun addLast(value: Int) {
        val node = Node(value)

        if (isEmpty()){
            first = node
            last = node
        } else {
            last?.next = node
            last = node
        }
    }

    fun addFirst(value: Int) {
        val node = Node(value)

        if (isEmpty()) {
            first = node
            last = node
        } else {
            node.next = first
            first = node
        }
    }

    fun removeFirst(){
        if (isEmpty())
            throw NoSuchElementException()

        if (first == last) {
            first = null
            last = null
            return
        }

        first = first?.next
    }

    fun removeLast() {
        if (isEmpty())
            throw NoSuchElementException()

        if (first == last) {
            first = null
            last = null
            return
        }

        val node = getPrevious(last)
        node?.next = null
        last = node

    }

    private fun getPrevious(node: Node?): Node? {
        var current = first
        while (current?.next != null) {
            if (current.next == node)
                return current
            current = current.next
        }
        return null
    }

    fun indexOf(value: Int): Int {
        var index = 0
        var current = first
        while (current?.next != null) {
            if (current.value == value)
                return index
            current = current.next
            index++
        }
        return -1
    }

    private fun isEmpty(): Boolean {
        return first == null
    }

    fun show() {
        var current = first
        while (current?.next != null) {
            println(current.value)
            current = current.next
        }
        println(current?.value)
    }
}