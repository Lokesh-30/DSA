package com.example.leetcodedsa.medium.trie

import com.example.leetcodedsa.easy.linkedlist.ListNode


fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(-3)
    val node4 = ListNode(3)
    val node5 = ListNode(1)
    node4.next = node5
    node3.next = node4
    node2.next = node3
    node1.next = node2

    val m = RemoveZeroSumConsecutiveNodes()
    val res = m.removeZeroSumSublists(node1)
    println(res)
}

class RemoveZeroSumConsecutiveNodes {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        var prefixSum = 0
        val mp = HashMap<Int, ListNode>()
        val dummy = ListNode(0)
        dummy.next = head
        mp[0] = dummy
        var current = head
        while (current != null) {
            prefixSum += current.`val`
            if (mp.containsKey(prefixSum)) {
                val start = mp[prefixSum]
                var temp = start
                var pSum = prefixSum
                while (temp != current) {
                    temp = temp?.next
                    pSum += temp?.`val` ?: 0
                    if (temp != current)
                        mp.remove(pSum)
                }
                start?.next = current.next
            } else {
                mp[prefixSum] = current
            }
            current = current.next
        }
        return dummy.next
    }

    fun removeZeroSumSublistsTwo(head: ListNode?): ListNode? {
        if (head == null) return head
        var temp = head
        var sum = 0
        while (temp != null) {
            sum += temp.`val`
            if (sum == 0) return removeZeroSumSublistsTwo(temp.next)
            temp = temp.next
        }
        head.next = removeZeroSumSublistsTwo(head.next)
        return head
    }
}