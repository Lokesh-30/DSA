package com.example.leetcodedsa.dsa.tree

fun main() {
    val bt = BinaryTree()
    bt.insert(8)
    bt.insert(2)
    bt.insert(5)
    bt.insert(9)
    bt.insert(1)
    println(bt.inOrder().joinToString())
}

class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree {
    private var root: Node? = null
    private var size = 0

    fun insert(data: Int) {
        root = insertRec(root, data)
        size++
    }

    private fun insertRec(root: Node?, data: Int): Node {
        if (root == null) return Node(data)

        if (data < root.data)
            root.left = insertRec(root.left, data)
        else if (data > root.data)
            root.right = insertRec(root.right, data)

        return root
    }

    fun inOrder(): IntArray {
        val arr = IntArray(size)
        var index = 0
        inOrderRec(root) {
            arr[index++] = it
        }
        return arr
    }

    private fun inOrderRec(root: Node?, item: (Int) -> Unit) {
        if (root != null) {
            inOrderRec(root.left, item)
            item(root.data)
            inOrderRec(root.right, item)
        }
    }

    fun preOrder(): IntArray {
        val arr = IntArray(size)
        var index = 0
        preOrderRec(root) {
            arr[index++] = it
        }
        return arr
    }

    private fun preOrderRec(root: Node?, item: (Int) -> Unit) {
        if (root != null) {
            item(root.data)
            preOrderRec(root.left, item)
            preOrderRec(root.right, item)
        }
    }
}