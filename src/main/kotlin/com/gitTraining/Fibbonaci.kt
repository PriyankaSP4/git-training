package com.gitTraining


fun computeNegativeFibonacci(position: Int): Int {
    if (position >= 0) throw Exception("position must be smaller than zero!")
    val resultIsNegative = position % 2 == 0
    val absoluteResult = computeFibonacciNumber(-position)
    return if (resultIsNegative) (absoluteResult * -1) else absoluteResult
}

fun recursiveFibonacci(initialPosition: Int, left: Int = 0, right: Int = 1, position: Int = initialPosition): Int {
    if (initialPosition == 0) return 0
    if (position == 0) return left
    return if (initialPosition > 0) {
        recursiveFibonacci(initialPosition, right, left + right, position - 1)
    } else {
        recursiveFibonacci(initialPosition, right - left, left, position + 1)
    }
}

fun computeFibonacciNumber(position: Int?, recursion: Boolean = false): Int {
    var notNullPosition = position
    if (notNullPosition == null) {
        notNullPosition = 1
    }
    if (recursion) return recursiveFibonacci(notNullPosition)

    if (notNullPosition == 0) return 0

    if (notNullPosition < 0) {
        val positionIsOdd = notNullPosition % 2 == -1
        return if (positionIsOdd) computeFibonacciNumber(-notNullPosition) else (computeFibonacciNumber(-notNullPosition) * -1)
    }
    var i = 1
    var j = 1

    if (notNullPosition <= 2) return 1


    var currentPosition = 2
    while (currentPosition < notNullPosition) {
        val temp = i
        i = j
        j += temp
        currentPosition++
    }
    return j
}



fun computeFibonacciArray(start: Int, end: Int, efficient: Boolean = false): List<Int> {
    if (!efficient) return (start..end).map { computeFibonacciNumber(it) }
    if (start > end) return listOf()
    if (start == end) return listOf(computeFibonacciNumber(start))
    val output = mutableListOf(computeFibonacciNumber(start), computeFibonacciNumber(start + 1))
    (2..(end - start)).forEach { output.add(output[it - 2] + output[it - 1]) }
    return output
}