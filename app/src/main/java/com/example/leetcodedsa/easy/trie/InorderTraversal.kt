package com.example.leetcodedsa.easy.trie

import java.util.Stack

fun main() {
    val it = InorderTraversal()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    node2.left = node3
    node1.right = node2
    val res = it.inorderTraversal(node1)
    res.forEach{
        print(it)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Question 94
class InorderTraversal {

    // Best Answer
    fun inorderTraversalIterator(root: TreeNode?): List<Int> {
        val mutableList = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var cur: TreeNode? = root
        while (cur != null || stack.isNotEmpty()) {

            // Move to the left-most node of the tree and push them in stack for future traversal
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }

            // Left node
            cur = stack.pop()

            // Parent node
            mutableList.add(cur.`val`)

            // Right node
            cur = cur.right
        }
        return mutableList
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val arr = mutableListOf<Int>()
        inorderRec(root) {
            arr.add(it)
        }
        return arr
    }

    private fun inorderRec(root: TreeNode?, item: (Int) -> Unit) {
        if (root != null) {
            inorderRec(root.left, item)
            item(root.`val`)
            inorderRec(root.right, item)
        }
    }
}