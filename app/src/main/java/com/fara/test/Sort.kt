package com.fara.test


class Sort(
    val array: IntArray
) : SortImpl {

    override fun bubbleSort() {
        var isSorted = false
        var buffer: Int

        while (!isSorted) {
            isSorted = true

            for (i in 0 until array.size - 1) {
                if (array[i] > array[i + 1]) {
                    isSorted = false
                    buffer = array[i]
                    array[i] = array[i + 1]
                    array[i + 1] = buffer
                }
            }
        }
        println("Bubble: ${array.contentToString()}")
    }

    override fun quickSort() {
        var low = 0
        var high = array.size - 1

        if (low >= high) return

        val middle = low + (high - low) / 2
        val base = array[middle]

        while (low <= high) {
            while (array[low] < base) low++
            while (array[high] > base) high--
            if (low <= high) {
                val temp = array[low]
                array[low] = array[high]
                array[high] = temp
                low++
                high--
            }
        }
        println("Quick: ${array.contentToString()}")
    }

    override fun mergeSort() {
        val result = mergeSortInner(array, 0, array.size)
        println("Merge: ${result.contentToString()}")
    }

    override fun selectionSort() {
        for (i in array.indices) {
            var min = array[i]
            var minId = i

            for (j in i + 1 until array.size) {
                if (array[j] < min) {
                    min = array[j]
                    minId = j
                }
            }

            val temp = array[i]
            array[i] = min
            array[minId] = temp
        }
        println("Selection: ${array.contentToString()}")
    }

    private fun mergeSortInner(
        array: IntArray,
        startIndex: Int,
        endIndex: Int
    ): IntArray {
        if (startIndex >= endIndex - 1) return array

        val buffer = IntArray(array.size)
        val middle = startIndex + (endIndex - startIndex) / 2
        val leftPart = mergeSortInner(array, startIndex, middle)
        val rightPart = mergeSortInner(array, middle, endIndex)

        var indexFromStart = startIndex
        var indexFromMiddle = middle
        var index = startIndex
        val result = if (leftPart.contentEquals(array)) buffer else array

        while (indexFromStart < middle && indexFromMiddle < endIndex) {
            result[index++] =
                if (leftPart[indexFromStart] < rightPart[indexFromMiddle]) leftPart[indexFromStart++]
                else rightPart[indexFromMiddle++]
        }
        while (indexFromStart < middle) result[index++] = leftPart[indexFromStart++]
        while (indexFromMiddle < endIndex) result[index++] = rightPart[indexFromMiddle++]
        return result
    }
}