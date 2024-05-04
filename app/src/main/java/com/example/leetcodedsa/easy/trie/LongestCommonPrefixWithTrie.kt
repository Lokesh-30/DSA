package com.example.leetcodedsa.easy.trie

fun main() {
    val cp = LongestCommonPrefixWithTrie()
    val res = cp.longestCommonPrefix(arrayOf("flower", "flower", "flower"))
    println(res)
}

// Question 14
// Best Answer
/**
 * Can detect Capital char also
 * Node only has its Child nodes
 */
class LongestCommonPrefixWithTrie {

    class TrieNode {
        var isLeaf = false
        var children = mutableMapOf<Char, TrieNode>()
    }

    // Function to facilitate insertion in Trie
    // If not present, insert the node in the Trie
    private fun insert(key: String, root: TrieNode) {
        var node = root
        key.forEach { c ->
            node.children.putIfAbsent(c, TrieNode())
            node = node.children[c]!!
        }
        node.isLeaf = true
    }

    // Function to construct Trie
    private fun constructTrie(arr: Array<String>, n: Int, root: TrieNode) {
        for (i in 0 until n) {
            insert(arr[i], root)
        }
    }

    // Counts and returns the number of children of the node
    private fun countChildren(root: TrieNode): String {
        var str = ""
        var node = root
        while (!node.isLeaf && node.children.size == 1) {
            str += node.children.keys.first()
            node = node.children.values.first()
        }
        return str
    }

    // Function that returns longest common prefix
    private fun commonPrefix(arr: Array<String>, n: Int, root: TrieNode): String {
        constructTrie(arr, n, root)
        return countChildren(root)
    }


    fun longestCommonPrefix(strs: Array<String>): String {
        return commonPrefix(strs, strs.size, TrieNode())
    }
}

/**
 * Cannot detect Capital char
 * Node has 26 children
 * Node is added using the index
 */
class LongestCommonPrefix {

    private var indexs = 0

    class TrieNode {
        var isLeaf = false
        var children = arrayOfNulls<TrieNode>(26)
    }

    // Function to facilitate insertion in Trie
    // If not present, insert the node in the Trie
    // Uses index to insert the node at a position
    private fun insert(key: String, root: TrieNode) {
        var pCrawl = root
        key.forEach { char ->
            val index = char - 'a'
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = TrieNode()
            }
            pCrawl = pCrawl.children[index]!!
        }
        pCrawl.isLeaf = true
    }

    // Function to construct Trie
    private fun constructTrie(arr: Array<String>, n: Int, root: TrieNode) {
        for (i in 0 until n) {
            insert(arr[i], root)
        }
    }

    // Counts and returns the number of children of the node
    private fun countChildren(node: TrieNode): Int {
        var count = 0
        for (i in 0 until 26) {
            if (node.children[i] != null) {
                count++
                // Keeping track of diversion in the trie
                indexs = i
            }
        }
        return count
    }

    // Perform walk on trie and return longest common prefix
    private fun walkTrie(root: TrieNode): String {
        var pCrawl = root
        var prefix = ""
        while (countChildren(pCrawl) == 1 && !pCrawl.isLeaf) {
            pCrawl = pCrawl.children[indexs]!!
            prefix += ('a' + indexs).toString()
        }
        return prefix
    }

    // Function that returns longest common prefix
    private fun commonPrefix(arr: Array<String>, n: Int, root: TrieNode): String {
        constructTrie(arr, n, root)
        return walkTrie(root)
    }


    fun longestCommonPrefix(strs: Array<String>): String {
        return commonPrefix(strs, strs.size, TrieNode())
    }
}