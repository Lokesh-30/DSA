package com.example.leetcodedsa.dsa.sorting

object Sorting {
    @JvmStatic
    fun main(args: Array<String>) {
        val list = arrayOf(3,5,1,4,6,2)

        mergeSort(list, 0, list.size - 1)
        println("Merge sort : " + list.joinToString())

        quickSort(list, 0, list.size - 1)
        insertionSort(list)
        bubbleSort(list)
        selectionSort(list)
    }

    private fun bubbleSort(list: Array<Int>) {
        var temp: Int
        for (i in 0 until list.size - 1) {
            for (j in 0 until list.size - i - 1) {
                if (list[j] > list[j + 1]) {
                    temp = list[j + 1]
                    list[j + 1] = list[j]
                    list[j] = temp
                }
            }
        }
        println("Bubble sort : " + list.joinToString())
    }

    private fun selectionSort(list: Array<Int>) {
        var temp: Int
        for (i in 0 until list.size - 1) {
            var minIndex = i
            for (j in i + 1 until list.size) {
                if (list[minIndex] > list[j])
                    minIndex = j
            }
            temp = list[minIndex]
            list[minIndex] = list[i]
            list[i] = temp
        }
        println("Selection sort : " + list.joinToString())
    }

    private fun insertionSort(list: Array<Int>) {
        for (i in 1 until list.size) {
            val key = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = key
        }
        println("Insertion sort : " + list.joinToString())
    }

    private fun quickSort(list: Array<Int>, start: Int, end: Int) {

        fun swap(list: Array<Int>, i: Int, j: Int) {
            val temp = list[j]
            list[j] = list[i]
            list[i] = temp
        }

        fun partition(list: Array<Int>, start: Int, end: Int): Int {
            val pivot = list[end]
            var i = start - 1
            for (j in start until end) {
                if (list[j] < pivot) {
                    i++
                    swap(list, i, j)
                }
            }
            swap(list, i + 1, end)
            return i + 1
        }

        if (start < end) {
            val pi = partition(list, start, end)
            quickSort(list, start, pi - 1)
            quickSort(list, pi + 1, end)
        }
    }

    private fun mergeSort(list: Array<Int>, start: Int, end: Int) {
        if (start < end) {
            val mid: Int = (start + end) / 2
            mergeSort(list, start, mid)
            mergeSort(list, mid + 1, end)
            merge(list, start, mid, end)
        }
    }

    private fun merge(list: Array<Int>, start: Int, mid: Int, end: Int) {

        //take copy of the Arrays to merge
        val lArray = list.sliceArray(IntRange(start, mid))
        val rArray = list.sliceArray(IntRange(mid+1, end))

        var i = 0
        var j = 0
        var k = start

        // Compare the align in the array
        while (i < lArray.size && j < rArray.size) {
            if (lArray[i] <= rArray[j]) {
                list[k] = lArray[i]
                i++
            } else {
                list[k] = rArray[j]
                j++
            }
            k++
        }

        // Add the remaining elements to the array
        while (i < lArray.size) {
            list[k] = lArray[i]
            i++
            k++
        }

        while (j < rArray.size) {
            list[k] = rArray[j]
            j++
            k++
        }
    }
}