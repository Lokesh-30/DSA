package com.example.leetcodedsa.dsa.queue

fun main() {
    val q = Queue()
    q.enqueue(5)
    q.enqueue(4)
    q.enqueue(3)
    q.dequeue()
    q.enqueue(2)
    q.enqueue(1)
    q.enqueue(-2)
    q.dequeue()
    q.show()
}

class Queue {
    private val queue = IntArray(5)
    private var front = 0
    private var rear = 0
    private var size = 0

    fun enqueue(value: Int) {
        if (isFull())
            throw NoSuchElementException()
        queue[rear] = value
        rear = (rear + 1) % 5
        size++
    }

    fun dequeue(): Int {
        if (isEmpty())
            throw NoSuchElementException()
        val value = queue[front]
        front = (front + 1) % 5
        size--
        return value
    }

    fun size(): Int = size

    fun isEmpty(): Boolean = size == 0

    fun isFull(): Boolean = size == 5

    fun show() {
        for (i in 0 until size) {
            print("${queue[(front + i) % 5]} ")
        }
        println()
    }
}