package com.fara.test

import kotlin.system.measureNanoTime

fun main() {
    val array = intArrayOf(11, 3, 14, 16, 7)
    val sort = Sort(array)

    val bubbleTime = measureNanoTime {
        sort.bubbleSort()
    }

    val quickTime = measureNanoTime {
        sort.quickSort()
    }

    val mergeTime = measureNanoTime {
        sort.mergeSort()
    }

    val selectionTime = measureNanoTime {
        sort.selectionSort()
    }

    println("Bubble time: $bubbleTime")
    println("Quick time: $quickTime")
    println("Merge time: $mergeTime")
    println("Selection time: $selectionTime")
}