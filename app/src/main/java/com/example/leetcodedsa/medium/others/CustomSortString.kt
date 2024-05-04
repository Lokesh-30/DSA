package com.example.leetcodedsa.medium.others

/*
fun main() {
    val cs = CustomSortString()
    cs.customSortString("cba", "abcda")
}
*/

// Question 791
class CustomSortString {

    // Best Answer
    fun customSortString(order: String, s: String): String {
        val map = mutableMapOf<Char, Int>()
        var res = ""
        order.forEach {
            map[it] = 0
        }
        s.forEach {
            map[it] = map.getOrPut(it) { 0 } + 1
        }
        map.forEach {
            it.let { map ->
                repeat(it.value) {
                    res += map.key
                }
            }
        }
        return res
    }
}