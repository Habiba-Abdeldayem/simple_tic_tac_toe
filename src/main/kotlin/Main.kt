package org.example

import kotlin.math.absoluteValue

val winPatterns = listOf(
    listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // Rows
    listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // Columns
    listOf(0, 4, 8), listOf(2, 4, 6)  // Diagonals
)


fun main() {
    val userInput = readln()
    printGrid(userInput)
    println(determineStatus(userInput))
}

fun printGrid(gridSymbols: String) {
    println("---------")
    gridSymbols.chunked(3).forEach { println("| ${it.toCharArray().joinToString(" ")} |") }
    println("---------")
}

fun determineStatus(gridSymbols: String): String {
    val xCount = gridSymbols.count { it == 'X' }
    val oCount = gridSymbols.count { it == 'O' }

    val xWins = winPatterns.any { pattern -> pattern.all { gridSymbols[it] == 'X' } }
    val oWins = winPatterns.any { pattern -> pattern.all { gridSymbols[it] == 'O' } }

    return when {
        xWins && oWins || (xCount - oCount).absoluteValue > 1 -> "Impossible"
        xWins -> "X wins"
        oWins -> "O wins"
        "_" in gridSymbols -> "Game not finished"
        else -> "Impossible"
    }
}

