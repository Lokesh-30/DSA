package com.example.leetcodedsa.easy.dynamicprog

/*
fun main() {
    val pt = PascalsTriangle()
    val res = pt.generate(5)
    println(res)
}
*/

// Question 118
class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val pascal = arrayListOf<List<Int>>()
        for (i in 0 until numRows) {
            val list = arrayListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i)
                    list.add(1)
                else {
                    val preList = pascal[i - 1]
                    list.add(preList[j] + preList[j-1])
                }
            }
            pascal.add(list)
        }
        return pascal
    }
}