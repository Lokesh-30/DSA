package com.example.leetcodedsa.dsa

import android.util.Log
import java.util.ArrayList

class PracArrays {
    fun main() {
        var arr = Array(5) { i -> i }
        val arr1 = arrayOfNulls<Int>(5)
        Log.i("12345", "Array : ${arr.joinToString()}")

        arr = emptyArray()
        Log.i("12345", "Array : ${arr.joinToString()}")

        // 2D
        val twoDArray = Array(2) { Array(2) { 0 } }
        Log.i("12345", "2DArray : ${twoDArray.contentDeepToString()}")

        //3D
        val threeDArray = Array(3) { Array(3) { Array(3){ i -> i } } }
        Log.i("12345", "2DArray : ${threeDArray.contentDeepToString()}")

        val arrayList = ArrayList<Int>(5)
        arrayList.add(0)
        arrayList.add(1)
        arrayList.add(2)
        arrayList.add(3)
        arrayList.remove(1)
        arrayList.removeAt(0)
        Log.i("12345", "ArrayList: $arrayList")


        val lettersArray = arrayOf("c", "d")
        printAllStrings("a", "b", *lettersArray)

        val list = mutableListOf("a", "i", "e", "o", "u")
        val set = setOf("a", "i")
        val list1 = listOf("a", "e")
        list += list1
        Log.i("12345", "list & set: $list")

        val deque = ArrayDeque(listOf(1, 2, 3))

        deque.addFirst(0)
        deque.addLast(4)
        Log.i("12345", "deque: $deque")

        Log.i("12345", "deque: ${deque.first()}")
        Log.i("12345", "deque: ${deque.last()}")

        deque.removeFirst()
        deque.removeLast()
        Log.i("12345", "deque: $deque")


        val exampleArray = IntArray(5)
        val objArray = exampleArray.toTypedArray()
        Log.i("12345", "array: ${objArray.joinToString()}")
    }

    private fun printAllStrings(vararg strings: String) {
        for (str in strings) {
            Log.i("12345", "print: $str")
        }
    }
}