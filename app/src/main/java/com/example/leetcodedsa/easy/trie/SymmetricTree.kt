package com.example.leetcodedsa.easy.trie

/*
fun main () {
    val st = SymmetricTree()
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(2)
    val node4 = TreeNode(3)
    val node5 = TreeNode(4)
    val node6 = TreeNode(4)
    val node7 = TreeNode(3)
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7
    node1.left = node2
    node1.right = node3
    st.isSymmetric(node1)
}
*/

/**
 * Best Answer
 * Question 101
 */
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null)
            return true
        return helper(root.left, root.right)
    }

    private fun helper(root: TreeNode?, flip: TreeNode?): Boolean {
        // Same but null
        if (root == null && flip == null)
            return true

        // Only one is null. Easy out, but also prevents numerous null checks
        if (root == null || flip == null)
            return false

        // Aren't equal
        if (root.`val` != flip.`val`)
            return false

        return helper(root.left, flip.right) && helper(root.right, flip.left)
    }
}