package com.example.leetcodedsa.easy.linkedlist

/*
fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(4)
    val node3 = ListNode(6)
    val node4 = ListNode(2)
    val node5 = ListNode(5)
    val node6 = ListNode(9)
    node2.next = node3
    node1.next = node2
    node5.next = node6
    node4.next = node5

    val m = MergeTwoSortedLinkedList()
    val res = m.mergeTwoLists(node1, node4)
    res.show()
}

fun ListNode?.show() {
    var node = this
    for (i in 0..5) {
        println(node?.`val`)
        node = node?.next
    }
}
*/

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Question 21
/**
 * Only for sorted list
 * TC - O(m+n)
 * SC - O(m+n)
 */
class MergeTwoSortedLinkedList {
    // Best Answer
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        // Base cases
        if (l1 == null)
            return l2

        if (l2 == null)
            return l1

        // Conditions
        if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        }
        l2.next = mergeTwoLists(l1, l2.next)
        return l2
    }

    /**
     * Iterator Method
     */
    fun mergeTwoListsIterator(l1: ListNode?, l2: ListNode?): ListNode? {
        val res = ListNode(0)
        var tail = res
        var temp1 = l1
        var temp2 = l2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` <= temp2.`val`) {
                tail.next = temp1
                temp1 = temp1.next
            } else {
                tail.next = temp2
                temp2 = temp2.next
            }
            tail = tail.next!!
        }
        tail.next = temp1 ?: temp2
        return res.next
    }
}