package com.example.leetcodedsa.easy.trie

import kotlin.math.max

/*
fun main() {
    val node1 = TreeNode(3)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)
    node3.left = node4
    node3.right = node5
    node1.left = node2
    node1.right = node3
    val md = MaxDepth()
    val res = md.maxDepthTwo(node1)
    println(res)
}
*/

// Question 104
class MaxDepth {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null)
            return 0
        return findDepth(root, 0)
    }

    private fun findDepth(root: TreeNode?,count: Int): Int {
        if (root == null)
            return count

        return max(findDepth(root.left, count + 1), findDepth(root.right, count + 1))
    }

    fun maxDepthTwo(root: TreeNode?): Int {
        if(root == null) return 0

        val left = maxDepthTwo(root.left) + 1
        val right = maxDepthTwo(root.right) + 1

        return max(left, right)
    }
}