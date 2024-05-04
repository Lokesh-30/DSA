package com.example.leetcodedsa

import com.example.leetcodedsa.dsa.stack.DynamicStack
import com.example.leetcodedsa.dsa.LinkedList
import com.example.leetcodedsa.dsa.stack.Stack
import com.example.leetcodedsa.easy.arrays.CommonPrefix
import com.example.leetcodedsa.easy.arrays.RemoveDuplicates
import com.example.leetcodedsa.easy.arrays.RomanToInt
import com.example.leetcodedsa.easy.arrays.TwoSum
import com.example.leetcodedsa.easy.others.Palindrome

object MainClass {

    @JvmStatic
    fun main(args: Array<String>) {
        val a = TwoSum()
        a.twoSum(intArrayOf(2,7,11,15), 9)

        val pal = Palindrome()
        pal.isPalindrome(12121)

        val rd = RemoveDuplicates()
        val array = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        rd.removeDuplicates(array)

        val ri = RomanToInt()
        ri.romanToInt("MCMXCIV")

        val cp = CommonPrefix()
        cp.longestCommonPrefix(arrayOf("race","racecar","car"))

    }

    private fun practiceLinkedList() {
        val list = LinkedList()
        list.addLast(20)
        list.addLast(30)
        list.addFirst(40)
        list.removeFirst()
        list.addFirst(10)
        list.removeLast()
        list.show()
    }

    private fun practiceStack() {
        val st = Stack()
        st.push(1)
        st.push(2)
        st.push(3)
        st.push(4)
        st.push(4)
        st.show()
    }

    private fun practiceDynamicStack() {
        val st = DynamicStack()
        st.push(1)
        st.push(2)
        st.push(2)
    }
}


// A class to store a Trie node
internal class TrieNode {
    var isLeaf = false // set when the node is a leaf node
    var character: MutableMap<Char, TrieNode> = HashMap()
}


internal object Main {
    // Iterative function to insert a string into a Trie
    private fun insert(head: TrieNode, str: String) {
        // start from the root node
        var curr = head
        for (c in str.toCharArray()) {
            // create a new node if the path doesn't exist
            curr.character.putIfAbsent(c, TrieNode())
            // go to the next node
            curr = curr.character[c]!!
        }
        curr.isLeaf = true
    }

    // Function to find the longest common prefix
    fun findLCP(dict: List<String>): String {
        val head = TrieNode()
        for (s in dict) {
            insert(head, s)
        }

        // traverse the Trie and find the longest common prefix
        val lcp = StringBuilder()
        var curr = head

        // loop until we find a leaf node or a node has more than 1 child
        while (!curr.isLeaf && curr.character.size == 1) {
            for ((key, value) in curr.character) {
                lcp.append(key)
                curr = value
            }
        }
        return lcp.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // given set of keys
        val dict: List<String> = mutableListOf(
            "code", "coder", "coding", "codable", "codec", "codecs", "coded",
            "codeless", "codependence", "codependency", "codependent",
            "codependents", "codes", "codesign", "codesigned", "codeveloped",
            "codeveloper", "codex", "codify", "codiscovered", "codrive"
        )
        println("The longest common prefix is " + findLCP(dict))
    }
}
