package Lab_2

import kotlin.random.Random

fun main(args: Array<String>) {
    val array = intArrayOf(4, 2, 12, 8, 7, 5, 9, 3)

    println("Исходный массив: ${array.joinToString(", ")}")

    val sortedArray = array.sortedDescending()

    val evenNumbers = sortedArray.filter { it % 2 == 0 }.toMutableList()
    val oddNumbers = sortedArray.filter { it % 2 != 0 }.toMutableList()

    evenNumbers.shuffle(Random)
    oddNumbers.shuffle(Random)

    val result = mutableListOf<Int>()
    var evenIndex = 0
    var oddIndex = 0

    for (number in sortedArray) {
        if (number % 2 == 0) {
            result.add(evenNumbers[evenIndex])
            evenIndex++
        } else {
            result.add(oddNumbers[oddIndex])
            oddIndex++
        }
    }

    println("Исходный массив: ${array.joinToString(", ")}")
    println("Отсортированный и перемешанный массив: ${result.joinToString(", ")}")
}